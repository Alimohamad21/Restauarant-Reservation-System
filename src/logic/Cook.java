package logic;

import fileHandling.FOrder;

import javax.xml.bind.JAXBException;

public class Cook extends Employee {

    public Cook() throws JAXBException {
    }

    @Override
    public String viewStatistics() {
        String statistics = "";
        int i = 1;
        for (FOrder order : reservations.getFOrders().getFOrders()) {
            if (!order.getName().equals("")) {//So it doesn't read fake customer
                statistics += i + ")" + "Table:" + order.getTableNumber() + "\n-Order:\n" + order.getOrderedDishes() + "\n\n";
                i++;
            }
        }
        return statistics;
    }
}
