package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextArea txtarea;

    public  Controller(){

    }

    @FXML
    public void printIt() {

            txtarea.setText( Play.getInstance().actualBoard.draw());


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*try {

        } catch (IOException e) {

        }*/
    }
}
