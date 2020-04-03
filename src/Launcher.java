import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.File;


public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginscreen.fxml"));
        primaryStage.setTitle("Restaurant Reservation System");
        primaryStage.setScene(new Scene(root, 500, 350));
        primaryStage.show();
    }


    public static void main(String[] args) throws JAXBException {
        File file=new File("saveData.xml");
        if(file.length()<100) {
            Customer fake = new Customer();//To handle all errors coming from loading empty files
            fake.makeReservation("",0,"",0.0);
        }
        launch(args);
    }
}

