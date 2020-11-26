package parsing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Tp")
@XmlAccessorType(XmlAccessType.FIELD)
public class ThirdParty {

    @XmlElement(name = "CdOrPrtry")
    private CdParty cdParty;

    public CdParty getCdParty() {
        return cdParty;
    }

    public void setCdParty(CdParty cdParty) {
        this.cdParty = cdParty;
    }
}
