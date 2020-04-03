package logic;

import fileHandling.FOrder;
import fileHandling.FOrders;
import fileHandling.FReservations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    public Manager() throws JAXBException {
    }


    @Override
    public String viewStatistics() {
        String statistics = "";
        int i = 1;
        for (FOrder order : reservations.getFOrders().getFOrders()) {
            if (!order.getName().equals("")) { //So it doesn't read fake customer
                statistics += i + ")" + "Table:" + order.getTableNumber() + "\n-Name:" + order.getName() + "\n-logic.Order:\n" + order.getOrderedDishes() + "\n-Total price:" + order.getTotalPrice() + " L.E\n\n";
                i++;
            }
        }
        return statistics;
    }

    public String viewTotalIncome() {
        Double totalIncome = 0.0;
        for (FOrder order : reservations.getFOrders().getFOrders()) {
            totalIncome += order.getTotalPrice();
        }
        return Double.toString(totalIncome);
    }

    public void deleteReservation(int tableNumber) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FReservations.class);
        File file = new File("saveData.xml");
        Marshaller marshaller = jaxbContext.createMarshaller();
        FReservations reservation = new FReservations();
        FOrders forders = new FOrders();
        List<FOrder> orderList = new ArrayList<>();
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FReservations reservations = (FReservations) unmarshaller.unmarshal(file);
            for (FOrder order1 : reservations.getFOrders().getFOrders()) {
                if (order1.getTableNumber() == tableNumber)
                    continue;
                orderList.add(order1);
            }
        } catch (Exception e) {

        }
        forders.setFOrders(orderList);
        reservation.setFOrders(forders);
        marshaller.marshal(reservation, new File("saveData.xml"));
    }

    public void clearAllReservations() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FReservations.class);
        File file = new File("saveData.xml");
        Marshaller marshaller = jaxbContext.createMarshaller();
        FReservations reservation = new FReservations();
        reservation.setFOrders(null);
        marshaller.marshal(reservation, new File("saveData.xml"));
    }
}
