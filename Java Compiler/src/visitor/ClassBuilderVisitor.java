package visitor;

import antlr4.JavaBaseVisitor;
import antlr4.JavaParser;
import exception.CompileTimeError;
import resource.Environment;
import struct.*;

import java.util.ArrayList;

/**
 * Class with which we derive the structure of a programs classes, fields and methods before moving onto type checking.
 */
public class ClassBuilderVisitor extends JavaBaseVisitor<Object> {

    /**
     * String name of the main public class of the file.
     */
    private String legalPublicClassName;

    /**
     * Environment instance used by the visitor within each class.
     */
    private Environment environment = Environment.INSTANCE;

    /**
     * String name of the current class being built.
     */
    public String currentClassName;

    /**
     * Constructor taking the input file's public class name.
     * @param legalPublicClassName String public main class name.
     */
    public ClassBuilderVisitor(String legalPublicClassName) {
        this.legalPublicClassName = legalPublicClassName;
    }

    /**
     * Method to visit the input node of the ANTLR parse tree.
     * @param ctx InputContext.
     * @return StructFile new file structure created during the tree visit.
     */
    @Override
    public StructFile visitInput(JavaParser.InputContext ctx) {
        StructFile newFile = new StructFile(legalPublicClassName);
        for (JavaParser.ClassDeclarationContext cdc: ctx.classDeclaration())
            newFile.addClass(visitClassDeclaration(cdc));
        return newFile;
    }

