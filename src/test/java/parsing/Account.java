package parsing;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Acct")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    @XmlElement(name="Id")
    private Identification identification;

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    @Override
    public String toString() {
        return "Account{" +
                "identification=" + identification +
                '}';
    }
}
