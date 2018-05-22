package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
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
    @FXML
    private Button startBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button againBtn;
    private GraphicsContext gc;
    private Robot myRobot;

    private Board myBoard;

    @FXML
    private Label messageLabel;

    private int objectsEaten = 0;

    public Controller() {

    }

    public int tileSize = 80;


    @FXML
    public void printIt() {

        startBtn.setDisable(true);
        clearBtn.setDisable(true);
        messageLabel.setText("");
        txtarea.setDisable(true);

        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        nyelvLexer mylexer = new nyelvLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        nyelvParser myparser = new nyelvParser(tokstr);

        myVisitor mv = new myVisitor(this);
        mv.visitProgram(myparser.program());
    }

    @FXML
    public void loadImages() {

        gc = canvas.getGraphicsContext2D();

        String[][] images = Play.getInstance().start();

        int h = images.length;
        int w = images[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Image im = new Image(images[i][j]);
                gc.drawImage(im, j * tileSize, i * tileSize, tileSize, tileSize);
            }
        }

        drawRobot();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        myRobot = Play.getInstance().getMyRobot();
        myBoard = Play.getInstance().getMyBoard();
        loadImages();
        objectsEaten = 0;

    }

    public void deleteAll(ActionEvent actionEvent) {
        txtarea.clear();
    }

    public void reDrawTile() {
        int x = myRobot.getActualPosition().getX();
        int y = myRobot.getActualPosition().getY();

        gc.clearRect(x * tileSize, y * tileSize, tileSize, tileSize);

        Image im = new Image(myBoard.getTileType(x, y));
        gc.drawImage(im, x * tileSize, y * tileSize, tileSize, tileSize);

    }

    public void reloadIt() {
        startBtn.setDisable(false);
        clearBtn.setDisable(false);
        messageLabel.setText("");
        txtarea.setDisable(false);
        Play.getInstance().start();

        myRobot.reload();
        loadImages();
        drawRobot();
        objectsEaten = 0;
    }

    public void drawRobot() {
        int rotationAngle = 0;
        switch (myRobot.getMyDirection()) {
            case DOWN:
                rotationAngle = 0;
                break;
            case UP:
                rotationAngle = 180;
                break;
            case LEFT:
                rotationAngle = 90;
                break;
            case RIGHT:
                rotationAngle = -90;
                break;
        }

        gc.save();
        Affine rotate = new Affine();
        rotate.appendRotation(rotationAngle, myRobot.getActualPosition().getX() * tileSize + tileSize / 2, myRobot.getActualPosition().getY() * tileSize + tileSize / 2);
        gc.setTransform(rotate);
        gc.drawImage(new Image("pics/ROBOT_"+myRobot.getColor()+".png"), myRobot.getActualPosition().getX() * tileSize, myRobot.getActualPosition().getY() * tileSize, tileSize, tileSize);
        gc.restore();
    }

    public void invalidInputSignaling() {
        invalidInput();

    }

    public boolean go() {
        switch (myRobot.getMyDirection()) {
            case RIGHT:
                return goRight();
            case LEFT:
                return goLeft();
            case UP:
                return goUp();
            case DOWN:
                return goDown();
        }
        return false;
    }

    public boolean goRight() {
        reDrawTile();
        boolean b = myRobot.goRight();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    private void invalidInput() {
        messageLabel.setText("Valamit elgépeltél, próbáld újra!");
    }

    private void somethingWentWrong() {
        messageLabel.setText("Valamit elrontottál, próbáld újra!");
        //TODO
    }

    public boolean goDown() {
        reDrawTile();
        boolean b = myRobot.goDown();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    public boolean goUp() {
        reDrawTile();
        boolean b = myRobot.goUp();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    public boolean goLeft() {
        reDrawTile();
        boolean b = myRobot.goLeft();
        if (b) {
            drawRobot();
        } else {
            somethingWentWrong();
        }
        return b;
    }

    public void turnRight() {
        reDrawTile();
        myRobot.turnRight();
        drawRobot();
    }

    public void turnLeft() {
        reDrawTile();
        myRobot.turnLeft();
        drawRobot();
    }

    public void ended() {
        if (objectsEaten == myBoard.getNumberOfObjects()) {
            //TODO rendes siker -> szintléptetés és vége ha nincs több

            if(myBoard.getTile(myRobot.getActualPosition()).getType()==TileType.END){
                messageLabel.setText("Gratula, ügyi voltál! :)");
            } else{
                messageLabel.setText(messageLabel.getText() + "Már majdnem kész vagy, de a célban kell befejezned!");
            }
        } else {
            messageLabel.setText(messageLabel.getText() + " Nem sikerült mindent összeszedni, nem teljesítetted a pályát. :(");
        }
    }

    public void pushTile(){
        reDrawTile();
        myRobot.setColor(myBoard.getTile(myRobot.getActualPosition()).push());
        drawRobot();
    }

    public ColorType getRobotColor() {
        return myRobot.getColor();
    }

    public void eatObject(){

        if(getRobotColor()==myBoard.getTile(myRobot.getActualPosition()).getKeyColor()){
            objectsEaten++;
            myBoard.getTile(myRobot.getActualPosition()).eat();
        }
        reDrawTile();
        drawRobot();
    }

    public void erroring() {
        //TODO
        messageLabel.setText("hiba csúszott a rendszerbe");

    }
}
