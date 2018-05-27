package sample.models;
/**
    Játékost reprezentáló fv
    jelenleg nem használt
    célja, hogy menthetővé váljon a játékállás
 */
public class Player {

    private String name;
    private int stage;
    /**
        próbálkozási kísérletek száma
     */
    private int attempt;

    public Player(){
        stage = 0;
        attempt = 0;
    }

    public void setAttempt(){
        attempt++;
    }
}
