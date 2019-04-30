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

    private myVisitor mv;

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

        //boardController.setCanvas(canvas);
        //TODO board ctrl hol indít?
        mv = new myVisitor(boardController);
        mv.visitProgram(myparser.program());
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

        startBtn.setDisable(false);
        clearBtn.setDisable(false);
    }

    /** kitörli a beírt kódot */
    public void deleteAll(ActionEvent actionEvent) {
        txtarea.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO mit kell alaphelyzetbe állítani beolvasáskor?
        //TODO pl visitor, felületi elemek
        this.boardController = new BoardController(canvas);
        txtarea.setText("");
    }
}

