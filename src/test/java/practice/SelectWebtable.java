package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class SelectWebtable {
    public static void main(String args[]) throws IOException {
        WebDriver driver =initializeDriver();
        clickedWebTableCheckBox("Cape Verde", By.xpath("//*[@id='countries']/tbody"),  driver);
    }
    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        return driver;
    }

    public static void clickedWebTableCheckBox(String country, By xpath1, WebDriver driver) throws IOException {
        WebElement table = driver.findElement(xpath1);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rowcount = rows.size();
        for (int row = 0; row < rowcount; row++) {
            List<WebElement> columns_inrow = rows.get(row).findElements(By.tagName("td"));
            int columns_count = columns_inrow.size();
            for (int column = 0; column < columns_count; column++) {

                String celltext = columns_inrow.get(column).getText();
                if (celltext.equals(country))
                {
                    int rownum= ++row;
                    driver.findElement(By.xpath("//tbody/tr["+rownum+"]/td[1]/input[1]")).click();
                    System.out.println("Number of cells in Row " + row + " are " + columns_count);
                }
            }
        }
    }
}
