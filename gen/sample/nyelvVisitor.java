// Generated from C:/Users/Timi/IdeaProjects/onlabom/src/sample\nyelv.g4 by ANTLR 4.7
package sample;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link nyelvParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface nyelvVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link nyelvParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(nyelvParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#commandlines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandlines(nyelvParser.CommandlinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(nyelvParser.StructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(nyelvParser.BranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(nyelvParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycle(nyelvParser.CycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(nyelvParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(nyelvParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#goThere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoThere(nyelvParser.GoThereContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#pushIt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushIt(nyelvParser.PushItContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#eatIt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEatIt(nyelvParser.EatItContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#getColor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetColor(nyelvParser.GetColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#turnLeft}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurnLeft(nyelvParser.TurnLeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#turnRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurnRight(nyelvParser.TurnRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link nyelvParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(nyelvParser.ColorContext ctx);
}