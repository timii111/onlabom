package sample;

public class Robot {

    private Coords startPosition;
    private Coords actualPosition;

    private ColorType color;

    private Direction mydirection;

    public Robot(String[] args){
        startPosition = new Coords(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        actualPosition = new Coords(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        color = ColorType.NONE;
        mydirection = Direction.DOWN;
    }

    public Direction getMydirection() {
        return mydirection;
    }

    public void setMydirection(Direction mydirection) {
        this.mydirection = mydirection;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public ColorType getColor() {
        return color;
    }

    public boolean move(){



        //TODO megírni
        return false;
    }

    public Coords getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Coords actualPosition) {
        this.actualPosition = actualPosition;
    }

    public boolean goRight(Board b){
        return actualPosition.right(b);
    }

    public boolean goLeft(Board b){
        return actualPosition.left(b);
    }

    public boolean goUp(Board b){
        return  actualPosition.top(b);
    }

    public boolean goDown(Board b){
        return actualPosition.down(b);
    }

    public void reload(){
        actualPosition.setX(startPosition.getX());
        actualPosition.setY(startPosition.getY());
    }

}
