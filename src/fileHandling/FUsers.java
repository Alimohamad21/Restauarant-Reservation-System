package fileHandling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class FUsers {
    @XmlElement(name = "user")
    private List<FUser> FUsers;

    public List<FUser> getFUsers() {
        return FUsers;
    }

    public void setFUsers(List<FUser> FUsers) {
        this.FUsers = FUsers;
    }
}
