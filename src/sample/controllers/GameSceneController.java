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
    /** a lépések fordítását megkezdő gomb */
    @FXML private Button startBtn;
    /** bevitelt törlő gomb a felületen */
    @FXML private Button clearBtn;
    /** előre léptető gomb */
    @FXML private Button forwardBtn;
    /** visszaléptető gomb */
    @FXML private Button backBtn;
    /** a lépések automata lejátszását megkezdő gomb */
    @FXML private Button playBtn;
    /** rajzoló felület */
    @FXML private Canvas canvas;
    /** hibajelző címke */
    @FXML private Label messageLabel;

    /** a nyelv feldolgozásához használt visitor */
    private myVisitor mv;
    /** szint sikerét jelző flag */
    private boolean stageSucceeded = false;
    /** a pálya kirajzolását végző boradcontroller példány */
    private BoardController boardController;

    /**
     * létrehozza a játékpéldányt, ha még nem jött létre, majd elindítja a játékot
     */
    public GameSceneController(){

        Play ply = Play.getInstance();
        ply.start();

    }

    /**
     * fordításért felelős metódus
     * megfelelő helyzetbe állítja a felületi elemeket
     * lefordítja a kódot, bejárja a megfelelő visitorok segítségével
     * ha hiba van a kódban, nem végzi el a műveleteket
     * visszajelzést ad a felületen
     */
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

    /**
     * controller inicializálása a játékhoz
     */
    public void startGame(){
        boardController.start();
    }

    /**
     * előre léptet a kódon belül
     */
    @FXML
    public void forward(){
        mv.forward();

        succeed();
    }

    /**
     * pálya sikerét kezelő metódus
     * siker esetén következőre léptet, újrainicializálja a változókat
     */
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
        mv.back();

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

    /** kitörli a beírt kódot */
    public void deleteAll(ActionEvent actionEvent) {
        txtarea.clear();
    }

    /**
     * alaphelyzetbe állítja a játékot
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.boardController = new BoardController(canvas, messageLabel);
        txtarea.setText("");
        forwardBtn.setDisable(true);
        backBtn.setDisable(true);
        playBtn.setDisable(true);
    }

}

