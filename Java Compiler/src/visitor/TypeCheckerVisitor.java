package visitor;

import abstree.*;
import abstree.identifier.AbsClassIdentifier;
import abstree.identifier.AbsFieldIdentifier;
import abstree.identifier.AbsLocalIdentifier;
import abstree.literal.*;
import antlr4.JavaBaseVisitor;
import antlr4.JavaParser;
import exception.CompileTimeError;
import resource.Environment;
import struct.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class with which we do type checking and handle abstract syntax tree building over the ANTLR parse tree.
 */
public class TypeCheckerVisitor extends JavaBaseVisitor<Object> {

    /**
     * StructFile input file structure.
     */
    private StructFile file;

    /**
     * StructClass current class being visited.
     */
    private StructClass currentClass;

    /**
     * StructMethod current method being visited.
     */
    private StructMethod currentMethod;

    /**
     * ArrayList of Modifiers used by a class member.
     */
    private ArrayList<Modifier> currentModifiers;

    /**
     * Constructor taking a file structure input.
     * @param file StructFile file structure corresponding to ANTLR parse tree.
     */
    public TypeCheckerVisitor(StructFile file) {
        this.file = file;
    }

    /**
     * Method to visit a class declaration node of the ANTLR parse tree.
     * @param ctx ClassDeclarationContext.
     * @return null.
     */
    @Override
    public Object visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        currentClass = file.getClass(visitIdentifier(ctx.identifier()));
        checkClass(currentClass);
        for (String id: currentClass.getFields().keySet())
            Environment.INSTANCE.addField(currentClass.getField(id));
        visitChildren(ctx);
        Environment.INSTANCE.clearFields();
        return null;
    }

    /**
     * Method to visit a class modifier list node of the ANTLR parse tree.
     * @param ctx ClassModifierListContext.
     * @return ArrayList of class Modifiers.
     */
    @Override
    public ArrayList<Modifier> visitClassModifierList(JavaParser.ClassModifierListContext ctx) {
        ArrayList<Modifier> modifiers = new ArrayList<>();
        for (JavaParser.ClassModifierContext cmc: ctx.classModifier())
            modifiers.add(Modifier.selectMemberModifier(cmc.getText()));
        return modifiers;
    }

    /**
     * Method to visit a class body declaration node of the ANTLR parse tree.
     * @param ctx ClassBodyDeclarationContext.
     * @return null.
     */
    @Override
    public Object visitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
        currentModifiers = visitClassModifierList(ctx.classModifierList());
        visitMemberDeclaration(ctx.memberDeclaration());
        return null;
    }

    /**
     * Method to visit a member declaration node of the ANTLR parse tree.
     * @param ctx MemberDeclarationContext.
     * @return null.
     */
    @Override
    public Object visitMemberDeclaration(JavaParser.MemberDeclarationContext ctx) {
        if (ctx.methodDeclaration() != null)
            visitMethodDeclaration(ctx.methodDeclaration());
        else if (ctx.constructorDeclaration() != null)
            visitConstructorDeclaration(ctx.constructorDeclaration());
        exitMethod();
        return null;
    }

    /**
     * Method to visit a method declaration node of the ANTLR parse tree.
     * @param ctx MethodDeclarationContext.
     * @return null.
     */
    @Override
    public Object visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        if (!currentModifiers.contains(Modifier.STATIC))
            Environment.INSTANCE.addLocal(new StructLocal("this", currentClass));
        ArrayList<StructLocal> paramLocals = visitParameters(ctx.parameters());
        ArrayList<StructType> paramTypes = new ArrayList<>();
        //paramLocals.forEach(pLocal -> paramTypes.add(pLocal.getType()));
        for (StructLocal local: paramLocals) paramTypes.add(local.getType());
        currentMethod = currentClass.getMethod(visitIdentifier(ctx.identifier()), paramTypes);
        for (StructLocal pLocal: paramLocals)
            Environment.INSTANCE.addLocal(pLocal);
        visitMethodBody(ctx.methodBody());
        return null;
    }

    /**
     * Method to visit a constructor declaration node of the ANTLR parse tree.
     * @param ctx ConstructorDeclarationContext.
     * @return null.
     */
    @Override
    public Object visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
        Environment.INSTANCE.addLocal(new StructLocal("this", currentClass));
        ArrayList<StructLocal> paramLocals = visitParameters(ctx.parameters());
        ArrayList<StructType> paramTypes = new ArrayList<>();
        //paramLocals.forEach(pLocal -> paramTypes.add(pLocal.getType()));
        for (StructLocal local: paramLocals) paramTypes.add(local.getType());
        currentMethod = currentClass.getMethod("<init>", paramTypes);
        for (StructLocal pLocal: paramLocals)
            Environment.INSTANCE.addLocal(pLocal);
        if (!hasSuperReference(ctx.methodBody()))
            currentMethod.addStatement(addDefaultSuperCall());
        visitMethodBody(ctx.methodBody());
        return null;
    }

    /**
     * Method to visit a method body node of the ANTLR parse tree.
     * @param ctx MethodBodyContext.
     * @return null.
     */
    @Override
    public Object visitMethodBody(JavaParser.MethodBodyContext ctx) {
        for (JavaParser.StatementContext sc: ctx.statement())
            currentMethod.addStatement(visitStatement(sc));
        if (!currentMethod.hasOuterReturn()) {
            if (currentMethod.getType() == null) currentMethod.addStatement(new AbsReturn(null, currentMethod.getType()));
            else throw new CompileTimeError(currentMethod.getIdentifier() + ":" + currentMethod.getSignature() + " missing return statement");
        }
        return null;
    }

    /**
     * Method to visit a statement node of the ANTLR parse tree.
     * @param ctx StatementContext.
     * @return null.
     */
    @Override
    public AbsStatement visitStatement(JavaParser.StatementContext ctx) {
        if (ctx.localVariableDeclaration() != null)
            return visitLocalVariableDeclaration(ctx.localVariableDeclaration());
        else if (ctx.RETURN() != null)
            return handleReturnStatement(ctx);
        else if (ctx.IF() != null) {
            AbsExpr expr = visitExpression(ctx.expression());
            if (!expr.getType().equals(StructType.getTypeFromIdentifier("boolean")))
                throw new CompileTimeError("incompatible expression for if statement");
            return new AbsIfStatement(expr, visitBlock(ctx.block(0)), visitBlock(ctx.block(1)));
        } else if (ctx.expression() != null)
            return visitExpression(ctx.expression());
        return null;
    }

    /**
     * Method to visit a local variable declaration node of the ANTLR parse tree.
     * @param ctx LocalVariableDeclarationContext.
     * @return AbsVarDeclrList list of variable declarations.
     */
    @Override
    public AbsVarDeclrList visitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
        AbsVarDeclrList varList = new AbsVarDeclrList(visitType(ctx.type()));
        visitLocalDeclarationList(ctx.localDeclarationList(), varList);
        return varList;
    }

    /**
     * Method to visit a local declaration list node of the ANTLR parse tree.
     * @param ctx LocalDeclarationListContext.
     * @param varList AbsVarDeclrList local variable declaration list.
     * @return null.
     */
    public Object visitLocalDeclarationList(JavaParser.LocalDeclarationListContext ctx, AbsVarDeclrList varList) {
        for (JavaParser.LocalDeclarationContext ldc: ctx.localDeclaration())
            varList.addDeclaration(visitLocalDeclaration(ldc, varList.getType()));
        return null;
    }

    /**
     * Method to visit a local declaration node of the ANTLR parse tree.
     * @param ctx LocalDeclarationContext.
     * @param varType StructType type of local.
     * @return AbsVarDeclr new local variable declared.
     */
    public AbsVarDeclr visitLocalDeclaration(JavaParser.LocalDeclarationContext ctx, StructType varType) {
        String identifier = visitIdentifier(ctx.identifier());
        if (Environment.INSTANCE.getVisibleLocal(identifier) != null)
            throw new CompileTimeError("variable " + identifier + " already declared");
        StructLocal newLocal = new StructLocal(identifier, varType);
        Environment.INSTANCE.addLocal(newLocal);
        currentMethod.incrementLocalCount();
        if (ctx.expression() == null)
            return new AbsVarDeclr(identifier, newLocal);
        AbsExpr expr = visitExpression(ctx.expression());
        typeCheck(varType, expr.getType());
        return new AbsVarDeclr(identifier, expr, newLocal);
    }

    /**
     * Method to visit an expression node of the ANTLR parse tree.
     * @param ctx ExpressionContext.
     * @return AbsExpr expression abstract syntax tree node.
     */
    @Override
    public AbsExpr visitExpression(JavaParser.ExpressionContext ctx) {
        if (ctx.methodReference() != null) {
            if (ctx.DOT() == null) return visitMethodReference(ctx.methodReference(), null);
            return visitMethodReference(ctx.methodReference(), visitExpression(ctx.expression().get(0)));
        } else if (ctx.identifier() != null) {
            if (ctx.DOT() == null) return handleIdentifier(ctx.identifier());
            AbsExpr receiver = visitExpression(ctx.expression().get(0));
            AbsFieldIdentifier fieldId = new AbsFieldIdentifier(((StructClass) receiver.getType())
                    .getField(visitIdentifier(ctx.identifier())));
            return new AbsFieldRef(fieldId, receiver);
        } else if (ctx.methodReference() != null) {
            return visitMethodReference(ctx.methodReference(), visitExpression(ctx.expression().get(0)));
        } else if (ctx.bop != null) {
            return handleBinaryOperation(ctx);
        } else if (ctx.ASSIGN() != null) {
            return new AbsAssignment(visitExpression(ctx.expression(0)), visitExpression(ctx.expression(1)));
        } else if (ctx.constructor() != null) {
            return visitConstructor(ctx.constructor());
        } else if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.THIS() != null) {
            return handleThis();
        }
        return null;
    }

    /**
     * Method to handle identifier expressions found within the ANTLR parse tree.
     * @param ctx IdentifierContext.
     * @return AbsExpr identifier expression abstract syntax tree node.
     */
    public AbsExpr handleIdentifier(JavaParser.IdentifierContext ctx) {
        String id = visitIdentifier(ctx);
        if (Environment.INSTANCE.getVisibleLocal(id) != null)
            return new AbsLocalIdentifier(Environment.INSTANCE.getVisibleLocal(id));
        if (Environment.INSTANCE.getVisibleField(id) != null) {
            StructField refField = Environment.INSTANCE.getVisibleField(id);
            AbsExpr receiver = (refField.isStatic()) ?
                    new AbsClassIdentifier(currentClass) :
                    new AbsLocalIdentifier(Environment.INSTANCE.getVisibleLocal("this"));
            return new AbsFieldRef(new AbsFieldIdentifier(refField), receiver);
        } else if (Environment.INSTANCE.getVisibleClass(id) != null)
            return new AbsClassIdentifier(Environment.INSTANCE.getVisibleClass(id));
        else throw new CompileTimeError("identifier " + id + " doesn't exist");
    }

    /**
     * Method to visit a block node of the ANTLR parse tree.
     * @param ctx BlockContext.
     * @return AbsBlock block abstract syntax tree node.
     */
    public AbsBlock visitBlock(JavaParser.BlockContext ctx) {
        if (ctx == null) return null;
        ArrayList<AbsStatement> statements = new ArrayList<>();
        Environment outside = Environment.INSTANCE.clone();
        for (JavaParser.StatementContext sc: ctx.statement()) {
            statements.add(visitStatement(sc));
        }
        Environment.INSTANCE = outside.clone();
        return new AbsBlock(statements);
    }

    /**
     * Method to visit an expression node of the ANTLR parse tree for binary operations.
     * @param ctx ExpressionContext.
     * @return AbsBinaryOp binary operation abstract syntax tree node.
     */
    private AbsBinaryOp handleBinaryOperation(JavaParser.ExpressionContext ctx) {
        AbsExpr left = visitExpression(ctx.expression().get(0));
        AbsExpr right = visitExpression(ctx.expression().get(1));
        if (left.getType().equals(right.getType())
        || (!(left.getType() instanceof StructPrimitive) && right instanceof AbsLiteralNull)
        || (!(right.getType() instanceof StructPrimitive) && left instanceof AbsLiteralNull))
            return new AbsBinaryOp(new ArrayList<>(Arrays.asList(left, right)), ctx.bop.getText());
        throw new CompileTimeError("incompatible types for operation '" + ctx.bop.getText());
    }

    /**
     * Method to get a "this" current object reference for non static methods.
     * @return AbsLocalIdentifier local identifier referred to as "this".
     */
    private AbsLocalIdentifier handleThis() {
        if (currentMethod.getModifiers().contains(Modifier.STATIC))
            throw new CompileTimeError("cannot use 'this' keyword from a static method");
        return new AbsLocalIdentifier(Environment.INSTANCE.getVisibleLocal("this"));
    }

    /**
     * Method to visit a constructor node of the ANTLR parse tree.
     * @param ctx ConstructorContext.
     * @return null.
     */
    @Override
    public AbsConstructor visitConstructor(JavaParser.ConstructorContext ctx) {
        if (ctx.classObjectConstructor() != null)
            return visitClassObjectConstructor(ctx.classObjectConstructor());
        return null;
    }

    /**
     * Method to visit a class object constructor node of the ANTLR parse tree.
     * @param ctx ClassObjectConstructorContext.
     * @return AbsConstructor constructor abstract syntax tree node.
     */
    @Override
    public AbsConstructor visitClassObjectConstructor(JavaParser.ClassObjectConstructorContext ctx) {
        StructClass target = Environment.INSTANCE.getVisibleClass(ctx.type().getText());
        if (target == null) throw new CompileTimeError("type " + ctx.type().getText() + " does not exist");
        ArrayList<AbsExpr> args = visitExpressionList(ctx.expressionList());
        StructMethod currentMethod = target.getMethod("<init>", getTypeListFromArgs(args));
        return new AbsConstructor(target, args, currentMethod);
    }

    /**
     * Method to visit a method reference node of the ANTLR parse tree.
     * @param ctx BlockContext.
     * @param receiver AbsExpr receiver expression.
     * @return AbsMethodCall method call abstract syntax tree node.
     */
    public AbsMethodCall visitMethodReference(JavaParser.MethodReferenceContext ctx, AbsExpr receiver) {
        if (ctx.SUPER() != null) return handleSuperOrThis(ctx, currentClass.getSuperClass());
        if (ctx.THIS() != null) return handleSuperOrThis(ctx, currentClass);
        String identifier = visitIdentifier(ctx.identifier());
        ArrayList<AbsExpr> args = visitExpressionList(ctx.expressionList());
        ArrayList<StructType> argTypes = getTypeListFromArgs(args);
        if ((currentMethod.getModifiers().contains(Modifier.STATIC) && receiver == null)
                || receiver.getClass().equals(AbsClassIdentifier.class)) {
            StructClass rec = (receiver == null) ?
                    currentClass : Environment.INSTANCE.getVisibleClass(((AbsClassIdentifier) receiver).getName());
            return handleStaticCall(rec, identifier, args);
        }
        StructMethod currentMethod = ((StructClass) receiver.getType()).getMethod(identifier, argTypes);
        return new AbsMethodCall(identifier, receiver, currentMethod, args);
    }

    /**
     * Method to visit a method reference node of the ANTLR parse tree to add a super/this special call.
     * @param ctx MethodReferenceContext.
     * @param target StructClass constructor class.
     * @return AbsMethodCall method call abstract syntax tree node.
     */
    public AbsMethodCall handleSuperOrThis(JavaParser.MethodReferenceContext ctx, StructClass target) {
        if (currentMethod.getMethodTree().getStatementCount() > 0)
            throw new CompileTimeError("call to super/this must be first statement in constructor for " + currentClass.getIdentifier());
        ArrayList<AbsExpr> args = visitExpressionList(ctx.expressionList());
        StructMethod constructor = target.getMethod("<init>", getTypeListFromArgs(args));
        if (constructor == null)
            throw new CompileTimeError("constructor " + target.getIdentifier() + " cannot be applied to given types");
        return new AbsMethodCall("<init>",
                new AbsLocalIdentifier(Environment.INSTANCE.getVisibleLocal("this")),
                target, constructor, args);
    }

    /**
     * Method to visit an expression list node of the ANTLR parse tree.
     * @param ctx ExpressionListContext.
     * @return ArrayList of AbsExpr expressions within an expression list.
     */
    @Override
    public ArrayList<AbsExpr> visitExpressionList(JavaParser.ExpressionListContext ctx) {
        ArrayList<AbsExpr> expressions = new ArrayList<>();
        if (ctx == null) return expressions;
        for (JavaParser.ExpressionContext ec: ctx.expression())
            expressions.add(visitExpression(ec));
        return expressions;
    }

    /**
     * Method to visit a literal node of the ANTLR parse tree.
     * @param ctx LiteralContext.
     * @return AbsLiteral literal abstract syntax tree node.
     */
    @Override
    public AbsLiteral visitLiteral(JavaParser.LiteralContext ctx) {
        if (ctx.STRING_LITERAL() != null)
            return new AbsLiteralString(ctx.getText());
        else if (ctx.INTEGER_LITERAL() != null)
            return new AbsLiteralInt(Integer.parseInt(ctx.getText()));
        else if (ctx.BOOLEAN_LITERAL() != null)
            return new AbsLiteralBoolean(Boolean.parseBoolean(ctx.getText()));
        else if (ctx.NULL_LITERAL() != null)
            return new AbsLiteralNull();
        return null;
    }

    /**
     * Method to visit a parameters of the ANTLR parse tree.
     * @param ctx ParametersContext.
     * @return ArrayList of StructLocal method parameters.
     */
    @Override
    public ArrayList<StructLocal> visitParameters(JavaParser.ParametersContext ctx) {
        ArrayList<StructLocal> local = new ArrayList<>();
        for (JavaParser.ParameterContext pc: ctx.parameter())
            local.add(visitParameter(pc));
        return local;
    }

    /**
     * Method to visit a parameter node of the ANTLR parse tree.
     * @param ctx ParameterContext.
     * @return StructLocal local parameter abstract syntax tree node.
     */
    @Override
    public StructLocal visitParameter(JavaParser.ParameterContext ctx) {
        StructLocal newLocal = new StructLocal(visitIdentifier(ctx.identifier()), visitType(ctx.type()));
        return newLocal;
    }

    /**
     * Method to visit an identifier node of the ANTLR parse tree.
     * @param ctx IdentifierContext.
     * @return String identifier text.
     */
    @Override
    public String visitIdentifier(JavaParser.IdentifierContext ctx) {
        return ctx.getText();
    }

    /**
     * Method to visit a type node of the ANTLR parse tree.
     * @param ctx TypeContext.
     * @return StructType type.
     */
    @Override
    public StructType visitType(JavaParser.TypeContext ctx) {
        return StructType.getTypeFromIdentifier(ctx.getText());
    }

    /**
     * Method to exit from a program method, resetting environment locals.
     */
    private void exitMethod() {
        StructLocal.localCount = 0;
        Environment.INSTANCE.clearLocals();
    }

    /**
     * Method to derive a list of types from a list of expressions.
     * @param args ArrayList of input expressions.
     * @return ArrayList of expression types.
     */
    private ArrayList<StructType> getTypeListFromArgs(ArrayList<AbsExpr> args) {
        ArrayList<StructType> types = new ArrayList<>();
        for (AbsExpr expr: args) types.add(expr.getType());
        return types;
    }

    /**
     * Method to type check variable declarations.
     * @param var StructType variable receiver type.
     * @param value StructType value assignment type.
     */
    private void typeCheck(StructType var, StructType value) {
        String declaredPath = (value == null) ? "null" : value.getPath();
        String message = "Can't store " + var.getPath() + " to " + declaredPath;
        if (!var.equals(value) && !(value == null && var instanceof StructClass)) throw new CompileTimeError(message);
    }

    /**
     * Method to type check a class declaration.
     * @param structClass StructClass structure of class to check.
     */
    private void checkClass(StructClass structClass) {
        String id = structClass.getIdentifier();
        if (!id.equals(file.getMainClassName()) && currentClass.getModifiers().contains(Modifier.PUBLIC))
            throw new CompileTimeError("class " + id +" is public, should be declared in a file named " + id + ".java");
        if (!currentClass.getMethods().containsKey("<init>"))
            addDefaultConstructor();
    }

    /**
     * Method to check whether a method has a super reference as its first statement for use in constructors.
     * @param ctx MethodBodyContext.
     * @return Boolean indicating whether a given method has a super call.
     */
    private boolean hasSuperReference(JavaParser.MethodBodyContext ctx) {
        JavaParser.MethodReferenceContext mrc = ctx.statement(0).expression().methodReference();
        return mrc != null && (mrc.SUPER() != null || mrc.THIS() != null);
    }

    /**
     * Method to add a default constructor to a class which has no constructor.
     */
    private void addDefaultConstructor() {
        StructMethod newConstructor = new StructMethod("<init>", new ArrayList<>(Arrays.asList(Modifier.PUBLIC)), null);
        newConstructor.addStatement(addDefaultSuperCall());
        newConstructor.addStatement(new AbsReturn());
        currentClass.addMethod(newConstructor);
        exitMethod();
    }

    /**
     * Method to add a super call to constructors not specified with one.
     * @return AbsMethodCall super class constructor call.
     */
    private AbsMethodCall addDefaultSuperCall() {
        StructClass superClass = currentClass.getSuperClass();
        StructLocal thisLocal = Environment.INSTANCE.getVisibleLocal("this");
        if (thisLocal == null) thisLocal = new StructLocal("this", currentClass);
        return new AbsMethodCall("<init>", new AbsLocalIdentifier(thisLocal), superClass,
                superClass.getMethod("<init>", new ArrayList<StructType>()), new ArrayList<AbsExpr>());
    }

    /**
     * Method to handle static method calls found within the program.
     * @param classId String receiver class identifier.
     * @param methodId String static method identifier.
     * @param args ArrayList of AbsExpr expression arguments.
     * @return AbsMethodCall method call abstract syntax tree node.
     */
    private AbsMethodCall handleStaticCall(StructClass classId, String methodId, ArrayList<AbsExpr> args) {
        StructMethod method = classId.getMethod(methodId, getTypeListFromArgs(args));
        return new AbsMethodCall(methodId, new AbsClassIdentifier(classId), method, args);
    }

    /**
     * Method to handle return statements found within the input code.
     * @param ctx StatementContext.
     * @return AbsStatement new return statement.
     */
    private AbsStatement handleReturnStatement(JavaParser.StatementContext ctx) {
        StructType reqReturnType = currentMethod.getType();
        AbsExpr returnExpression = (ctx != null) ? visitExpression(ctx.expression()) : null;
        if (reqReturnType == reqReturnType || reqReturnType.equals(returnExpression))
            return new AbsReturn(visitExpression(ctx.expression()), currentMethod.getType());
        throw new CompileTimeError("incorrect return statement for method " + currentMethod.getIdentifier() + "." + currentMethod.getSignature());
    }

}