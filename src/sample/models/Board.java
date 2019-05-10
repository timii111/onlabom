package sample.models;

import sample.enums.ColorType;
import sample.enums.TileType;

import java.io.BufferedReader;
import java.io.IOException;

/**
    játéktáblát reprezentáló osztály
 .
 */
public class Board {

    /** játéktábla */
    private BoardTile[][] board;
    /** magasság */
    private int height;
    /** szélesség */
    private int width;
    /** pályán összeszedendő objektumok száma */
    private int numberOfObjects;

    /**
        konstruktor
        beolvassa a szüksges adatokat, ebből beállítja  a megfelelő adattagokat
        létrejön a pálya
     */
    public Board(BufferedReader br){
        String[] splittedLine;
        try{
            splittedLine = br.readLine().split(" ");
            numberOfObjects = Integer.parseInt(splittedLine[0]);
            splittedLine = br.readLine().split(" ");
            height = Integer.parseInt(splittedLine[0]);
            width = Integer.parseInt(splittedLine[1]);
            board = new BoardTile[height][width];

            for(int i=0; i<height;i++){
                for(int j=0; j<width;j++){
                    splittedLine = br.readLine().split(" ");
                    board[i][j] = new BoardTile(splittedLine);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    /**
        visszaadja egy tömbben a játéktábla kirajzolásához szükséges típusokat
        megadja, emlyik mező melyik fájl kell, hogy legyen
        kirajzolásnál használatos
        teljes táblát rajzolja
     */
    public String[][] draw(){

        String[][] images = new String[height][width];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                images[j][i] = board[j][i].draw();
            }
        }

        return images;

    }

    /** megadja a keresett mező típusát két koordináta alapján */
    public String getTileType(int x, int y){
        return board[y][x].draw();
    }

    /** megadja a keresett mező típusát koordináta objektum alapján */
    public TileType getTileType(Coords c){
        return board[c.getY()][c.getX()].getType();
    }

    public int getNumberOfObjects() {
        return numberOfObjects;
    }

    /** vosszaadja a keresett táblaelemet */
    public BoardTile getTile(Coords c){
        return board[c.getY()][c.getX()];
    }

    /** beállítja a keresett táblaelemet */
    public void setTile(BoardTile b, Coords c){
        board[c.getY()][c.getX()] = b;
    }

    /**
        táblaelemen lévő objektum megevése
        beállítja az evés utáni új mezőt a helyére
     */
    public void eat(Coords c){
        BoardTile tmp = getTile(c);
        tmp.eat();
        setTile(tmp,c);
    }

    /**
     * a táblán megevett objektum visszaállítása
     * @param c a hely ahová vissza kell állítani a kulcsot
     * @param ct a visszaállított kulcs színe
     */
    public void addEatingObject(Coords c, ColorType ct){
        BoardTile tmp = getTile(c);
        tmp.addEatingObject(ct);
        setTile(tmp,c);
    }
}
