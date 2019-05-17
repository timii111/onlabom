package sample.models;

import sample.enums.ColorType;
import sample.enums.Direction;
import sample.enums.TileType;

import java.io.BufferedReader;
import java.io.IOException;
/**
    Robotot reprezentáló osztály
    Felelős a megfelelő adatainak tárolásáért, valamint a pályán való mozgásáért
 */
public class Robot {

    /** Robot kezdőpozícióa a pályán */
    private Coords startPosition;
    /** Robot aktuális pozíciója a pályán */
    private Coords actualPosition;
    /** robot színe */
    private ColorType color;
    /** Irány, amerre a robot néz */
    private Direction myDirection;
    /**
        aktuális játéktábla
        ezen mozog a robot
     */
    private Board myBoard;


    /**
        konstruktor, amely beolvassa a megfelelő adatokat a fájlból és létrehozza az adattagokat
     */
    public Robot(BufferedReader br){
        String[] splittedLine;
        try{
            splittedLine = br.readLine().split(" ");
            startPosition = new Coords(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]));
            actualPosition = new Coords(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]));
            color = ColorType.NONE;
            myDirection = Direction.DOWN;
        }catch(IOException e){
            e.printStackTrace();
        }
        setMyBoard(br);

    }

    public Direction getMyDirection() {
        return myDirection;
    }

    public void setMyDirection(Direction mydirection) {
        this.myDirection = mydirection;
    }

    public void setMyBoard(BufferedReader br){
        this.myBoard = new Board(br);
    }

    public void setMyBoard(Board b){
        this.myBoard = b;
    }

    public Board getMyBoard() {
        return myBoard;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public ColorType getColor() {
        return color;
    }

    public Coords getActualPosition() {
        return actualPosition;
    }

    /**
        robotot jobbra mozgató fv
        visszatérési értéke megmutatja, sikeres volt e
        nem sikerül, ha kimenne a pályáról vagy vízre lépne
     */
    public boolean goRight(){

        if(actualPosition.right(myBoard)){
            return !(myBoard.getTileType(actualPosition)== TileType.WATER );
        } else return false;

    }
    /**
       robotot balra mozgató fv
       visszatérési értéke megmutatja, sikeres volt e
       nem sikerül, ha kimenne a pályáról vagy vízre lépne
    */
    public boolean goLeft(){

        if(actualPosition.left(myBoard)){
            return !(myBoard.getTileType(actualPosition)==TileType.WATER );
        } else return false;
    }

    /**
       robotot felfelé mozgató fv
       visszatérési értéke megmutatja, sikeres volt e
       nem sikerül, ha kimenne a pályáról vagy vízre lépne
    */
    public boolean goUp(){

        if(actualPosition.top(myBoard)){
            return !(myBoard.getTileType(actualPosition)==TileType.WATER );
        } else return false;
    }

    /**
       robotot lefelé mozgató fv
       visszatérési értéke megmutatja, sikeres volt e
       nem sikerül, ha kimenne a pályáról vagy vízre lépne
    */
    public boolean goDown(){

        if(actualPosition.down(myBoard)){
            return !(myBoard.getTileType(actualPosition)==TileType.WATER );
        } else return false;
    }

    /**
        robotot balra fordító fv
     */
    public void turnLeft() {
        setMyDirection(myDirection.getLeft());
    }

    /**
        robotot jobbra fordító fv
     */
    public void turnRight(){
        setMyDirection(myDirection.getRight());
    }

    /**
        robot újratöltése az aktuális pálya üjrakezdéséhez
        szín, irány alaphelyzetbe állítása
        visszaállítás a kezdpozícióba
     */
    public void reload(){
        actualPosition.setX(startPosition.getX());
        actualPosition.setY(startPosition.getY());
        myDirection = Direction.DOWN;
        color = ColorType.NONE;
    }

}
