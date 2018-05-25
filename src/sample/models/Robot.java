package sample.models;

import sample.enums.ColorType;
import sample.enums.Direction;
import sample.enums.TileType;

import java.io.BufferedReader;
import java.io.IOException;

public class Robot {

    private Coords startPosition;
    private Coords actualPosition;

    private ColorType color;

    private Direction myDirection;

    private Board myBoard;

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

    public void setMyBoard(Board myBoard) {
        this.myBoard = myBoard;
    }

    public void setMyBoard(BufferedReader br){
        this.myBoard = new Board(br);
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

    public void setActualPosition(Coords actualPosition) {
        this.actualPosition = actualPosition;
    }

    public boolean goRight(){

        if(actualPosition.right(myBoard)){
            return !(myBoard.getTileType(actualPosition)== TileType.WATER );
        } else return false;

    }

    public boolean goLeft(){

        if(actualPosition.left(myBoard)){
            return !(myBoard.getTileType(actualPosition)==TileType.WATER );
        } else return false;
    }

    public boolean goUp(){

        if(actualPosition.top(myBoard)){
            return !(myBoard.getTileType(actualPosition)==TileType.WATER );
        } else return false;
    }

    public boolean goDown(){

        if(actualPosition.down(myBoard)){
            return !(myBoard.getTileType(actualPosition)==TileType.WATER );
        } else return false;
    }

    public void turnLeft() {
        setMyDirection(myDirection.getLeft());
    }

    public void turnRight(){
        setMyDirection(myDirection.getRight());
    }

    public void reload(){
        actualPosition.setX(startPosition.getX());
        actualPosition.setY(startPosition.getY());
        myDirection = Direction.DOWN;
        color = ColorType.NONE;
    }

}
