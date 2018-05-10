package sample;

import java.awt.*;
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
    private String line;
    private String[] splittedLine;

    private static Play ourInstance;

    public static Play getInstance() {
        if(ourInstance==null){
            return new Play();
        }else {
            return ourInstance;
        }
    }

    private Play() {
        actualPlayer = new Player();


    }

    public void start(){
        loadNextStage();
        //actualBoard.draw();
    }

    public void loadNextStage(){
        fileName = "Board_" + gameNumber + ".txt";
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            actualBoard = new Board(br);

            br.close();
            fr.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
