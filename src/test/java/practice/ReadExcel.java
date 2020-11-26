package practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcel {
    public static void main(String args[]) {
        try {
            FileInputStream file = new FileInputStream(new File("data.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.STRING)
                        System.out.print(cell.getStringCellValue() + "\t");
                    else if (cell.getCellType() == CellType.NUMERIC)
                        System.out.print(cell.getNumericCellValue() + "\t");

                }
                System.out.println("");
            }
            file.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getDataFromExcelFile(String location, String fileName, String sheetName, String columnName, int rowNumber) throws IOException {
        FileInputStream file = new FileInputStream(new File(location + "/" + fileName));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> iterator = sheet.iterator();
        Row row = iterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        int k = 0;
        int coloumn = 0;
        while (cellIterator.hasNext()) {
            Cell value = cellIterator.next();
            if (value.getStringCellValue().equalsIgnoreCase(columnName)) {
                coloumn = k;

            }
            k++;
            while (iterator.hasNext()) {

                Row r = iterator.next();

                if (r.getCell(coloumn).getStringCellValue().equals(rowNumber)) {

////after you grab purchase testcase row = pull all the data of that row and feed into test

                    Iterator<Cell> cv = r.cellIterator();
                    while (cv.hasNext()) {
                        Cell c = cv.next();
                        if (c.getCellType() == CellType.STRING) {

                            c.getStringCellValue();
                        } else {

                            c.getNumericCellValue();
                        }
                    }
                }
            }
        }
    }
}