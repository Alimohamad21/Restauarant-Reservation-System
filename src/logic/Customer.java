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

public class Customer {

    public Customer() throws JAXBException {
    }

   public void makeReservation(String name, int tableNumber, String order, Double totalPrice) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FReservations.class);
        File file = new File("saveData.xml");
        Marshaller marshaller = jaxbContext.createMarshaller();
        FReservations reservation = new FReservations();
        FOrders forders = new FOrders();
        FOrder forder = new FOrder();
        List<FOrder> orderList = new ArrayList<>();
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FReservations reservations = (FReservations) unmarshaller.unmarshal(file);
            for (FOrder order1 : reservations.getFOrders().getFOrders())
                orderList.add(order1);
        } catch (Exception e) {

        }
        forder.setName(name);
        forder.setTableNumber(tableNumber);
        forder.setTotalPrice(totalPrice);
        forder.setOrderedDishes(order);
        orderList.add(forder);
        forders.setFOrders(orderList);
        reservation.setFOrders(forders);
        marshaller.marshal(reservation, new File("saveData.xml"));
    }
}
