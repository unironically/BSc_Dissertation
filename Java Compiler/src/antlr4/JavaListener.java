// Generated from /home/luke/Programming/FullUnit_1920_LukeBessant/Java Compiler/src/antlr4/Java.g4 by ANTLR 4.8
package antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaParser}.
 */
public interface JavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(JavaParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(JavaParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#superClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSuperClassDeclaration(JavaParser.SuperClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#superClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSuperClassDeclaration(JavaParser.SuperClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classModifierList}.
	 * @param ctx the parse tree
	 */
	void enterClassModifierList(JavaParser.ClassModifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classModifierList}.
	 * @param ctx the parse tree
	 */
	void exitClassModifierList(JavaParser.ClassModifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(JavaParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(JavaParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JavaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JavaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(JavaParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(JavaParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(JavaParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(JavaParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(JavaParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(JavaParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(JavaParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(JavaParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JavaParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JavaParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#localDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclarationList(JavaParser.LocalDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#localDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclarationList(JavaParser.LocalDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#localDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclaration(JavaParser.LocalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#localDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclaration(JavaParser.LocalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(JavaParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(JavaParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#classObjectConstructor}.
	 * @param ctx the parse tree
	 */
	void enterClassObjectConstructor(JavaParser.ClassObjectConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#classObjectConstructor}.
	 * @param ctx the parse tree
	 */
	void exitClassObjectConstructor(JavaParser.ClassObjectConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#arrayConstructor}.
	 * @param ctx the parse tree
	 */
	void enterArrayConstructor(JavaParser.ArrayConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#arrayConstructor}.
	 * @param ctx the parse tree
	 */
	void exitArrayConstructor(JavaParser.ArrayConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(JavaParser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(JavaParser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(JavaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(JavaParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JavaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JavaParser.IdentifierContext ctx);
}