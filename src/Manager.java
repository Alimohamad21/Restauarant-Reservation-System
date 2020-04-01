import javax.xml.bind.JAXBException;

public class Manager extends Employee {
    protected Manager() throws JAXBException {
    }

    @Override
    String viewStatistics() {String statistics="";
        int i=1;
        for (FOrder order : reservations.getFOrders().getFOrders())
        {
            statistics+=i+")"+"Table:"+order.getTableNumber()+"\n-Name:"+order.getName()+"\n-Order:\n"+order.getOrderedDishes()+"\n-Total price:"+order.getTotalPrice()+"\n\n";
            i++;
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
}
