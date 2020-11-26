package parsing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Stmt")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerStatement {

    @XmlElement(name = "Id")
    private String id;

    @XmlElement(name = "Acct")
    private Account account;

    @XmlElement(name = "Bal")
    private List<Balance> balance = new ArrayList<Balance>();

    public List<Balance> getBalance() {
        return balance;
    }

    public void setBalance(List<Balance> balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CustomerStatement{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", balance=" + balance +
                '}';
    }
}
