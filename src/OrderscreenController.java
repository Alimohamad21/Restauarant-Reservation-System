import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    @FXML
    Label namefakelabel;
    @FXML
    Label tablenofakelabel;
    private int maindishescounter = 0;
    private int appetizerscounter = 0;
    private int dessertcounter = 0;
    List<Label> mainDishesNames = new ArrayList<Label>();
    List<Label> mainDishesPrices = new ArrayList<Label>();
    List<Label> appetizerNames = new ArrayList<Label>();
    List<Label> appetizerPrices = new ArrayList<Label>();
    List<Label> dessertNames = new ArrayList<Label>();
    List<Label> dessertPrices = new ArrayList<Label>();
    List<Spinner<Integer>> mainDishSpinners = new ArrayList<Spinner<Integer>>();
    List<Spinner<Integer>> appetizerSpinners = new ArrayList<Spinner<Integer>>();
    List<Spinner<Integer>> dessertSpinners = new ArrayList<Spinner<Integer>>();

    JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));

    public OrderscreenController() throws JAXBException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i;
        mainDishesNames.add(maindish1name);
        mainDishesPrices.add(maindish1price);
        mainDishSpinners.add(maindish1spinner);
        mainDishesNames.add(maindish2name);
        mainDishesPrices.add(maindish2price);
        mainDishSpinners.add(maindish2spinner);
        mainDishesNames.add(maindish3name);
        mainDishesPrices.add(maindish3price);
        mainDishSpinners.add(maindish3spinner);
        mainDishesNames.add(maindish4name);
        mainDishesPrices.add(maindish4price);
        mainDishSpinners.add(maindish4spinner);
        mainDishesNames.add(maindish5name);
        mainDishesPrices.add(maindish5price);
        mainDishSpinners.add(maindish5spinner);
        mainDishesNames.add(maindish6name);
        mainDishesPrices.add(maindish6price);
        mainDishSpinners.add(maindish6spinner);
        appetizerNames.add(appetizer1name);
        appetizerPrices.add(appetizer1price);
        appetizerSpinners.add(appetizer1spinner);
        appetizerNames.add(appetizer2name);
        appetizerPrices.add(appetizer2price);
        appetizerSpinners.add(appetizer2spinner);
        appetizerNames.add(appetizer3name);
        appetizerPrices.add(appetizer3price);
        appetizerSpinners.add(appetizer3spinner);
        dessertNames.add(dessert1name);
        dessertPrices.add(dessert1price);
        dessertSpinners.add(dessert1spinner);
        dessertNames.add(dessert2name);
        dessertPrices.add(dessert2price);
        dessertSpinners.add(dessert2spinner);
        dessertNames.add(dessert3name);
        dessertPrices.add(dessert3price);
        dessertSpinners.add(dessert3spinner);
        for (i = 0; i < mainDishSpinners.size(); i++) {
            this.mainDishSpinners.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }
        for (i = 0; i < appetizerSpinners.size(); i++) {
            this.appetizerSpinners.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }


        for (i = 0; i < dessertSpinners.size(); i++) {
            this.dessertSpinners.get(i).setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }
        for (FDish fDish : fRestaurant.getFDishes().getFDishes()) {
            if (fDish.getType().equalsIgnoreCase("main_course")) {
                mainDishesNames.get(maindishescounter).setText(fDish.getName());
                mainDishesPrices.get(maindishescounter).setText("Price:" + Double.toString(fDish.getPrice()) + " L.E");
                mainDishSpinners.get(maindishescounter).setVisible(true);
                maindishescounter++;
            } else if (fDish.getType().equalsIgnoreCase("appetizer")) {
                appetizerNames.get(appetizerscounter).setText(fDish.getName());
                appetizerPrices.get(appetizerscounter).setText("Price:" + Double.toString(fDish.getPrice()) + " L.E");
                appetizerSpinners.get(appetizerscounter).setVisible(true);
                appetizerscounter++;
            } else if (fDish.getType().equalsIgnoreCase("desert")) {
                dessertNames.get(dessertcounter).setText(fDish.getName());
                dessertPrices.get(dessertcounter).setText("Price:" + Double.toString(fDish.getPrice()) + " L.E");
                dessertSpinners.get(dessertcounter).setVisible(true);
                dessertcounter++;
            }
        }

    }
    public void setNamefakelabel(String name)
    {
      namefakelabel.setText(name);
    }

    public void setTablenofakelabel(String tablenumber)
    {
      tablenofakelabel.setText(tablenumber);
    }


    public void goback(ActionEvent event) {
        GUIfunctions guifunction = new GUIfunctions();
        guifunction.switchScene(event, "tablescreen.fxml");
    }

    public void nextscreen(ActionEvent event) {
        Order order = new Order();
        int i, j, k;
        i = j = k = 0;
        for (FDish fDish : fRestaurant.getFDishes().getFDishes()) {
            if (fDish.getType().equalsIgnoreCase("main_course")) {
                order.calculateDishPrice(fDish, mainDishSpinners.get(i).getValue());
                order.addToOrder(fDish,mainDishSpinners.get(i).getValue());
                i++;
            } else if (fDish.getType().equalsIgnoreCase("appetizer")) {
                order.calculateDishPrice(fDish, appetizerSpinners.get(j).getValue());
                order.addToOrder(fDish, appetizerSpinners.get(j).getValue());
                j++;
            } else if (fDish.getType().equalsIgnoreCase("desert")) {
                order.calculateDishPrice(fDish, dessertSpinners.get(k).getValue());
                order.addToOrder(fDish, dessertSpinners.get(k).getValue());
                k++;
            }
        }
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orderinfoscreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                OrderinfoscreenController scene2=fxmlLoader.getController();
                scene2.printTotalprice(Double.toString(order.getTotalPrice()),order.getCustomerOrder());
                Customer customer=new Customer();
                customer.makeReservation(namefakelabel.getText(),Integer.parseInt(tablenofakelabel.getText()),order.getCustomerOrder(),order.getTotalPrice());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }

