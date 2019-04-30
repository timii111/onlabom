package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import sample.boardgenerating.MyBoardLanguageVisitor;
import sample.boardgenerating.languageelements.BoardLanguageLexer;
import sample.boardgenerating.languageelements.BoardLanguageParser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardGenerationController {

    @FXML
    private Button renderBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextArea txtarea;

    private int filesCount;
    private BoardController boardController;

    @FXML
    private Canvas canvas;

    public BoardGenerationController(){

    }

    @FXML
    public String renderBoard(){
        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        BoardLanguageLexer mylexer = new BoardLanguageLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        BoardLanguageParser myparser = new BoardLanguageParser(tokstr);

        MyBoardLanguageVisitor mv = new MyBoardLanguageVisitor();
        String fileStr = (String) mv.visitProgram(myparser.program());

        boardController.drawBoard(fileStr);
        return fileStr;
        //saveBoard();
        //TODO itt kell meghívni a kirajzolást
        //TODO automatikusan léptetett fájlszámokat belevinni a játékba
    }

    @FXML
    public void deleteIt(){
        //TODO törölni a szöveget, init változó
    }

    @FXML
    public void saveBoard(){
        String fileStr = renderBoard();

        //TODO tárolni a kódot, hogy aktuálisan újrafelhazsnálható legyen, különválasztani a mentéstől, az külön funkció


        //mentés rész
        try (PrintStream out = new PrintStream(new FileOutputStream("src/sample/boards/Board_" + filesCount + ".txt"))) {
            out.print(fileStr);
        } catch(IOException e){
            //TODO
        }
    }

    public void initialize() {
        boardController = new BoardController(canvas);
        filesCount = 4; //TODO auto value
    }
}
