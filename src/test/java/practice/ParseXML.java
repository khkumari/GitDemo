package practice;

import org.w3c.dom.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;

public class ParseXML {
    public static void main(String args[])
    {


        try
        {
            File inputfile =new File("Student.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputfile);
            doc.getDocumentElement().normalize();
            NodeList nlist =doc.getElementsByTagName("Stmt");
            System.out.println(nlist);
            System.out.println("------------------");
          /*  for(int temp=0;temp< nlist.getLength();temp++)
            {
                Node node= nlist.item(temp);
                System.out.println("\nCurrent Element :" + node.getNodeName());
                if(node.getNodeType() ==Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    System.out.println("Student roll no : " + element.getAttribute("rollno"));
                    System.out.println("First Name : " + element.getElementsByTagName("firstname").item(0)
                            .getTextContent());
                    System.out.println("Last Name : "
                            + element
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Nick Name : "
                            + element
                            .getElementsByTagName("nickname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Marks : "
                            + element
                            .getElementsByTagName("marks")
                            .item(0)
                            .getTextContent());
                }
            }*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
