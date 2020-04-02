import javax.xml.bind.JAXBException;
public class Waiter extends Employee {
    protected Waiter() throws JAXBException {
    }

    @Override
    String viewStatistics() {String statistics="";
        int i=1;
        for (FOrder order : reservations.getFOrders().getFOrders()) {
            if (!order.getName().equals("")) { //So it doesn't read fake customer
                statistics += i + ")" + "Table:" + order.getTableNumber() + "\n-Name:" + order.getName() + "\n\n";
                i++;
            }
        }
        return statistics;
    }
}
