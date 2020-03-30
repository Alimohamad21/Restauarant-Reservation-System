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

        JAXBContext jaxbContext= JAXBContext.newInstance(FRestaurant.class);
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));

        for (FUser fUser : fRestaurant.getFUsers().getFUsers()){
            System.out.println("name:" + fUser.getName() + "\n" + "role:" + fUser.getRole() + "\n" + "username:" + fUser.getUsername() + "\n" + "password:" + fUser.getPassword() + "\n" + "--------------");
        }

        for(FTable fTable : fRestaurant.getFTables().getFTables()){
            System.out.println("table number : " + fTable.getNumber() + "\n" + "number of seats : " + fTable.getNumberOfSeats() + "\n" + "smoking : " + fTable.isSmoking() + "\n" + "-----------------" ) ;
        }

        for (FDish fDish : fRestaurant.getFDishes().getFDishes()){
            System.out.println("dish name : " + fDish.getName() + "\n" + "price : " + fDish.getPrice() + "\n" + "type :" + fDish.getType() + "\n" + "--------------");
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        FRestaurant savedFRestaurant = new FRestaurant();
        FUsers fUsers = new FUsers();
        FUser FUser1 = new FUser();
        FUser1.setRole("customer");
        FUser1.setName("khaled gamal");
        FUser1.setUsername("khaled00gamal");
        FUser1.setPassword("12345678");
        List<FUser> FUserList = new ArrayList<>();
        FUserList.add(FUser1);
        fUsers.setFUsers(FUserList);
        savedFRestaurant.setFUsers(fUsers);
        FTables fTables =new FTables();
        FTable fTable1 =new FTable();
        fTable1.setNumber(7);
        fTable1.setNumberOfSeats(2);
        fTable1.setSmoking(false);
        List<FTable> FTableList = new ArrayList<>();
        FTableList.add(fTable1);
        fTables.setFTables(FTableList);
        savedFRestaurant.setFTables(fTables);
        FDishes fDishes =new FDishes();
        FDish FDish1 =new FDish();
        FDish1.setName("fried chicken");
        FDish1.setPrice(65);
        FDish1.setType("main course");
        List<FDish> FDishList = new ArrayList<>();
        FDishList.add(FDish1);
        fDishes.setFDishes(FDishList);
        savedFRestaurant.setFDishes(fDishes);
        marshaller.marshal(savedFRestaurant,new File("saveData.xml"));
        System.out.println();
        /*Restaurant.Waiter waiter=new Restaurant.Waiter();
        System.out.println("here");
        System.out.println(waiter.viewOrders());*/
    }
}
