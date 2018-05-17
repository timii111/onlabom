package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Play {

    private int gameNumber = 1;
    //TODO
    public Board actualBoard;
    private Player actualPlayer;

    private FileReader fr;
    private BufferedReader br;
    private String fileName;

    private static Play ourInstance;

    private Robot myRobot;

    public static Play getInstance() {
        if(ourInstance==null) {
            ourInstance = new Play();
        }
        return ourInstance;
    }

    public Robot getMyRobot(){
        return myRobot;
    }

    public Board getMyBoard(){
        return actualBoard;
    }

    private Play() {
        actualPlayer = new Player();
        loadNextStage();

    }

    public String[][] start(){
        loadNextStage();
        return actualBoard.draw();
    }

    public boolean watch(){

        actualPlayer.setAttempt();
        boolean b = actualBoard.play();

        //Todo jó értéket visszaadni, validálni
        return false;
    }

    public void loadNextStage(){
        fileName = "Board_" + gameNumber + ".txt";
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            actualBoard = new Board(br);
            myRobot = actualBoard.getRobot();

            br.close();
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
