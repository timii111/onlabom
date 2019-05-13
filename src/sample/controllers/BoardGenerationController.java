package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import sample.Play;
import sample.boardgenerating.ErrorBoardLanguageVisitor;
import sample.boardgenerating.MyBoardLanguageVisitor;
import sample.boardgenerating.languageelements.BoardLanguageLexer;
import sample.boardgenerating.languageelements.BoardLanguageParser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class BoardGenerationController {

    /** mentés gomb */
    @FXML private Button saveBtn;
    /** szövegbeviteli mező */
    @FXML private TextArea txtarea;
    /** aktuálisan mentett pálya száma  */
    private int filesCount;
    /** a használt boardcontroller példány, kirajzolja a létrejött pályát */
    private BoardController boardController;
    /** rajzoló felület a pályán */
    @FXML private Canvas canvas;
    /** hibajelző címke */
    @FXML private Label messageLabel;

    public BoardGenerationController(){}

    /**
     * fordítás gomb
     * a beírt szöveget a visitorok segítségével feldolgozza, ha hibátlan, kijelzi
     * hiba esetén letiltja a mentés funkciót és visszajelez a felületen
     * ha nincs hiba, visszaadja az előállított pálya leírását, ami menthető állapotban van
     */
    @FXML
    public String renderBoard(){
        messageLabel.setText("");
        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        BoardLanguageLexer mylexer = new BoardLanguageLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        BoardLanguageParser myparser = new BoardLanguageParser(tokstr);

        MyBoardLanguageVisitor mv = new MyBoardLanguageVisitor();

        ErrorBoardLanguageVisitor ev = new ErrorBoardLanguageVisitor();

        BoardLanguageParser.ProgramContext pc = myparser.program();

        String errorStr = (String) ev.visitProgram(pc);
        if(!errorStr.equals("")){
            boardController.clearCanvas();
            messageLabel.setText(errorStr);
            saveBtn.setDisable(true);
            return null;
        } else {
            String fileStr = (String) mv.visitProgram(pc);
            saveBtn.setDisable(false);
            boardController.drawBoard(fileStr);
            return fileStr;
        }

    }

    /**
     * törlés, a beírt kód megsemmisítése
     */
    @FXML
    public void deleteIt(){
        txtarea.setText("");
    }

    /**
     * pálya mentésére szolgál
     * meghívja a kirajzolásért felelős függvényt
     * kimenti a következő számú fájlba a szöveget
     */
    @FXML
    public void saveBoard(){
        String fileStr = renderBoard();

        //mentés rész
        try (PrintStream out = new PrintStream(new FileOutputStream("src/sample/boards/Board_" + filesCount + ".txt"))) {
            out.print(fileStr.toUpperCase());
            filesCount++;
            Play.getInstance().setMaxGameNumber(filesCount);
        } catch(IOException e){
            messageLabel.setText("nem sikerült a mentés");
        }
    }

    /**
     * inicializáló függvény, beállítja a megfelelő változókat
     */
    public void initialize() {
        boardController = new BoardController(canvas, messageLabel);
        filesCount = Play.getInstance().getMaxGameNumber()+1;
    }
}