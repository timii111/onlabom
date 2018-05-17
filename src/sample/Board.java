package sample;

import java.io.BufferedReader;
import java.io.IOException;

public class Board {

    private BoardTile[][] board;
    private int height;
    private int width;

    private Robot robot;

    private String[] splittedLine;

    public Board(BufferedReader br){
        try{
            splittedLine = br.readLine().split(" ");
            height = Integer.parseInt(splittedLine[0]);
            width = Integer.parseInt(splittedLine[1]);
            board = new BoardTile[height][width];

            for(int i=0; i<height;i++){
                for(int j=0; j<width;j++){
                    splittedLine = br.readLine().split(" ");
                    board[i][j] = new BoardTile(splittedLine);
                }
            }

            splittedLine = br.readLine().split(" ");
            robot = new Robot(splittedLine);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public Robot getRobot() {
        return robot;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public boolean play(){

        return robot.move();

    }

    //TODO rendes grafikus megjelenítés
    public String[][] draw(){

        String[][] images = new String[height][width];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                images[j][i] = board[j][i].draw();
            }
        }

        return images;

    }

    public String getTileType(int x, int y){
        return board[y][x].draw();
    }

}
