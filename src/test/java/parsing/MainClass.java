package parsing;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

        public static void main(String[] args) throws JAXBException {
           String output = readXML("MsgIDTest4","CD");

            System.out.println(output);


        }
        public static String readXML(String msgId, String attribute)
        {
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(DocumentBuilder.class);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            Unmarshaller jaxbUnmarshaller = null;
            try {
                jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            //We had written this file in marshalling example
            DocumentBuilder emps = null;
            try {
                emps = (DocumentBuilder) jaxbUnmarshaller.unmarshal(new File("D:/Profiles/Student.xml"));
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            List<String> certificationOfDebit = new ArrayList<String>();
            String iban = null;
            for(CustomerStatement customerStatement : emps.getBankCustmrStatement().getStatement()){
                if(customerStatement.getId().equals(msgId)){
                    if(attribute.equals("IBAN")){
                        if(customerStatement.getAccount().getIdentification().getiBan()!= null){
                            iban = customerStatement.getAccount().getIdentification().getiBan();
                        }
                    }else if(attribute.equals("CD")){
                        if(customerStatement.getBalance()!= null){
                            for (Balance balance: customerStatement.getBalance()){
                                if(balance.getThirdParty().getCdParty().getCd()!= null){
                                    certificationOfDebit.add(balance.getThirdParty().getCdParty().getCd());
                                }
                            }
                        }
                    }
                }
            }

            if("IBAN".equals(attribute)){
                if(iban != null && attribute.equals("IBAN")){
                    return iban;
                }else{
                    return "IBAN not present";
                }
            }else {
                if(!certificationOfDebit.isEmpty() && attribute.equals("CD")){
                    return certificationOfDebit.toString();
                }else {
                    return "CD not present";
                }
            }
        }
    }

