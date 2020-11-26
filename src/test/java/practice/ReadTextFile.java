package practice;

import java.io.*;
import java.util.HashMap;

public class ReadTextFile {
    public static void main(String[] args) throws IOException {
        createFile("Text.txt");
        writeToFile("Text.txt");
        System.out.println(readLineByLine("Text.txt","Airtel"));

    }

    public static void createFile(String fileName)
    {
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\"+ fileName);
        try {
            if(file.createNewFile())
            {
                System.out.println("File created: " + file.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile(String fileName)
    {
        try {
            FileWriter fileWriter=new FileWriter(System.getProperty("user.dir")+"\\src\\main\\resources\\"+ fileName);
            fileWriter.write("MOBILE SERVICES\n" +
                    "Original Copy for Recipient - Tax Invoice\n" +
                    "Ms Kumari Khushboo\n" +
                    "Sopra India Private Limited\n" +
                    "Plot No-a67,\n" +
                    "Sector-64\n" +
                    "Noida\n" +
                    "Noida 201301\n" +
                    "Uttar Pradesh\n" +
                    "Landmark :.\n" +
                    "8826338522 1342241891\n" +
                    "POS: Uttar Pradesh\n" +
                    "Email ID: KHUSHBOONIRVANA@GMAIL.COM\n" +
                    "Airtel number: 8826338522\n" +
                    "Relationship number: 1342241891\n" +
                    "Bill number: BM2109I004410680\n" +
                    "State Code: 09\n" +
                    "GST No/UIN No:");
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    static String readLineByLine(String fileName, String key) throws IOException {
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\"+ fileName);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        HashMap<String, String> data = new HashMap<String, String>();
        while((line=bufferedReader.readLine())!=null)
        {
            stringBuffer.append(line);
            stringBuffer.append("\n");
            if(line.contains(key))
            {
                return line;

            }
            //String[] s = check.split(" ", 1);

        }
       // fileReader.close();
        return null;
    }
}
