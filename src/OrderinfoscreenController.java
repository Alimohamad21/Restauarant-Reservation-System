import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderinfoscreenController implements Initializable {

    @FXML
    Button exit;
    @FXML
    Button logout;
    @FXML
    Label totalprice;
    @FXML
    Label order;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void printTotalprice(String orderprice,String orderinfo)
    {
        totalprice.setText(orderprice+" L.E");
        order.setText(orderinfo);
    }

    public void quit()
    {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    public void loggedout(ActionEvent event)
    {
        GUIfunctions guifunction=new GUIfunctions();
        guifunction.switchScene(event,"loginscreen.fxml");
    }
}
