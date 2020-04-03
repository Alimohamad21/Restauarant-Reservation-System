import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.sun.deploy.util.Waiter;

public class Main {
    public static void main(String[] args) throws JAXBException {


        /*FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));

        for (FUser fUser : fRestaurant.getFUsers().getFUsers()) {
            System.out.println("name:" + fUser.getName() + "\n" + "role:" + fUser.getRole() + "\n" + "username:" + fUser.getUsername() + "\n" + "password:" + fUser.getPassword() + "\n" + "--------------");
        }

        for (FTable fTable : fRestaurant.getFTables().getFTables()) {
            System.out.println("table number : " + fTable.getNumber() + "\n" + "number of seats : " + fTable.getNumberOfSeats() + "\n" + "smoking : " + fTable.isSmoking() + "\n" + "-----------------");
        }

        for (FDish fDish : fRestaurant.getFDishes().getFDishes()) {
            System.out.println("dish name : " + fDish.getName() + "\n" + "price : " + fDish.getPrice() + "\n" + "type :" + fDish.getType() + "\n" + "--------------");
        }*/
        Manager manager=new Manager();
        manager.clearAllReservations();
        User user=new User();
        Customer customer=new Customer();
        //customer.makeReservation("ali",5,"tuna",1.0);
    }
}
