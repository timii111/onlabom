// Generated from C:/Users/Timi/IdeaProjects/szakdoga/src/sample/boardgenerating\BoardLanguage.g4 by ANTLR 4.7.2
package sample.boardgenerating.languageelements;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BoardLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BoardLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BoardLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#startTile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTile(BoardLanguageParser.StartTileContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#sizes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizes(BoardLanguageParser.SizesContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#tileCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTileCommand(BoardLanguageParser.TileCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#addExtra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExtra(BoardLanguageParser.AddExtraContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#boardTile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoardTile(BoardLanguageParser.BoardTileContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#extra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtra(BoardLanguageParser.ExtraContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardLanguageParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(BoardLanguageParser.ColorContext ctx);
}