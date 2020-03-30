import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public abstract class Restaurant {
    public double dayIncome = 0;
    static abstract class User {
        private String name;
        private String role;
        abstract String viewOrders() ;
        JAXBContext jaxbContext = JAXBContext.newInstance(FRestaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        FRestaurant fRestaurant = (FRestaurant) unmarshaller.unmarshal(new File("savedData.xml"));
        protected User() throws JAXBException {
        }
    }


    public class Manager extends User {
        protected Manager() throws JAXBException {
        }

        String viewOrders()  {
            String buffer = "";

            return buffer;
        }

        String viewIncome() {
            return Double.toString(dayIncome);
        }
    }

    public class Chef extends User {
        protected Chef() throws JAXBException {
        }

        String viewOrders() {
            String buffer = "";


            return buffer;
        }
    }

    public class Waiter extends User {
        protected Waiter() throws JAXBException {
        }

        String viewOrders() {
            String buffer = "";

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
            protected Customer() throws JAXBException {
            }

            String viewOrders() {
                String buffer = "";


                return buffer;
            }
        }
    }






