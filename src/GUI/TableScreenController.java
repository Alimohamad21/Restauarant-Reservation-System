package GUI;

import fileHandling.FOrder;
import fileHandling.FReservations;
import fileHandling.FRestaurant;
import fileHandling.FTable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableScreenController implements Initializable {
    @FXML
    Button table1;
    @FXML
    Button table2;
    @FXML
    Button table3;
    @FXML
    Button table4;//non smoking
    @FXML
    Button table5;
    @FXML
    Button table6;
    @FXML
    Button table7;
    @FXML
    Button table8;//smoking
    @FXML
    Label table1persons;
    @FXML
    Label table2persons;
    @FXML
    Label table3persons;
    @FXML
    Label table4persons;
    @FXML
    Label table5persons;
    @FXML
    Label table6persons;
    @FXML
    Label table7persons;
    @FXML
    Label table8persons;
    @FXML
    Button unselected;
    @FXML
    Button back;
    @FXML
    Label helloname;
    @FXML
    AnchorPane main;
    @FXML
    Label verify;
    @FXML
    Label fake;
    List<Button> nonSmokingTables = new ArrayList<Button>();
    List<Button> smokingTables = new ArrayList<Button>();
    List<Label> noOfPersons = new ArrayList<Label>();
    List<Label> snoOfPersons = new ArrayList<Label>();
    private int tableNumber = 0;
    private int noOfPerson;

    public TableScreenController() throws JAXBException {
    }

    JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));
    JAXBContext jaxbContext1 = JAXBContext.newInstance(FReservations.class);
    Unmarshaller unmarshaller1 = jaxbContext1.createUnmarshaller();
    FReservations reservations = (FReservations) unmarshaller1.unmarshal(new File("saveData.xml"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /*BackgroundImage myBI= new BackgroundImage(new Image("https://besthqwallpapers.com/Uploads/5-8-2019/100501/thumb2-light-wood-texture-wood-light-background-texture-of-natural-materials-wood.jpg",600,700,false,true),
               BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
               BackgroundSize.DEFAULT);*/
//then you set to your node
        // main.setBackground(new Background(myBI));int i;
        nonSmokingTables.add(table1);
        nonSmokingTables.add(table2);
        nonSmokingTables.add(table3);
        nonSmokingTables.add(table4);
        smokingTables.add(table5);
        smokingTables.add(table6);
        smokingTables.add(table7);
        smokingTables.add(table8);
        noOfPersons.add(table1persons);
        noOfPersons.add(table2persons);
        noOfPersons.add(table3persons);
        noOfPersons.add(table4persons);
        snoOfPersons.add(table5persons);
        snoOfPersons.add(table6persons);
        snoOfPersons.add(table7persons);
        snoOfPersons.add(table8persons);
        int smokingtablescounter = 0;
        int tablescounter = 0;
        for (FTable fTable : fRestaurant.getFTables().getFTables()) {
            if (fTable.isSmoking()) {
                smokingTables.get(smokingtablescounter).setText(Integer.toString(fTable.getNumber()));
                snoOfPersons.get(smokingtablescounter).setText(Integer.toString(fTable.getNumberOfSeats()) + " persons");
                smokingTables.get(smokingtablescounter).setVisible(true);
                for (FOrder order : reservations.getFOrders().getFOrders()) {
                    if (order.getTableNumber() == fTable.getNumber()) {
                        smokingTables.get(smokingtablescounter).setVisible(false);
                        snoOfPersons.get(smokingtablescounter).setVisible(false);
                    }
                }
                smokingtablescounter++;
            }
            if (!fTable.isSmoking()) {
                nonSmokingTables.get(tablescounter).setText(Integer.toString(fTable.getNumber()));
                noOfPersons.get(tablescounter).setText(Integer.toString(fTable.getNumberOfSeats()) + " persons");
                nonSmokingTables.get(tablescounter).setVisible(true);
                for (FOrder order : reservations.getFOrders().getFOrders()) {
                    if (order.getTableNumber() == fTable.getNumber()) {
                        nonSmokingTables.get(tablescounter).setVisible(false);
                        noOfPersons.get(tablescounter).setVisible(false);
                    }
                }
                tablescounter++;
            }
        }
    }

    public void setHelloname(String name) {
        helloname.setText("Welcome back Mr." + name);
    }

    public void setFake(String name) {
        fake.setText(name);
    }


    public void reserveTable1() {
        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            if (i != 0) nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table1.getText());
        noOfPerson = Integer.parseInt(table1persons.getText().replaceAll("[^0-9]", ""));

    }

    public void reserveTable2() {

        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            if (i != 1) nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table2.getText());
        noOfPerson = Integer.parseInt(table2persons.getText().replaceAll("[^0-9]", ""));

    }

    public void reserveTable3() {

        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            if (i != 2) nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table3.getText());
        noOfPerson = Integer.parseInt(table3persons.getText().replaceAll("[^0-9]", ""));
    }

    public void reserveTable4() {

        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            if (i != 3) nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table4.getText());
        noOfPerson = Integer.parseInt(table4persons.getText().replaceAll("[^0-9]", ""));
    }

    public void reserveTable5() {

        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            if (i != 0) smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table5.getText());
        noOfPerson = Integer.parseInt(table5persons.getText().replaceAll("[^0-9]", ""));
    }

    public void reserveTable6() {

        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            if (i != 1) smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table6.getText());
        noOfPerson = Integer.parseInt(table6persons.getText().replaceAll("[^0-9]", ""));
    }

    public void reserveTable7() {
        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            if (i != 2) smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table7.getText());
        noOfPerson = Integer.parseInt(table7persons.getText().replaceAll("[^0-9]", ""));
    }

    public void reserveTable8() {

        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            if (i != 3) smokingTables.get(i).setDisable(true);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            nonSmokingTables.get(i).setDisable(true);
        }
        tableNumber = Integer.parseInt(table8.getText());
        noOfPerson = Integer.parseInt(table8persons.getText().replaceAll("[^0-9]", ""));
    }

    public void unselect() {
        int i;
        for (i = 0; i < smokingTables.size(); i++) {
            smokingTables.get(i).setDisable(false);
        }
        for (i = 0; i < nonSmokingTables.size(); i++) {
            nonSmokingTables.get(i).setDisable(false);
        }
        tableNumber = 0;
    }

    public void goback(ActionEvent event) {
        GUIfunctions guifunction = new GUIfunctions();
        guifunction.switchScene(event, "loginscreen.fxml");
    }

    public void nextscreen(ActionEvent event) {
        if (tableNumber == 0)
            verify.setVisible(true);
        else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderscreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                OrderscreenController scene2 = fxmlLoader.getController();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene2.setNamefakelabel(fake.getText());
                scene2.noOfpersons = noOfPerson;
                scene2.setTablenofakelabel(Integer.toString(tableNumber));
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("error");
            }

        }
    }
}