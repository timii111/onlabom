// Generated from C:/Users/Timi/IdeaProjects/onlabom/src/sample\nyelv.g4 by ANTLR 4.7
package sample.sample;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import sample.sample.nyelvParser;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link nyelvParser}.
 */
public interface nyelvListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link nyelvParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(nyelvParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(nyelvParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#commandlines}.
	 * @param ctx the parse tree
	 */
	void enterCommandlines(nyelvParser.CommandlinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#commandlines}.
	 * @param ctx the parse tree
	 */
	void exitCommandlines(nyelvParser.CommandlinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(nyelvParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(nyelvParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(nyelvParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(nyelvParser.BranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(nyelvParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(nyelvParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#cycle}.
	 * @param ctx the parse tree
	 */
	void enterCycle(nyelvParser.CycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#cycle}.
	 * @param ctx the parse tree
	 */
	void exitCycle(nyelvParser.CycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(nyelvParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(nyelvParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(nyelvParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(nyelvParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#goThere}.
	 * @param ctx the parse tree
	 */
	void enterGoThere(nyelvParser.GoThereContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#goThere}.
	 * @param ctx the parse tree
	 */
	void exitGoThere(nyelvParser.GoThereContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#pushIt}.
	 * @param ctx the parse tree
	 */
	void enterPushIt(nyelvParser.PushItContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#pushIt}.
	 * @param ctx the parse tree
	 */
	void exitPushIt(nyelvParser.PushItContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#eatIt}.
	 * @param ctx the parse tree
	 */
	void enterEatIt(nyelvParser.EatItContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#eatIt}.
	 * @param ctx the parse tree
	 */
	void exitEatIt(nyelvParser.EatItContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#getColor}.
	 * @param ctx the parse tree
	 */
	void enterGetColor(nyelvParser.GetColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#getColor}.
	 * @param ctx the parse tree
	 */
	void exitGetColor(nyelvParser.GetColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#turnLeft}.
	 * @param ctx the parse tree
	 */
	void enterTurnLeft(nyelvParser.TurnLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#turnLeft}.
	 * @param ctx the parse tree
	 */
	void exitTurnLeft(nyelvParser.TurnLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#turnRight}.
	 * @param ctx the parse tree
	 */
	void enterTurnRight(nyelvParser.TurnRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#turnRight}.
	 * @param ctx the parse tree
	 */
	void exitTurnRight(nyelvParser.TurnRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link nyelvParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(nyelvParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link nyelvParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(nyelvParser.ColorContext ctx);

}