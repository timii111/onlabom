package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import sample.sample.nyelvLexer;
import sample.sample.nyelvParser;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextArea txtarea;

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private Robot myRobot;

    private Board myBoard;

    public  Controller(){

    }

    public int tileSize = 80;

    /*@FXML
    public void printIt(){

       // Play.getInstance().watch();
        txtarea.setDisable(true);

        goDown();
        goRight();
        goRight();
        goDown();
        goRight();
        goRight();
        goUp();
        goUp();
        goLeft();
    }*/

    @FXML
    public void printIt(){

        txtarea.setDisable(true);

        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        nyelvLexer mylexer = new nyelvLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        nyelvParser myparser = new nyelvParser(tokstr);

        myVisitor mv = new myVisitor(this);
        mv.visit(myparser.program());


    }
    @FXML
    public void loadImages(){

        gc = canvas.getGraphicsContext2D();

        String[][] images = Play.getInstance().start();

        int h = images.length;
        int w = images[0].length;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                Image im = new Image(images[i][j]);
                gc.drawImage(im, j*tileSize, i*tileSize, tileSize,tileSize);
            }
        }

        drawRobot();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        myRobot = Play.getInstance().getMyRobot();
        myBoard = Play.getInstance().getMyBoard();
        loadImages();

    }

    public void deleteAll(ActionEvent actionEvent) {
        txtarea.clear();
    }

    public void reDrawTile(){
        int x = myRobot.getActualPosition().getX();
        int y = myRobot.getActualPosition().getY();

        gc.clearRect(x*tileSize, y*tileSize ,tileSize,tileSize);
        gc.drawImage(new Image(myBoard.getTileType(x, y)),x*tileSize, y*tileSize, tileSize, tileSize);

    }

    public void reloadIt(){
        txtarea.setDisable(false);
        reDrawTile();
        myRobot.reload();
        drawRobot();
    }

    public void drawRobot(){
        gc.drawImage(new Image("pics/ROBOT.png"), myRobot.getActualPosition().getX()*tileSize, myRobot.getActualPosition().getY()*tileSize,tileSize,tileSize);
    }

    public void goRight(){
        reDrawTile();
        myRobot.goRight(myBoard);
        drawRobot();
    }

    public void goDown(){
        reDrawTile();
        myRobot.goDown(myBoard);
        drawRobot();
    }

    public void goUp(){
        reDrawTile();
        myRobot.goUp(myBoard);
        drawRobot();
    }

    public void goLeft(){
        reDrawTile();
        myRobot.goLeft(myBoard);
        drawRobot();
    }
}