    /**
     * Method to visit the class declaration node of the ANTLR parse tree.
     * @param ctx ClassDeclarationContext.
     * @return StructClass new class structure created during the tree visit.
     */
    @Override
    public StructClass visitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        ArrayList<Modifier> modifiers = visitClassModifierList(ctx.classModifierList());
        if (!modifiers.contains(Modifier.FINAL)) modifiers.add(Modifier.SUPER);
        currentClassName = visitIdentifier(ctx.identifier());
        StructClass newClass = new StructClass(currentClassName, currentClassName, visitSuperClassDeclaration(ctx.superClassDeclaration()), modifiers);
        environment.addVisibleClass(newClass);
        visitClassBody(ctx.classBody(), newClass);
        return newClass;
    }

    /**
     * Method to visit the class modifier list node of the ANTLR parse tree.
     * @param ctx ClassModifierListContext.
     * @return ArrayList of class Modifiers.
     */
    @Override
    public ArrayList<Modifier> visitClassModifierList(JavaParser.ClassModifierListContext ctx) {
        ArrayList<Modifier> modifiers = new ArrayList<>();
        for (JavaParser.ClassModifierContext cmc: ctx.classModifier()) {
            if (ctx.parent.getClass().equals(JavaParser.ClassDeclarationContext.class))
                modifiers.add(Modifier.selectClassModifier(cmc.getText()));
            else
                modifiers.add(Modifier.selectMemberModifier(cmc.getText()));
        }
        return modifiers;
    }

    /**
     * Method to visit the super class declaration node of the ANTLR parse tree.
     * @param ctx SuperClassDeclarationContext.
     * @return StructClass referred to as a super class.
     */
    @Override
    public StructClass visitSuperClassDeclaration(JavaParser.SuperClassDeclarationContext ctx) {
        String superClassIdentifier = (ctx == null) ? "Object" : visitIdentifier(ctx.identifier());
        return environment.getVisibleClass(superClassIdentifier);
    }

    /**
     * Method to visit the class body context node of the ANTLR parse tree.
     * @param ctx ClassBodyContext.
     * @param builtClass StructClass representing the class structure currently being built.
     * @return null.
     */
    public Object visitClassBody(JavaParser.ClassBodyContext ctx, StructClass builtClass) {
        for (JavaParser.ClassBodyDeclarationContext cbdc: ctx.classBodyDeclaration())
            visitClassBodyDeclaration(cbdc, builtClass);
        return null;
    }

    /**
     * Method to visit the class body declaration node of the ANTLR parse tree.
     * @param ctx ClassBodyDeclarationContext.
     * @param newClass StructClass representing the class structure currently being built.
     * @return null.
     */
    public Object visitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx, StructClass newClass) {
        ArrayList<Modifier> modifiers = visitClassModifierList(ctx.classModifierList());
        visitMemberDeclaration(ctx.memberDeclaration(), newClass, modifiers);
        return null;
    }

    /**
     * Method to visit the member declaration node of the ANTLR parse tree.
     * @param ctx MemberDeclarationContext.
     * @param newClass StructClass representing the class structure currently being built.
     * @param modifiers ArrayList of member modifiers.
     * @return null.
     */
    public Object visitMemberDeclaration(JavaParser.MemberDeclarationContext ctx, StructClass newClass, ArrayList<Modifier> modifiers) {
        if (ctx.methodDeclaration() != null)
            newClass.addMethod(visitMethodDeclaration(ctx.methodDeclaration(), modifiers));
        else if (ctx.constructorDeclaration() != null)
            newClass.addMethod(visitConstructorDeclaration(ctx.constructorDeclaration(), modifiers));
        else if (ctx.fieldDeclaration() != null)
            visitLocalVariableDeclaration(ctx.fieldDeclaration().localVariableDeclaration(), newClass, modifiers);
        return null;
    }

    /**
     * Method to visit the local variable declaration node of the ANTLR parse tree for fields declarations.
     * @param ctx LocalVariableDeclarationContext.
     * @param newClass StructClass representing the class structure currently being built.
     * @param modifiers ArrayList of field modifiers.
     * @return null.
     */
    public Object visitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx, StructClass newClass, ArrayList<Modifier> modifiers) {
        StructType type = visitType(ctx.type());
        for (JavaParser.LocalDeclarationContext ldc: ctx.localDeclarationList().localDeclaration())
            newClass.addField(new StructField(visitIdentifier(ldc.identifier()), modifiers, type));
        return null;
    }

    /**
     * Method to visit the constructor declaration node of the ANTLR parse tree.
     * @param ctx ConstructorDeclarationContext.
     * @param modifiers ArrayList of constructor modifiers.
     * @return StructMethod new constructor built.
     */
    public StructMethod visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx, ArrayList<Modifier> modifiers) {
        if (!visitIdentifier(ctx.identifier()).equals(currentClassName))
            throw new CompileTimeError("invalid method declaration; return type required");
        return createMethod("<init>", modifiers, null, visitParameters(ctx.parameters()));
    }

    /**
     * Method to visit the method declaration node of the ANTLR parse tree.
     * @param ctx MethodDeclarationContext.
     * @param modifiers ArrayList of member modifiers.
     * @return StructMethod new method built.
     */
    public StructMethod visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx, ArrayList<Modifier> modifiers) {
        return createMethod(visitIdentifier(ctx.identifier()), modifiers,
                visitReturnType(ctx.returnType()), visitParameters(ctx.parameters()));
    }

    /**
     * Method with which we create a new method structure for methods and constructors of a class.
     * @param identifier String method identifier.
     * @param modifiers ArrayList of method modifiers.
     * @param type StructType method type
     * @param params ArrayList of StructType parameters.
     * @return StructMethod new method built.
     */
    public StructMethod createMethod(String identifier, ArrayList<Modifier> modifiers, StructType type, ArrayList<StructType> params) {
        StructMethod newMethod = new StructMethod(identifier, modifiers, type);
        newMethod.setParameters(params);
        return newMethod;
    }

    /**
     * Method to visit the parameters node of the ANTLR parse tree.
     * @param ctx ParameterContext.
     * @return ArrayList of StructType parameter types.
     */
    @Override
    public ArrayList<StructType> visitParameters(JavaParser.ParametersContext ctx) {
        ArrayList<StructType> local = new ArrayList<>();
        for (JavaParser.ParameterContext pc: ctx.parameter())
            local.add(visitParameter(pc));
        return local;
    }

    /**
     * Method to visit the parameter node of the ANTLR parse tree.
     * @param ctx ParameterContext.
     * @return StructType parameter type.
     */
    @Override
    public StructType visitParameter(JavaParser.ParameterContext ctx) {
        return visitType(ctx.type());
    }

    /**
     * Method to visit the return type node of the ANTLR parse tree.
     * @param ctx ReturnTypeContext.
     * @return StructMethod type of return.
     */
    @Override
    public StructType visitReturnType(JavaParser.ReturnTypeContext ctx) {
        if (ctx.VOID() != null) return null;
        return visitType(ctx.type());
    }

    /**
     * Method to visit the type node of the ANTLR parse tree.
     * @param ctx TypeContext.
     * @return StructType type of sub-tree.
     */
    @Override
    public StructType visitType(JavaParser.TypeContext ctx) {
        return StructType.getTypeFromIdentifier(ctx.getText());
    }

    /**
     * Method to visit the identifier node of the ANTLR parse tree.
     * @param ctx IdentifierContext.
     * @return String identifier text.
     */
    @Override
    public String visitIdentifier(JavaParser.IdentifierContext ctx) {
        return ctx.getText();
    }

}
