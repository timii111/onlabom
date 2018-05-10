package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextArea txtarea;

    public  Controller(){

    }

    @FXML
    public void printIt() {

        Play.getInstance().watch();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void deleteAll(ActionEvent actionEvent) {
        txtarea.clear();
    }
}
