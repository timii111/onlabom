package sample.boardgenerating;

import sample.boardgenerating.languageelements.BoardLanguageBaseVisitor;
import sample.boardgenerating.languageelements.BoardLanguageParser;
import sample.models.Coords;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ErroringBoardLanguageVisitor extends BoardLanguageBaseVisitor<Object> {

    public class ColorExtras{
        public Boolean hasKey;
        public Boolean hasButton;

        public ColorExtras(Boolean k, Boolean b){
            hasKey = k;
            hasButton = b;
        }
    }

    private String errorStr;

    private String[][] fields;

    private Coords size;
    private Coords start;

    private Map<String, ColorExtras> buttons;

    public ErroringBoardLanguageVisitor(){

    }

    @Override
    public Object visitProgram(BoardLanguageParser.ProgramContext ctx)  {

        buttons = new HashMap<>();
        errorStr = "";

        visitChildren(ctx);

        Iterator i = buttons.entrySet().iterator();
        while (i.hasNext()){
            Map.Entry next = (Map.Entry)i.next();
            ColorExtras e = (ColorExtras) next.getValue();
            if(e.hasKey && !e.hasButton){
                //elérhetetlen key, hiba
                errorStr += "elérhetetlen kulcs\n";
            }
        }

        if(!fields[start.getX()][start.getY()].equals("path")){
            //rossz mezőről indulunk, hiba!
            errorStr += "nem út mezőről indul a robot!\n";
        }
        return errorStr;
    }

    @Override
    public Object visitStartTile(BoardLanguageParser.StartTileContext ctx) { //kell a -1 a két koordrendszer közti átváltáshoz
        start = new Coords((Integer.parseInt(ctx.getChild(1).getText()) -1), (Integer.parseInt(ctx.getChild(2).getText()) -1));

        return visitChildren(ctx);
    }

    @Override
    public Object visitSizes(BoardLanguageParser.SizesContext ctx) {
        size = new Coords(Integer.parseInt(ctx.getChild(1).toString()), Integer.parseInt(ctx.getChild(2).toString()));

        fields = new String[size.getX()][size.getY()];
        for(int i=0; i< size.getX() ; i++){
            for(int j=0; j< size.getY(); j++){
                fields[i][j] = "";
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
    public Object visitTileCommand(BoardLanguageParser.TileCommandContext ctx){

        Coords tile = (Coords)visit(ctx.getChild(0));

        String tileType = ctx.getChild(1).getText();

        if(ctx.getChildCount()>2){
            tileType += " " + (String) visit(ctx.getChild(2));
        }

        if(!fields[tile.getX()-1][tile.getY()-1].equals("")){
            errorStr += "mező újradefiniálása\n";

        } else {
            fields[tile.getX()-1][tile.getY()-1] = tileType;
        }

        return "";
    }

    @Override
    public String visitAddExtra(BoardLanguageParser.AddExtraContext ctx) {
        String type = ctx.getChild(0).getText();
        String color = ctx.getChild(1).getText();

        if(!buttons.containsKey(color)) buttons.put(color, new ColorExtras(false, false));

        switch (type){
            case "button":
                buttons.get(color).hasButton = true;
                break;
            case "key":
                buttons.get(color).hasKey = true;
                break;
        }

        return  type + " " + color;
    }

    @Override
    public Object visitBoardTile(BoardLanguageParser.BoardTileContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitExtra(BoardLanguageParser.ExtraContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitColor(BoardLanguageParser.ColorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Coords visitCoords(BoardLanguageParser.CoordsContext ctx){
        return new Coords(Integer.parseInt(ctx.getChild(0).toString()),Integer.parseInt(ctx.getChild(1).toString()) );
    }
}
