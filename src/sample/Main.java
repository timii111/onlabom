package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent game = FXMLLoader.load(getClass().getResource("frontend/StartScene.fxml"));
        primaryStage.setTitle("A programozás gyerekjáték");
        primaryStage.setScene(new Scene(game, 800, 800));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

}
