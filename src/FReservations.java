import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reservations")
@XmlAccessorType(XmlAccessType.FIELD)
public class FReservations {
    @XmlElement(name = "orders")
    private FOrders FOrders = null;
    public FOrders getFOrders() {
        return FOrders;
    }
    public void setFOrders(FOrders FOrders) {
        this.FOrders = FOrders;
    }
}
