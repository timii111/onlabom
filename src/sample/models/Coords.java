package sample.models;

public class Coords {

    private int X;
    private int Y;

    public Coords(int a, int b){
        X = a;
        Y = b;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public boolean right(Board b){
        if(X + 1 < b.getWidth()){
            X++;
            return true;
        } else return false;
    }

    public boolean left(Board b){
        if(X > 0){
            X--;
            return true;
        } else return  false;
    }

    public boolean top(Board b){
        if(Y > 0){
            Y--;
            return  true;
        } else return false;
    }

    public boolean down(Board b){
        if( Y + 1 < b.getHeight()){
            Y++;
            return true;
        } else return false;
    }
}
