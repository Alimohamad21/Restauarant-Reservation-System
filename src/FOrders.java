import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class FOrders {
    @XmlElement(name = "order")
    private List<FOrder> FOrders;

    public List<FOrder> getFOrders() {
        return FOrders;
    }

    public void setFOrders(List<FOrder> FOrders) {
        this.FOrders = FOrders;
    }
}