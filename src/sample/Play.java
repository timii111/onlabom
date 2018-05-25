package sample;

import sample.models.Board;
import sample.models.Player;
import sample.models.Robot;

import java.io.*;

public class Play {

    private int gameNumber = 1;
    private int maxGameNumber = 3;
    private Board actualBoard;
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

    public void loadNextStage(){
        fileName = "sample/boards/Board_" + gameNumber + ".txt";
        try{
            //fr = new FileReader(fileName);
            InputStream fr = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            br = new BufferedReader(new InputStreamReader(fr));

            myRobot = new Robot(br);
            actualBoard = myRobot.getMyBoard();

            br.close();
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public boolean next(){
        if(gameNumber==maxGameNumber) return false;
        else{
            gameNumber++;
            loadNextStage();
            return true;
        }
    }
}
