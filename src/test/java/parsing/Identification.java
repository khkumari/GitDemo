package parsing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Id")
@XmlAccessorType(XmlAccessType.FIELD)
public class Identification {

    @XmlElement(name = "IBAN")
    private String iBan;

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    @Override
    public String toString() {
        return "Identification{" +
                "iBan='" + iBan + '\'' +
                '}';
    }
}
