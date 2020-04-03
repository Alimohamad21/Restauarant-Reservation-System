import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.File;

public class LoginscreenController {
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
    @FXML
    Hyperlink signup;
    private String mode;


    JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));


    public LoginscreenController() throws JAXBException {
    }

    public void setSignup(ActionEvent event) {
        GUIfunctions guifunction = new GUIfunctions();
        guifunction.switchScene(event, "signupscreen.fxml");
    }


    public void setCustomer(ActionEvent event) {
        manager.setSelected(false);
        waiter.setSelected(false);
        cook.setSelected(false);
        mode = "customer";
    }


    public void setWaiter(ActionEvent event) {
        manager.setSelected(false);
        customer.setSelected(false);
        cook.setSelected(false);
        mode = "waiter";
    }

    public void setManager(ActionEvent event) {
        waiter.setSelected(false);
        customer.setSelected(false);
        cook.setSelected(false);
        mode = "manager";
    }

    public void setCook(ActionEvent event) {
        waiter.setSelected(false);
        customer.setSelected(false);
        manager.setSelected(false);
        mode = "cook";
    }

    public void setLogin(ActionEvent event) {
        boolean flag = true;
        if (customer.isSelected() || waiter.isSelected() || cook.isSelected() || manager.isSelected()) {
            try {
                for (FUser fUser : fRestaurant.getFUsers().getFUsers()) {
                    if (fUser.getUsername().equalsIgnoreCase(username.getText()) && fUser.getPassword().equals(password.getText())) {
                        if (mode.equals("customer") && fUser.getRole().equalsIgnoreCase("client")) {
                            flag = false;
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tablescreen.fxml"));
                                Parent root1 = (Parent) fxmlLoader.load();
                                TableScreenController scene2 = fxmlLoader.getController();
                                scene2.setHelloname(fUser.getName());//welcomes user
                                scene2.setFake(fUser.getName());//passes name to next scene
                                Scene scene = new Scene(root1);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();
                            } catch (Exception e) {
                                verify.setText("Error opening scene");
                            }
                        } else if (mode.equals("waiter") && fUser.getRole().equalsIgnoreCase("waiter")) {
                            flag = false;
                            try {
                                Waiter waiter = new Waiter();
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeescreen.fxml"));
                                Parent root1 = (Parent) fxmlLoader.load();
                                EmployeescreenController scene2 = fxmlLoader.getController();
                                scene2.viewStats(waiter.viewStatistics());
                                scene2.setHelloname(fUser.getName());
                                Scene scene = new Scene(root1);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();
                            } catch (Exception e) {
                                verify.setText("Error opening scene");
                            }
                        } else if (mode.equals("cook") && fUser.getRole().equalsIgnoreCase("cooker")) {
                            flag = false;
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeescreen.fxml"));
                                Parent root1 = (Parent) fxmlLoader.load();
                                EmployeescreenController scene2 = fxmlLoader.getController();
                                scene2.setHelloname(fUser.getName());
                                Cook cook = new Cook();
                                scene2.viewStats(cook.viewStatistics());
                                Scene scene = new Scene(root1);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();
                            } catch (Exception e) {
                                verify.setText("Error opening scene");
                            }
                        } else if (mode.equals("manager") && fUser.getRole().equalsIgnoreCase("manager")) {
                            flag = false;
                            try {
                                Manager manager = new Manager();
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeescreen.fxml"));
                                Parent root1 = (Parent) fxmlLoader.load();
                                EmployeescreenController scene2 = fxmlLoader.getController();
                                scene2.setHelloname(fUser.getName());
                                scene2.viewStats(manager.viewStatistics());
                                scene2.viewTotalIncome(manager.viewTotalIncome());
                                Scene scene = new Scene(root1);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();
                            } catch (Exception e) {
                                verify.setText("Error opening scene");
                            }
                        }
                    }
                }
                if (!customer.isSelected() && !waiter.isSelected() && !cook.isSelected() && !manager.isSelected())
                    flag = true;
                if (flag)
                    verify.setText("Invalid username or password");
            } catch (Exception e) {
                verify.setText("Invalid username or password");
            }
        } else verify.setText("Invalid username or password");
    }
}

