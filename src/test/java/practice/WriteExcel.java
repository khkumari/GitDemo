package practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteExcel {
    public static void main(String args[])
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("student Details");
        Map<String,Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"ID","Name","LastName"});
        data.put("2", new Object[]{"1","Ram","Kumar"});
        data.put("3", new Object[]{"2","Khushboo","Yadav"});
        data.put("4", new Object[]{"3","Shyam","Kumar"});
        Set<String> keySet =  data.keySet();
        int rownum =0;
        for(String key : keySet)
        {
            Row row = sheet.createRow(rownum++);
            Object[] objarr = data.get(key);
            int cellnum =0;
            for(Object obj: objarr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                {
                    cell.setCellValue((String)obj);
                }
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("data.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("data.xlsx written successfully on disk.");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
