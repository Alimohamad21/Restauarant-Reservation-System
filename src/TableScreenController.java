import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TableScreenController implements Initializable {
    @FXML Button table1;
    @FXML Button table2;
    @FXML Button table3;
    @FXML Button table4;//non smoking
    @FXML Button table5;
    @FXML Button table6;
    @FXML Button table7;
    @FXML Button table8;//smoking
    @FXML Label table1persons;
    @FXML Label table2persons;
    @FXML Label table3persons;
    @FXML Label table4persons;
    @FXML Label table5persons;
    @FXML Label table6persons;
    @FXML Label table7persons;
    @FXML Label table8persons;
    @FXML Button unselected;
    @FXML Button back;
    @FXML Label helloname;
    @FXML AnchorPane main;

    public TableScreenController() throws JAXBException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*BackgroundImage myBI= new BackgroundImage(new Image("https://previews.123rf.com/images/titco/titco1907/titco190700044/126811150-wooden-parquet-background-light-wood-floor-texture.jpg",699,1000,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        main.setBackground(new Background(myBI));*/
        int smokingtablescounter=1;
        int tablescounter=1;
        for(FTable fTable : fRestaurant.getFTables().getFTables()) {
            if (fTable.isSmoking()) {
                if(smokingtablescounter==1) {
                    table5.setText(Integer.toString(fTable.getNumber()));
                    table5persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table5.setVisible(true);
                }
              else  if(smokingtablescounter==2) {
                    table6.setText(Integer.toString(fTable.getNumber()));
                    table6persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table6.setVisible(true);
                }
               else if(smokingtablescounter==3) {
                    table7.setText(Integer.toString(fTable.getNumber()));
                    table7persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table7.setVisible(true);
                }
                else if(smokingtablescounter==4) {
                    table8.setText(Integer.toString(fTable.getNumber()));
                    table8persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table8.setVisible(true);
                }
                smokingtablescounter++;
                }
        else if (!fTable.isSmoking()) {
                if (tablescounter == 1) {
                    table1.setText(Integer.toString(fTable.getNumber()));
                    table1persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table1.setVisible(true);
                } else if (tablescounter == 2) {
                    table2.setText(Integer.toString(fTable.getNumber()));
                    table2persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table2.setVisible(true);
                } else if (tablescounter == 3) {
                    table3.setText(Integer.toString(fTable.getNumber()));
                    table3persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table3.setVisible(true);
                } else if (tablescounter == 4) {
                    table4.setText(Integer.toString(fTable.getNumber()));
                    table4persons.setText(Integer.toString(fTable.getNumberOfSeats())+" persons");
                    table4.setVisible(true);
                }
                    tablescounter++;
                }
            }


        /*for (FTable fTable : fSavedRestaurant.getFTables().getFTables()) {
            if (fTable.getNumber() == 7) {
                //table7.setStyle("-fx-background-color:#ff0000;");
                table7.setDisable(true);

        }*/
    }
    JAXBContext jaxbContext= JAXBContext.newInstance(FRestaurant.class);
    Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
    FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));
    FRestaurant fSavedRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("saveData.xml"));
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
        table8.setDisable(true);
    }

    public void reserveTable2(){

        table1.setDisable(true);
        table2.setDisable(false);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);
        table8.setDisable(true);


    }
    public void reserveTable3(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(false);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);
        table8.setDisable(true);


    }
    public void reserveTable4(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(false);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);
        table8.setDisable(true);


    }
    public void reserveTable5(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(false);
        table6.setDisable(true);
        table7.setDisable(true);
        table8.setDisable(true);


    }
    public void reserveTable6(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(false);
        table7.setDisable(true);
        table8.setDisable(true);

    }
    public void reserveTable7(){
        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(false);
        table8.setDisable(true);
    }
    public void reserveTable8(){

        table1.setDisable(true);
        table2.setDisable(true);
        table3.setDisable(true);
        table4.setDisable(true);
        table5.setDisable(true);
        table6.setDisable(true);
        table7.setDisable(true);
        table8.setDisable(false);
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
        table8.setDisable(false);
    }
    public void goback(ActionEvent event)
    {
        GUIfunctions guifunction=new GUIfunctions();
        guifunction.switchScene(event,"loginscreen.fxml");
    }
    public void nextscreen(ActionEvent event)
    {
        GUIfunctions guifunction=new GUIfunctions();
        guifunction.switchScene(event,"orderscreen.fxml");
    }
}