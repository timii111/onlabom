package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import sample.Play;
import sample.antlrelements.MyErrorVisitor;
import sample.antlrelements.WrongStepError;
import sample.antlrelements.languageelements.MyLanguageLexer;
import sample.antlrelements.languageelements.MyLanguageParser;
import sample.antlrelements.myVisitor;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller osztály
 * kapcsolatot tart a ui és a modellek között
 * kapcsolatot tart a visitorral
 */
public class GameSceneController implements Initializable {

    /** szövegbeviteli mező a felületen */
    @FXML private TextArea txtarea;
    @FXML private Button startBtn;
    /** bevitelt törlő gomb a felületen */
    @FXML private Button clearBtn;
    @FXML private Button forwardBtn;
    @FXML private Button backBtn;
    @FXML private Button playBtn;
    @FXML private Button againBtn;
    @FXML private Canvas canvas;

    @FXML private Label messageLabel;


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

    }

    @FXML
    public void translateIt() {

        messageLabel.setText("");

        startBtn.setDisable(true);
        clearBtn.setDisable(true);
        txtarea.setDisable(true);

        forwardBtn.setDisable(false);
        backBtn.setDisable(false);
        playBtn.setDisable(false);

        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        MyLanguageLexer mylexer = new MyLanguageLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        MyLanguageParser myparser = new MyLanguageParser(tokstr);

        MyLanguageParser.ProgramContext pc = myparser.program();


        if(myparser.getNumberOfSyntaxErrors() > 0){
            messageLabel.setText("elrontottál valamit a szintaxisban, próbáld újra");
            forwardBtn.setDisable(true);
            backBtn.setDisable(true);
            playBtn.setDisable(true);
        }

        MyErrorVisitor ev = new MyErrorVisitor();
        boolean b = (boolean)ev.visitProgram(pc);

        if(!b){
            mv = new myVisitor(boardController);
            mv.visitProgram(pc);
        } else{
            messageLabel.setText("elrontottál valamit a szintaxisban, próbáld újra!");
            forwardBtn.setDisable(true);
            backBtn.setDisable(true);
            playBtn.setDisable(true);
        }
    }

    public void startGame(){
        boardController.start();
    }

    /**
     * előre léptet a kódon belül
     */
    @FXML
    public void forward(){
        try {
            mv.forward();
        } catch (WrongStepError wrongStepError) {
            mv.stop();
        }

        succeed();
    }

    public void succeed(){
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
        try {
            mv.back();
        } catch (WrongStepError wrongStepError) {
            mv.stop();
            //TODO kell ezt eddig felcsurgatni?
        }

        succeed();
    }

    /**
     * egyben lejátssza a begépelt kódot
     */
    @FXML
    public void playIt(){
        forwardBtn.setDisable(true);
        backBtn.setDisable(true);

        mv.play();

        //succeed();
    }

    /**
     * a játék alaphelyzetbeállításért felel, a kódot nem törli ki
     * csak a kezdeti játékállapotot rakja vissza
     */
    @FXML
    public void reloadIt(){
        mv.stop(); //TODO!!
        txtarea.setDisable(false);
        startBtn.setDisable(false);
        clearBtn.setDisable(false);
        forwardBtn.setDisable(true);
        backBtn.setDisable(true);
        playBtn.setDisable(true);
        mv.clear();
        boardController.reloadIt();
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
        this.boardController = new BoardController(canvas, messageLabel);
        txtarea.setText("");
        forwardBtn.setDisable(true);
        backBtn.setDisable(true);
        playBtn.setDisable(true);
    }

}

