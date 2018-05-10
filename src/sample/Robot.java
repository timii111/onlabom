package sample;

public class Robot {
    private int coordX;
    private int coordY;

    public Robot(String[] args){
        coordX = Integer.parseInt(args[0]);
        coordY = Integer.parseInt(args[1]);
    }
}
