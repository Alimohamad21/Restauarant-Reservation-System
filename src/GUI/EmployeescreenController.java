package GUI;

import fileHandling.FOrder;
import fileHandling.FReservations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import logic.*;


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
    @FXML
    Button clear;
    @FXML
    Label managerlabel;
    @FXML
    RadioButton yes;
    @FXML
    Label more;
    @FXML
    ChoiceBox<Integer> tables;
    @FXML
    Button delete;

    JAXBContext jaxbContext1 = JAXBContext.newInstance(FReservations.class);
    Unmarshaller unmarshaller1 = jaxbContext1.createUnmarshaller();
    FReservations reservations = (FReservations) unmarshaller1.unmarshal(new File("saveData.xml"));

    public EmployeescreenController() throws JAXBException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void viewStats(String statistics) {
        stats.setText(statistics);
    }

    public void setHelloname(String name) {
        helloname.setText("Welcome back Mr." + name);
    }

    public void viewTotalIncome(String totalIncome) {
        totalincome.setText("Total income:" + totalIncome + " L.E");
        clear.setVisible(true);
        managerlabel.setVisible(true);
        yes.setVisible(true);
    }

    public void showMore() {
        int i = 0;
        try {
            for (FOrder order : reservations.getFOrders().getFOrders()) {
                if (order.getTableNumber() != 0) {
                    if (i == 0) {
                        tables.setValue(order.getTableNumber());
                        i++;
                    }
                    tables.getItems().add(order.getTableNumber());
                }
            }
            more.setVisible(true);
            delete.setVisible(true);
            tables.setVisible(true);
        } catch (Exception e) {
        }
    }

    public void clearReservations() throws JAXBException {
        try {
            Manager manager = new Manager();
            manager.clearAllReservations();
            stats.setText("");
            totalincome.setText("Total income:0.0 L.E");
            Customer fake = new Customer();//To handle all errors coming from loading empty files
            fake.makeReservation("", 0, "", 0.0);
        } catch (Exception e) {
        }
    }

    public void deleteReservations(ActionEvent event) throws JAXBException {
        try {
            Manager manager = new Manager();
            manager.deleteReservation(tables.getValue());
            stats.setText(manager.viewStatistics());
            totalincome.setText(("Total income:" + manager.viewTotalIncome() + " L.E"));
        } catch (Exception e) {
        }
    }

    public void loggedout(ActionEvent event) {
        GUIfunctions guifunction = new GUIfunctions();
        guifunction.switchScene(event, "loginscreen.fxml");
    }

    public void quit() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}
