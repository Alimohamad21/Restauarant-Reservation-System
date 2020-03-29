import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public abstract class Restaurant {
    public double dayIncome = 0;


    public static abstract class User {
        private String name;
        private String username;
        private String role;
        private String password;

        abstract String viewOrders() throws JAXBException;
    }

    public class Manager extends User {
        String viewOrders() throws JAXBException {
            String buffer = "";
            JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));

            return buffer;
        }

        String viewIncome() {
            return Double.toString(dayIncome);
        }
    }

    public class Chef extends User {
        String viewOrders() throws JAXBException {
            String buffer = "";
            JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));

            return buffer;
        }
    }

    public static class Waiter extends User {
        String viewOrders() throws JAXBException {
            String buffer = "";
            JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("inputData.xml"));
            for (FUser fUser : fRestaurant.getFUsers().getFUsers()){
                if(fUser.getRole().equals("Client"))
                    buffer+="Name:" + fUser.getName() + "\n";
            }

            for(FTable fTable : fRestaurant.getFTables().getFTables()){
               buffer+="Table number : " + fTable.getNumber() + "\n";
            }
            return buffer;
        }
    }

        public class Customer extends User {
            String viewOrders() {
                String buffer = "";


                return buffer;
            }
        }
    }






