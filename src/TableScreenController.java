import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TableScreenController implements Initializable {
    @FXML
    Label helloname;
    @Override
public void initialize(URL url, ResourceBundle resourceBundle) {

}
    public void setHelloname(String name){
        helloname.setText("Welcome back Mr."+name);
    }
}
