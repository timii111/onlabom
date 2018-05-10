package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Board {

    private BoardTile[][] board;
    private int height;
    private int width;

    private Robot robot;

    private String[] splittedLine;

    private TextArea txtarea;

    public String str =":)";

    public Board(BufferedReader br){
        try{
            splittedLine = br.readLine().split(" ");
            height = Integer.parseInt(splittedLine[0]);
            width = Integer.parseInt(splittedLine[1]);
            board = new BoardTile[height][width];

            for(int i=0; i<width;i++){
                for(int j=0; j<height;j++){
                    splittedLine = br.readLine().split(" ");
                    board[j][i] = new BoardTile(splittedLine);
                }
            }

            splittedLine = br.readLine().split(" ");
            robot = new Robot(splittedLine);
        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public String draw(){
            String mystring = "";
           /* try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
                Parent root = loader.load();
                TextArea mytxtarea = (TextArea) loader.getNamespace().get("txtarea");*/

                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        mystring = board[j][i].draw(mystring);
                    }
                    mystring+="\n";
                }
           /*     mytxtarea.setText(mystring);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            //txtarea.setText(mystring);
            return mystring;
    }

}
