
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.scene.image.Image;


public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginscreen.fxml"));
        primaryStage.setTitle("Restaurant Reservation System");
        primaryStage.setScene(new Scene(root, 500, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

