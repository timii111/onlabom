package sample.controllers;

import javafx.fxml.FXML;

/**
 * inicializáló start fxml-hez tartozó controller osztály
 */
public class StartController {

    @FXML private GameSceneController gameSceneController;
    @FXML private BoardGenerationController boardGenerationController;

    @FXML public void initialize() {
        gameSceneController.startGame();
    }
}