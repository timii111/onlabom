package sample;

public class Player {

    private String name;
    private int stage;
    private int attempt;

    public Player(){
        stage = 0;
        attempt = 0;
    }

    public void setAttempt(){
        attempt++;
    }
}
