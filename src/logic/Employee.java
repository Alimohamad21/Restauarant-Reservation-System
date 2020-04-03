package logic;

import fileHandling.FReservations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public abstract class Employee {
    JAXBContext jaxbContext = JAXBContext.newInstance(FReservations.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    FReservations reservations = (FReservations) unmarshaller.unmarshal(new File("saveData.xml"));

    protected Employee() throws JAXBException {
    }

    abstract String viewStatistics();
}
