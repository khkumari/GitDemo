package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class VerifyToolTip {
    public static void main(String args[]) throws IOException {
        WebDriver driver =initializeDriver();
        verifyToolTip( By.id("download_now"),  driver);
    }
    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/tooltip.html");
        return driver;
    }
    public static void verifyToolTip(By xpath1, WebDriver driver)
    {
        String expectedTooltip = "What's new in 3.2";
        WebElement download = driver.findElement(xpath1);
        Actions builder = new Actions(driver);
        builder.clickAndHold().moveToElement(download).build().perform();
        WebElement toolTipElement = driver.findElement(By.xpath("//a[contains(text(),\"What's new in 3.2\")]"));
        String actualToolTip= toolTipElement.getText();
        if (actualToolTip.equals(expectedTooltip))
        {
            System.out.println("Test case is passed");
        }
        driver.close();


    }

}
