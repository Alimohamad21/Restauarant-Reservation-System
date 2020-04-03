package fileHandling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class FDishes {
    @XmlElement(name = "dish")
    private List<FDish> FDishes;

    public List<FDish> getFDishes() {
        return FDishes;
    }

    public void setFDishes(List<FDish> FDishes) {
        this.FDishes = FDishes;
    }
}
