import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class FOrder {
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="table")
    private int tableNumber;
    @XmlElement(name="dishes")
    private String orderedDishes;
    @XmlElement(name="price")
    private double totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(String orderedDishes) {
        this.orderedDishes =orderedDishes;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
