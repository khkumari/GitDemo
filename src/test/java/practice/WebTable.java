package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WebTable {
    public static void main(String args[]) throws IOException {
        WebDriver driver =initializeDriver();
        By payh= By.xpath("//*[@id='countries']/tbody");
        writeWebTableInExcel(payh,  driver);
    }
    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        return driver;
    }
    public static void writeWebTableInExcel(By xpath1, WebDriver driver) throws IOException {
        WebElement table = driver.findElement(xpath1);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rowcount = rows.size();
        FileOutputStream fis = new FileOutputStream(new File("webtable.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet("First Sheet");
        for (int row = 0; row < rowcount; row++) {
            List<WebElement> columns_inrow = rows.get(row).findElements(By.tagName("td"));
            int columns_count = columns_inrow.size();
            System.out.println("Number of cells in Row " + row + " are " + columns_count);
            Row ro = sh.createRow(row);
            for (int column = 0; column < columns_count; column++) {

                String celltext = columns_inrow.get(column).getText();
                System.out.println(
                        "Cell Value of row number " + row + " and column number " + column + " Is " + celltext);
                ro.createCell(column).setCellValue(celltext);
            }
            System.out.println("===========================");

        }
        wb.write(fis);
        wb.close();

    }


}
