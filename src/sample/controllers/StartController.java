package sample.controllers;

import javafx.fxml.FXML;

public class StartController {

    @FXML private GameSceneController gameSceneController;
    @FXML private BoardGenerationController boardGenerationController;

    @FXML public void initialize() {

        gameSceneController.startGame();
    }
}
