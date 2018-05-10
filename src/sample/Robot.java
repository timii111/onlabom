package sample;

public class Robot {

    private Coords startPosition;
    private Coords actualPosition;

    public Robot(String[] args){
        startPosition = new Coords(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        actualPosition = new Coords(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }

    public boolean move(){



        //TODO megírni
        return false;
    }
}
