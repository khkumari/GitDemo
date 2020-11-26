package practice;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PdfFileRead {
    public static void main(String[] args) throws IOException {
        System.out.println(returnData("Adjustments"));

    }
    public static String returnData(String key)
    {
       // File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\invoice-GNOZTIHF-03-2018-0000745.pdf");
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\AirtelBill.pdf");
        //File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Khushboo.pdf");
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PDFTextStripper pdfTextStripper = null;
        try {
            pdfTextStripper = new PDFTextStripper();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = null;
        try {
            text = pdfTextStripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
       String[] text1 =text.split("\n");
        for(int i=0;i<text1.length;i++)
        {
            if(text1[i].contains(key))
            {
                return text1[i];
            }

        }
        return null;
/*         HashMap<String, String> data = new HashMap<String, String>();
        for(int i=0;i<text1.length;i++)
        {
            if(text1[i].contains(":"))
            {
                String[] split = text1[i].split(":");
                data.put(split[0],split[1]);
            }
        }
         return data.get(key);*/
    }

}
