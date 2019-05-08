package sample.boardgenerating;

import sample.boardgenerating.languageelements.BoardLanguageBaseVisitor;
import sample.boardgenerating.languageelements.BoardLanguageParser;
import sample.models.Coords;

public class MyBoardLanguageVisitor extends BoardLanguageBaseVisitor<Object> {

    private String file;
    private int objects;

    private String[][] fields;

    private int size_x;
    private int size_y;

    public MyBoardLanguageVisitor(){

    }

    @Override
    public Object visitProgram(BoardLanguageParser.ProgramContext ctx) {
        file = "";
        objects = 0;
        visitChildren(ctx);

        for(int i=0; i< size_x; i++){
            for(int j=0; j<size_y; j++){
                file += fields[i][j] + "\n";
            }
        }

        file = file.replace("?", objects + "");
        return file;
    }

    @Override
    public Object visitStartTile(BoardLanguageParser.StartTileContext ctx) { //kell a -1 a két koordrendszer közti átváltáshoz
        file += (Integer.parseInt(ctx.getChild(1).getText()) -1) + " " + (Integer.parseInt(ctx.getChild(2).getText()) -1) + "\n";
        file += "?\n";
        return visitChildren(ctx);
    }

    @Override
    public Object visitSizes(BoardLanguageParser.SizesContext ctx) {
        size_x = Integer.parseInt(ctx.getChild(1).toString());
        size_y = Integer.parseInt(ctx.getChild(2).toString());
        file += size_x + " " + size_y + "\n";

        fields = new String[size_x][size_y];
        for(int i=0; i<size_x ; i++){
            for(int j=0; j<size_y; j++){
                fields[i][j] = "water";
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public Object visitEnd(BoardLanguageParser.EndContext ctx){
        int x = Integer.parseInt(ctx.getChild(1).toString());
        int y = Integer.parseInt(ctx.getChild(2).toString());

        fields[x-1][y-1] = "end";
        return null;
    }

    @Override
    public Object visitTileCommand(BoardLanguageParser.TileCommandContext ctx) {

        Coords tile = (Coords)visit(ctx.getChild(0));

        String tileType = ctx.getChild(1).getText();

        if(ctx.getChildCount()>2){
            tileType += " " + (String) visit(ctx.getChild(2));
        }

        fields[tile.getX()-1][tile.getY()-1] = tileType;

        return "";
    }

    @Override
    public String visitAddExtra(BoardLanguageParser.AddExtraContext ctx) {
        return ctx.getChild(0).getText() + " " + ctx.getChild(1).getText();
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

    @Override
    public Coords visitCoords(BoardLanguageParser.CoordsContext ctx){
        return new Coords(Integer.parseInt(ctx.getChild(0).toString()),Integer.parseInt(ctx.getChild(1).toString()) );
    }
}
