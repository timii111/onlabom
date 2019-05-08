package sample.controllers;

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
import sample.Play;
import sample.antlrelements.MyLanguageLexer;
import sample.antlrelements.MyLanguageParser;
import sample.enums.ColorType;
import sample.enums.TileType;
import sample.models.Board;
import sample.models.Robot;
import sample.myVisitor;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller osztály
 * kapcsolatot tart a ui és a modellek között
 * kapcsolatot tart a visitorral
 */
public class GameSceneController implements Initializable {

    /** szövegbeviteli mező a felületen */
    @FXML
    private TextArea txtarea;
    @FXML
    private Button startBtn;
    /** bevitelt törlő gomb a felületen */
    @FXML
    private Button clearBtn;

    @FXML
    private Canvas canvas;

    @FXML
    private Label messageLabel;


    private myVisitor mv;

    private boolean stageSucceeded = false;

    private BoardController boardController;
    /**
     * a beírt kód fordításáért felelős metódus
     * megfelelő helyzetbe állítja a felületi mezőket és gombokat
     */

    public GameSceneController(){

        Play ply = Play.getInstance();
        ply.start();
        //boardController.setCanvas(canvas);
    }
    @FXML
    public void translateIt() {

        startBtn.setDisable(true);
        clearBtn.setDisable(true);
        txtarea.setDisable(true);

        //TODO többi gomb??

        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        MyLanguageLexer mylexer = new MyLanguageLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        MyLanguageParser myparser = new MyLanguageParser(tokstr);

        MyLanguageParser.ProgramContext pc = myparser.program();

        if(myparser.getNumberOfSyntaxErrors() > 0){
            //TODO hibajelzés a felületen, nem is fordul már le
            messageLabel.setText("elrontottál valamit a szintaxisban, próbáld újra");
            //TODO gombok jól működnek ekkor?
        }

        //TODO erroringvisitor hívása az éles fordítás előtt
        //TODO hibavisitor hibái hol lesznek kezelve?

        //boardController.setCanvas(canvas);
        //TODO board ctrl hol indít?
        mv = new myVisitor(boardController);
        mv.visitProgram(pc);
    }

    public void startGame(){
        boardController.start();
    }

    /**
     * előre léptet a kódon belül
     */
    @FXML
    public void forward(){
        mv.forward();

        stageSucceeded = boardController.ended();
        if(stageSucceeded){
            reloadIt();
        }
    }

    /**
     * visszaléptet a kódsorok között
     */
    @FXML
    public void back(){
        mv.back();
    }

    /**
     * egyben lejátssza a begépelt kódot
     */
    @FXML
    public void playIt(){
        mv.play();
    }

    /**
     * a játék alaphelyzetbeállításért felel, a kódot nem törli ki
     * csak a kezdeti játékállapotot rakja vissza
     */
    @FXML
    public void reloadIt(){
        //TODO implement it
        txtarea.setDisable(false);
        txtarea.clear();
        startBtn.setDisable(false);
        clearBtn.setDisable(false);
        mv.clear();
    }

    /*@FXML
    public void nextStage(){
        if(stageSucceeded){
            Play.getInstance().next();
            boardController.start();
            nextStageBtn.setDisable(true);
            stageSucceeded = false;
        }
    }*/

    /** kitörli a beírt kódot */
    public void deleteAll(ActionEvent actionEvent) {
        txtarea.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO mit kell alaphelyzetbe állítani beolvasáskor?
        //TODO pl visitor, felületi elemek
        this.boardController = new BoardController(canvas, messageLabel);
        txtarea.setText("");
    }

    public void erroring(){
        messageLabel.setText("something horribel happened");
//TODO értelmesen, itt kell egyáltalán?
    }
}

