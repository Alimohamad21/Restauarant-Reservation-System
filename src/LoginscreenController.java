import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.File;

public class LoginscreenController{
    @FXML
    RadioButton customer;
    @FXML
    RadioButton waiter;
    @FXML
    RadioButton manager;
    @FXML
    RadioButton cook;
    @FXML
    Button login;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Label verify;
    private String mode;


    JAXBContext jaxbContext= JAXBContext.newInstance(FRestaurant.class);
    Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
    FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));


    public LoginscreenController() throws JAXBException {
    }

    public void setCustomer(ActionEvent event) {
        manager.setSelected(false);
        waiter.setSelected(false);
        cook.setSelected(false);
        mode="customer";
   }

    public void setWaiter(ActionEvent event) {
        manager.setSelected(false);
        customer.setSelected(false);
        cook.setSelected(false);
        mode="waiter";
   }

    public void setManager(ActionEvent event) {
        waiter.setSelected(false);
        customer.setSelected(false);
        cook.setSelected(false);
        mode="manager";
   }
    public void setCook(ActionEvent event) {
        waiter.setSelected(false);
        customer.setSelected(false);
        manager.setSelected(false);
        mode="cook";
    }

    public void setLogin(ActionEvent event) {
        boolean flag = true;
       try {
           for (FUser fUser : fRestaurant.getFUsers().getFUsers()) {
               if (fUser.getUsername().equalsIgnoreCase(username.getText()) && fUser.getPassword().equals(password.getText())) {
                   if (mode.equals("customer") && fUser.getRole().equalsIgnoreCase("client")) {
                       flag = false;
                       try {
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tablescreen.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           TableScreenController scene2 = fxmlLoader.getController();
                           scene2.setHelloname(fUser.getName());
                           Scene scene = new Scene(root1);
                           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                           stage.setScene(scene);
                           stage.show();
                       } catch (Exception e) {
                           verify.setText("Error opening scene");
                       }
                   } else if (mode.equals("waiter") && fUser.getRole().equalsIgnoreCase("waiter")) {
                       flag = false;
                   } else if (mode.equals("cook") && fUser.getRole().equalsIgnoreCase("cooker")) {
                       flag = false;
                   } else if (mode.equals("manager") && fUser.getRole().equalsIgnoreCase("manager")) {
                       flag = false;
                   }
               }
           }
           if (flag)
               verify.setText("Invalid username or password");
           else verify.setText("Login successful");
       }catch(Exception e){verify.setText("Invalid username or password");}
    }
    }

