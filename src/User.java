import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class User {

     void signUp(String name,String username,String password,String role) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
        File file=new File("inputData.xml");
        FRestaurant restaurant=new FRestaurant();
        Marshaller marshaller = jaxbContext.createMarshaller();
        FUsers users = new FUsers();
        FUser user=new FUser();
        List<FDish> dishList=new ArrayList<>();
        List<FTable> tableList=new ArrayList<>();
        List<FUser> userList=new ArrayList<>();
        FDishes dishes=new FDishes();
        FTables tables=new FTables();
        try{
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FRestaurant restaurant1 = (FRestaurant) unmarshaller.unmarshal(file);
            for (FUser user1 : restaurant1.getFUsers().getFUsers())
                userList.add(user1);
            for (FTable fTable : restaurant1.getFTables().getFTables())
                tableList.add(fTable);
                for (FDish fDish : restaurant1.getFDishes().getFDishes())
                    dishList.add(fDish);
                dishes.setFDishes(dishList);
                tables.setFTables(tableList);
                restaurant.setFDishes(dishes);
                restaurant.setFTables(tables);
        }catch(Exception e){
        }
        user.setName(name);
        user.setUsername(username);
        user.setRole(role);
        user.setPassword(password);
        userList.add(user);
        users.setFUsers(userList);
        restaurant.setFUsers(users);
        marshaller.marshal(restaurant,new File("inputData.xml"));
    }
}
