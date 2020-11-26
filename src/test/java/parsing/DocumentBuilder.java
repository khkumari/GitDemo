package parsing;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentBuilder {
    /*@XmlElement(name="Test")
    String test;*/

    @XmlElement(name="BkToCstmrStmt")
    private BankCustmrStatement bankCustmrStatement = new BankCustmrStatement();

    public BankCustmrStatement getBankCustmrStatement() {
        return bankCustmrStatement;
    }

    public void setBankCustmrStatement(BankCustmrStatement bankCustmrStatement) {
        this.bankCustmrStatement = bankCustmrStatement;
    }

    /*public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }*/

    @Override
    public String toString() {
        return "DocumentBuilder{" +
                "bankCustmrStatement=" + bankCustmrStatement +
                '}';
    }
}
