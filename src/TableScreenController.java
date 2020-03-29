import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class TableScreenController implements Initializable {
    @FXML Button table1;
    @FXML Button table2;
    @FXML Button table3;
    @FXML Button table4;
    @FXML Button table5;
    @FXML Button table6;
    @FXML Button table7;
    @FXML Button unselected;
    @FXML Button back;
    @FXML Label helloname;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setHelloname(String name){
        helloname.setText("Welcome back Mr."+name);
    }
    public void reserveTable1() {

        table1.setDisable(false);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);
    }

    public void reserveTable2(){

        table1.setDisable(true);
        table2.setDisable(false);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);

    }
    public void reserveTable3(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(false);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);

    }
    public void reserveTable4(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(false);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);

    }
    public void reserveTable5(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(false);
        table6.setDisable(true);
        table7.setDisable(true);

    }
    public void reserveTable6(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(false);
        table7.setDisable(true);

    }
    public void reserveTable7(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(false);

    }
    public void unselect()
    {
        table1.setDisable(false);
        table2.setDisable(false);
        table3.setDisable(false);
        table4.setDisable(false);
        table5.setDisable(false);
        table6.setDisable(false);
        table7.setDisable(false);
    }
    public void goback(ActionEvent event)
    {
        GUIfunctions guifunction=new GUIfunctions();
        guifunction.switchScene(event,"loginscreen.fxml");
    }

}