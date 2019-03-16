// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample/boardgenerating\BoardLanguage.g4 by ANTLR 4.7.2
package sample.boardgenerating;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BoardLanguageParser}.
 */
public interface BoardLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BoardLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BoardLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#startTile}.
	 * @param ctx the parse tree
	 */
	void enterStartTile(BoardLanguageParser.StartTileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#startTile}.
	 * @param ctx the parse tree
	 */
	void exitStartTile(BoardLanguageParser.StartTileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#sizes}.
	 * @param ctx the parse tree
	 */
	void enterSizes(BoardLanguageParser.SizesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#sizes}.
	 * @param ctx the parse tree
	 */
	void exitSizes(BoardLanguageParser.SizesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#tileCommand}.
	 * @param ctx the parse tree
	 */
	void enterTileCommand(BoardLanguageParser.TileCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#tileCommand}.
	 * @param ctx the parse tree
	 */
	void exitTileCommand(BoardLanguageParser.TileCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#addExtra}.
	 * @param ctx the parse tree
	 */
	void enterAddExtra(BoardLanguageParser.AddExtraContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#addExtra}.
	 * @param ctx the parse tree
	 */
	void exitAddExtra(BoardLanguageParser.AddExtraContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#boardTile}.
	 * @param ctx the parse tree
	 */
	void enterBoardTile(BoardLanguageParser.BoardTileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#boardTile}.
	 * @param ctx the parse tree
	 */
	void exitBoardTile(BoardLanguageParser.BoardTileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#extra}.
	 * @param ctx the parse tree
	 */
	void enterExtra(BoardLanguageParser.ExtraContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#extra}.
	 * @param ctx the parse tree
	 */
	void exitExtra(BoardLanguageParser.ExtraContext ctx);
	/**
	 * Enter a parse tree produced by {@link BoardLanguageParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(BoardLanguageParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BoardLanguageParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(BoardLanguageParser.ColorContext ctx);
}