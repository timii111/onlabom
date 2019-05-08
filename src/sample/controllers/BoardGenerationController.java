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
import sample.boardgenerating.ErroringBoardLanguageVisitor;
import sample.boardgenerating.MyBoardLanguageVisitor;
import sample.boardgenerating.languageelements.BoardLanguageLexer;
import sample.boardgenerating.languageelements.BoardLanguageParser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

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

    @FXML
    private Label messageLabel;

    public BoardGenerationController(){

    }

    @FXML
    public String renderBoard(){
        messageLabel.setText("");
        CodePointCharStream mystream = CharStreams.fromString(txtarea.getText());
        BoardLanguageLexer mylexer = new BoardLanguageLexer(mystream);
        CommonTokenStream tokstr = new CommonTokenStream(mylexer);
        BoardLanguageParser myparser = new BoardLanguageParser(tokstr);

        MyBoardLanguageVisitor mv = new MyBoardLanguageVisitor();

        ErroringBoardLanguageVisitor ev = new ErroringBoardLanguageVisitor();

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

    @FXML
    public void deleteIt(){
        txtarea.setText("");
    }

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

    public void initialize() {
        boardController = new BoardController(canvas, messageLabel);
        filesCount = Play.getInstance().getMaxGameNumber()+1;
    }
}
