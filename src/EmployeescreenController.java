import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.net.URL;
import java.util.ResourceBundle;


public class EmployeescreenController implements Initializable {
    @FXML
    Button exit;
    @FXML
    Button logout;
    @FXML
    Label helloname;

    @FXML
    Label totalincome;
    @FXML
    TextArea stats;

    public EmployeescreenController() throws JAXBException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void viewStats(String statistics)
    {
        stats.setText(statistics);
    }
    public void setHelloname(String name){
        helloname.setText("Welcome back Mr."+name);
    }
    public void viewTotalIncome(String totalIncome)
    {
        totalincome.setText("Total income:"+totalIncome+" L.E");
    }



    public void loggedout(ActionEvent event)
    {
        GUIfunctions guifunction=new GUIfunctions();
        guifunction.switchScene(event,"loginscreen.fxml");
    }
    public void quit()
    {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}
