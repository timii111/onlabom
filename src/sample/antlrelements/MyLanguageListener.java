// Generated from C:/Users/Timi/IdeaProjects/onlabom/src/sample\MyLanguage.g4 by ANTLR 4.7
package sample.antlrelements;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyLanguageParser}.
 */
public interface MyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#commandlines}.
	 * @param ctx the parse tree
	 */
	void enterCommandlines(MyLanguageParser.CommandlinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#commandlines}.
	 * @param ctx the parse tree
	 */
	void exitCommandlines(MyLanguageParser.CommandlinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(MyLanguageParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(MyLanguageParser.StructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(MyLanguageParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(MyLanguageParser.BranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(MyLanguageParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(MyLanguageParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#cycle}.
	 * @param ctx the parse tree
	 */
	void enterCycle(MyLanguageParser.CycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#cycle}.
	 * @param ctx the parse tree
	 */
	void exitCycle(MyLanguageParser.CycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(MyLanguageParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(MyLanguageParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(MyLanguageParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(MyLanguageParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#goThere}.
	 * @param ctx the parse tree
	 */
	void enterGoThere(MyLanguageParser.GoThereContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#goThere}.
	 * @param ctx the parse tree
	 */
	void exitGoThere(MyLanguageParser.GoThereContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#pushIt}.
	 * @param ctx the parse tree
	 */
	void enterPushIt(MyLanguageParser.PushItContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#pushIt}.
	 * @param ctx the parse tree
	 */
	void exitPushIt(MyLanguageParser.PushItContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#eatIt}.
	 * @param ctx the parse tree
	 */
	void enterEatIt(MyLanguageParser.EatItContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#eatIt}.
	 * @param ctx the parse tree
	 */
	void exitEatIt(MyLanguageParser.EatItContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#getColor}.
	 * @param ctx the parse tree
	 */
	void enterGetColor(MyLanguageParser.GetColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#getColor}.
	 * @param ctx the parse tree
	 */
	void exitGetColor(MyLanguageParser.GetColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#turnLeft}.
	 * @param ctx the parse tree
	 */
	void enterTurnLeft(MyLanguageParser.TurnLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#turnLeft}.
	 * @param ctx the parse tree
	 */
	void exitTurnLeft(MyLanguageParser.TurnLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#turnRight}.
	 * @param ctx the parse tree
	 */
	void enterTurnRight(MyLanguageParser.TurnRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#turnRight}.
	 * @param ctx the parse tree
	 */
	void exitTurnRight(MyLanguageParser.TurnRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(MyLanguageParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(MyLanguageParser.ColorContext ctx);
}