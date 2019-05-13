package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    /**
     * a játéktér betöltésére szolgáló metódus
     */
    @Override
    public void start(Stage primaryStage) {

        Parent game = null;
        try {
            game = FXMLLoader.load(getClass().getResource("frontend/StartScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("A programozás gyerekjáték");
        primaryStage.setScene(new Scene(game, 800, 800));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
