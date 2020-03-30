import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderscreenController implements Initializable {
    @FXML
    Button back;
    @FXML
    Label maindish1name;
    @FXML
    Label maindish1price;
    @FXML
    Spinner<Integer> maindish1spinner;
    @FXML
    Label maindish2name;
    @FXML
    Label maindish2price;
    @FXML
    Spinner<Integer> maindish2spinner;
    @FXML
    Label maindish3name;
    @FXML
    Label maindish3price;
    @FXML
    Spinner<Integer> maindish3spinner;
    @FXML
    Label maindish4name;
    @FXML
    Label maindish4price;
    @FXML
    Spinner<Integer> maindish4spinner;
    @FXML
    Label maindish5name;
    @FXML
    Label maindish5price;
    @FXML
    Spinner<Integer> maindish5spinner;
    @FXML
    Label maindish6name;
    @FXML
    Label maindish6price;
    @FXML
    Spinner<Integer> maindish6spinner;
    @FXML
    Label appetizer1name;
    @FXML
    Label appetizer1price;
    @FXML
    Spinner<Integer> appetizer1spinner;
    @FXML
    Label appetizer2name;
    @FXML
    Label appetizer2price;
    @FXML
    Spinner<Integer> appetizer2spinner;
    @FXML
    Label appetizer3name;
    @FXML
    Label appetizer3price;
    @FXML
    Spinner<Integer> appetizer3spinner;
    @FXML
    Label dessert1name;
    @FXML
    Label dessert1price;
    @FXML
    Spinner<Integer> dessert1spinner;
    @FXML
    Label dessert2name;
    @FXML
    Label dessert2price;
    @FXML
    Spinner<Integer> dessert2spinner;
    @FXML
    Label dessert3name;
    @FXML
    Label dessert3price;
    @FXML
    Spinner<Integer> dessert3spinner;

    JAXBContext jaxbContext= JAXBContext.newInstance(FRestaurant.class);
    Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
    FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));
    public OrderscreenController() throws JAXBException {
    }

   public void spinner1(ActionEvent event)
   {

   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int maindishescounter = 1;
        int appetizerscounter = 1;
        int dessertcounter = 1;
        for (FDish fDish : fRestaurant.getFDishes().getFDishes()) {
            if(fDish.getType().equalsIgnoreCase("main_course")) {
                if(maindishescounter==1){
                    maindish1name.setText(fDish.getName());
                    maindish1price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    maindish1spinner.setVisible(true);
                }
                if(maindishescounter==2){
                    maindish2name.setText(fDish.getName());
                    maindish2price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    maindish2spinner.setVisible(true);
                }
                if(maindishescounter==3){
                    maindish3name.setText(fDish.getName());
                    maindish3price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    maindish3spinner.setVisible(true);
                }
                if(maindishescounter==4){
                    maindish4name.setText(fDish.getName());
                    maindish4price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    maindish4spinner.setVisible(true);
                }
                if(maindishescounter==5){
                    maindish5name.setText(fDish.getName());
                    maindish5price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    maindish5spinner.setVisible(true);
                }
                if(maindishescounter==6){
                    maindish6name.setText(fDish.getName());
                    maindish6price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    maindish6spinner.setVisible(true);
                }
                maindishescounter++;
            }
            else if (fDish.getType().equalsIgnoreCase("appetizer")) {
                if(appetizerscounter==1) {
                    appetizer1name.setText(fDish.getName());
                    appetizer1price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    appetizer1spinner.setVisible(true);
                }
                else if(appetizerscounter==2) {
                    appetizer2name.setText(fDish.getName());
                    appetizer2price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    appetizer2spinner.setVisible(true);
                }
                else if(appetizerscounter==3)
                {    appetizer3name.setText(fDish.getName());
                    appetizer3price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    appetizer3spinner.setVisible(true);
                }
            appetizerscounter++;}
            else if (fDish.getType().equalsIgnoreCase("desert")) {
                if(dessertcounter==1) {
                    dessert1name.setText(fDish.getName());
                    dessert1price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    dessert1spinner.setVisible(true);
                }
                else if(dessertcounter==2) {
                    dessert2name.setText(fDish.getName());
                    dessert2price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    dessert2spinner.setVisible(true);
                }
                else if(dessertcounter==3)
                {   dessert3name.setText(fDish.getName());
                    dessert3price.setText("Price:"+Double.toString(fDish.getPrice())+" L.E");
                    dessert3spinner.setVisible(true);
                }
                dessertcounter++;}
            }

        }


    public void goback(ActionEvent event)
    {
        GUIfunctions guifunction=new GUIfunctions();
        guifunction.switchScene(event,"tablescreen.fxml");
    }
    public void nextscreen(ActionEvent event)
    {
        GUIfunctions guifunction=new GUIfunctions();
        guifunction.switchScene(event,"orderinfoscreen.fxml");
    }
}
