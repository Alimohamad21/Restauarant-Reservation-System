import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Cook extends Employee {

    protected Cook() throws JAXBException {
    }

    @Override
    String viewStatistics() {String statistics="";
        int i=1;
       for (FOrder order : reservations.getFOrders().getFOrders())
       {
           statistics+=i+")"+"Table:"+order.getTableNumber()+"\n-Order:\n"+order.getOrderedDishes()+"\n\n";
           i++;
       }
        return statistics;
    }
}
