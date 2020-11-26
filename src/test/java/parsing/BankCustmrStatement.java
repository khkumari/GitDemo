package parsing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "BkToCstmrStmt")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankCustmrStatement {

    @XmlElement(name="Test1")
    private String test;

    @XmlElement(name="Stmt")
    private List<CustomerStatement> statement = new ArrayList<CustomerStatement>();

    public List<CustomerStatement> getStatement() {
        return statement;
    }

    public void setStatement(List<CustomerStatement> statement) {
        this.statement = statement;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "BankCustmrStatement{" +
                "test='" + test + '\'' +
                ", statement=" + statement +
                '}';
    }
}
