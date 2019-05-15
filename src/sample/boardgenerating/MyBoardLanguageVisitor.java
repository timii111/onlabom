package sample.boardgenerating;

import sample.boardgenerating.languageelements.BoardLanguageBaseVisitor;
import sample.boardgenerating.languageelements.BoardLanguageParser;
import sample.models.Coords;

/**
 * pályageneráló nyelvet feldolgozó visitor osztály
 */
public class MyBoardLanguageVisitor extends BoardLanguageBaseVisitor<Object> {
    /** kimeneti string */
    private String file;
    /** felszedendő objektumok száma */
    private int objects;
    /** pályát szimbolizáló tömb */
    private String[][] fields;

    /** pálya méretei */
    private int size_x;
    private int size_y;

    public MyBoardLanguageVisitor(){}

    /**
     * a nyelvfeldolgozás gyökere. beolvassa a kódot, összeállítja a kimeneti stringet
     */
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

    /**
     * a robot indítási helyét feldolgozó metódus
     */
    @Override
    public Object visitStartTile(BoardLanguageParser.StartTileContext ctx) { //kell a -1 a két koordrendszer közti átváltáshoz
        file += (Integer.parseInt(ctx.getChild(1).getText()) -1) + " " + (Integer.parseInt(ctx.getChild(2).getText()) -1) + "\n";
        file += "?\n"; //ide kerül majd az objektumok száma
        return visitChildren(ctx);
    }

    /**
     * a pálya méreteit kezelő metódus
     * inicializálja a pályát tartalmazó tömböt
     */
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

    /**
     * a pálya végét jelző mezőt kezelő metódus
     * a pálya tömbjében beállítja az értékét
     */
    @Override
    public Object visitEnd(BoardLanguageParser.EndContext ctx){
        int x = Integer.parseInt(ctx.getChild(1).toString());
        int y = Integer.parseInt(ctx.getChild(2).toString());

        fields[x-1][y-1] = "end";
        return null;
    }

    /**
     * meződefiníciókat kezelő metódus
     * hozzáfűzi az extrákat leíró stringeket is
     * beírja a pálya megfelelő mezőjébe a típust
     */
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

    /**
     * pályán található extra objektumok típusát megadó metódus
     */
    @Override
    public String visitAddExtra(BoardLanguageParser.AddExtraContext ctx) {
        return ctx.getChild(0).getText() + " " + ctx.getChild(1).getText();
    }

    /**
     * mezőt kezelő metódus
     * a mezőtípus beírása a kimeneti stringbe
     */
    @Override
    public Object visitBoardTile(BoardLanguageParser.BoardTileContext ctx) {
        file += ctx.getChild(0);

        return visitChildren(ctx);
    }

    /**
     * extra objektumokat kezelő metódus
     * számlálja a kulcs objektumok számát
     */
    @Override
    public Object visitExtra(BoardLanguageParser.ExtraContext ctx) {
        String str = ctx.getChild(0).getText();
        file += " " + str;
        if(str.equals("key")) objects++;
        return visitChildren(ctx);
    }

    /**
     * színt kezelő csomópont
     */
    @Override
    public Object visitColor(BoardLanguageParser.ColorContext ctx) {
        file += " " + ctx.getChild(0);
        return visitChildren(ctx);
    }

    /**
     * koordinátákat kezelő csomópont
     */
    @Override
    public Coords visitCoords(BoardLanguageParser.CoordsContext ctx){
        return new Coords(Integer.parseInt(ctx.getChild(0).toString()),Integer.parseInt(ctx.getChild(1).toString()) );
    }
}
