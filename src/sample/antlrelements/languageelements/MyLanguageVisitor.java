// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample\MyLanguage.g4 by ANTLR 4.7.2
package sample.antlrelements.languageelements;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#commandlines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandlines(MyLanguageParser.CommandlinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(MyLanguageParser.StructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(MyLanguageParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(MyLanguageParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycle(MyLanguageParser.CycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(MyLanguageParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(MyLanguageParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#goThere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoThere(MyLanguageParser.GoThereContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#pushIt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushIt(MyLanguageParser.PushItContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#eatIt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEatIt(MyLanguageParser.EatItContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#getColor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetColor(MyLanguageParser.GetColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#turnLeft}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurnLeft(MyLanguageParser.TurnLeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#turnRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurnRight(MyLanguageParser.TurnRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#function_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_def(MyLanguageParser.Function_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(MyLanguageParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#buzzwords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuzzwords(MyLanguageParser.BuzzwordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLanguageParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(MyLanguageParser.ColorContext ctx);
}