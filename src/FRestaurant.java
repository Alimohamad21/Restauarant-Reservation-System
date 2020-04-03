import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class FRestaurant {
    @XmlElement(name = "users")
    private FUsers FUsers = null;

    public FUsers getFUsers() {
        return FUsers;
    }

    public void setFUsers(FUsers FUsers) {
        this.FUsers = FUsers;
    }

    @XmlElement(name = "tables")
    private FTables FTables = null;

    public FTables getFTables() {
        return FTables;
    }

    public void setFTables(FTables FTables) {
        this.FTables = FTables;
    }

    @XmlElement(name = "dishes")
    private FDishes FDishes = null;

    public FDishes getFDishes() {
        return FDishes;
    }

    public void setFDishes(FDishes FDishes) {
        this.FDishes = FDishes;
    }

}
