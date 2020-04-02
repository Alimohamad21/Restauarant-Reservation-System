import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    protected Manager() throws JAXBException {
    }
    private boolean deleteConfirmed=false;

    public boolean isDeleteConfirmed() {
        return deleteConfirmed;
    }

    @Override
    String viewStatistics() {String statistics="";
        int i=1;
        for (FOrder order : reservations.getFOrders().getFOrders())
        {if(!order.getName().equals("")) { //So it doesn't read fake customer
            statistics += i + ")" + "Table:" + order.getTableNumber() + "\n-Name:" + order.getName() + "\n-Order:\n" + order.getOrderedDishes() + "\n-Total price:" + order.getTotalPrice() + "\n\n";
            i++;
        }
        }
        return statistics;
    }
    String viewTotalIncome() {Double totalIncome=0.0;
        for (FOrder order : reservations.getFOrders().getFOrders())
        {
           totalIncome+=order.getTotalPrice();
        }
        return Double.toString(totalIncome);
    }
    void deleteReservation(String name) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FReservations.class);
        File file=new File("saveData.xml");
        Marshaller marshaller = jaxbContext.createMarshaller();
        FReservations reservation=new FReservations();
        FOrders forders = new FOrders();
        List<FOrder> orderList=new ArrayList<>();
        try{
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FReservations reservations = (FReservations) unmarshaller.unmarshal(file);
            for (FOrder order1 : reservations.getFOrders().getFOrders()) {
                if(order1.getName().equalsIgnoreCase(name))
            {this.deleteConfirmed=true;
                continue;
            }
                orderList.add(order1);
            }
        }catch(Exception e){

        }
        forders.setFOrders(orderList);
        reservation.setFOrders(forders);
        marshaller.marshal(reservation,new File("saveData.xml"));
    }
}
