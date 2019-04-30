package sample.boardgenerating;

import sample.boardgenerating.languageelements.BoardLanguageBaseVisitor;
import sample.boardgenerating.languageelements.BoardLanguageParser;

public class MyBoardLanguageVisitor extends BoardLanguageBaseVisitor<Object> {

    private String file;
    private int objects;

    public MyBoardLanguageVisitor(){

    }

    @Override
    public Object visitProgram(BoardLanguageParser.ProgramContext ctx) {
        file = "";
        objects = 0;
        visitChildren(ctx);
        file = file.replace("?", objects + ""); //ezígyeléggécsunyi TODO
        return file;
    }

    @Override
    public Object visitStartTile(BoardLanguageParser.StartTileContext ctx) {
        file += ctx.getChild(1) + " " + ctx.getChild(2) + "\n";
        file += "?\n";
        return visitChildren(ctx);
    }

    @Override
    public Object visitSizes(BoardLanguageParser.SizesContext ctx) {
        file += ctx.getChild(1) + " " + ctx.getChild(2) + "\n";
        return visitChildren(ctx);
    }

    @Override
    public Object visitTileCommand(BoardLanguageParser.TileCommandContext ctx) {
        visitChildren(ctx);
        /*String type = ctx.getChild(0).toString();
        //TODO biztos így kell kezelni a nem létező ágat?
        if(ctx.getChild(1) != null) {
            if(type == "path"){
                visit(ctx.getChild(1));
            } else{
                //TODO hibajelzés
            }
        }*/
        file += "\n";
        return "";
    }

    @Override
    public Object visitAddExtra(BoardLanguageParser.AddExtraContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBoardTile(BoardLanguageParser.BoardTileContext ctx) {
        file += ctx.getChild(0);

        return visitChildren(ctx);
    }

    @Override
    public Object visitExtra(BoardLanguageParser.ExtraContext ctx) {
        String str = ctx.getChild(0).getText();
        file += " " + str;
        if(str.equals("key")) objects++;
        return visitChildren(ctx);
    }

    @Override
    public Object visitColor(BoardLanguageParser.ColorContext ctx) {
        file += " " + ctx.getChild(0);
        return visitChildren(ctx);
    }
}
