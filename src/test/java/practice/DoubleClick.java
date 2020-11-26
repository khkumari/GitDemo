package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class DoubleClick {
    public static void main(String args[]) throws IOException {
        WebDriver driver =initializeDriver();
        By path =By.xpath("//button[@ondblclick='myFunction()']");
        doubleClick(path ,  driver);
        By rightClickPath =By.xpath("//span[contains(text(),'right click me')]");
        rightClick(rightClickPath,driver);
    }
    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        return driver;
    }
    public static void doubleClick(By xpath1, WebDriver driver)
    {
        Actions action = new Actions(driver);
        WebElement link= driver.findElement(xpath1);
        action.doubleClick(link).perform();
        Alert alert= driver.switchTo().alert();
        System.out.println("Alert Text\n" +alert.getText());
        alert.accept();
        }
    public static void rightClick(By xpath1, WebDriver driver)
    {
       // driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions action = new Actions(driver);
        WebElement link= driver.findElement(xpath1);
        action.contextClick(link).perform();
        WebElement element= driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
        element.click();
        Alert alert= driver.switchTo().alert();
        System.out.println("Alert Text\n" +alert.getText());
        alert.accept();
    }

}
