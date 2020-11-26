package practice;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadExcel1 {
    public static void main(String[] args) throws IOException {
        System.out.println(getDataFromExcelFile("", "data.xlsx", "student Details", "Name", 2));
    }

    public static String getDataFromExcelFile(String location, String fileName, String sheetName, String columnName, int rowNumber) throws IOException {
        FileInputStream file = new FileInputStream(new File(location + fileName));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int col_Num = -1;
        Row row = sheet.getRow(0);
        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim()))
                col_Num = i;
        }

        row = sheet.getRow(rowNumber - 1);
        Cell cell = row.getCell(col_Num);

        if (cell.getCellType() == CellType.STRING)
            return cell.getStringCellValue();
        else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
            String cellValue = String.valueOf(cell.getNumericCellValue());
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                DateFormat df = new SimpleDateFormat("dd/MM/yy");
                Date date = cell.getDateCellValue();
                cellValue = df.format(date);
            }
            return cellValue;
        } else if (cell.getCellType() == CellType.BLANK)
            return "";
        else
            return String.valueOf(cell.getBooleanCellValue());
    }
}

