package fileHandling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class FTables {
    @XmlElement(name = "table")
    private List<FTable> FTables;

    public List<FTable> getFTables() {
        return FTables;
    }

    public void setFTables(List<FTable> FTables) {
        this.FTables = FTables;
    }
}
