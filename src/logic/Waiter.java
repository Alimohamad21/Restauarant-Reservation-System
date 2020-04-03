package logic;

import fileHandling.FOrder;

import javax.xml.bind.JAXBException;

public class Waiter extends Employee {
    public Waiter() throws JAXBException {
    }

    @Override
    public String viewStatistics() {
        String statistics = "";
        int i = 1;
        for (FOrder order : reservations.getFOrders().getFOrders()) {
            if (!order.getName().equals("")) { //So it doesn't read fake customer
                statistics += i + ")" + "Table:" + order.getTableNumber() + "\n-Name:" + order.getName() + "\n\n";
                i++;
            }
        }
        return statistics;
    }
}
