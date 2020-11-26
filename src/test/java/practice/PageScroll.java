package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageScroll {
/*    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        WebElement scrollDown = driver.findElement(By.id("philadelphia-field-email"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",scrollDown);
    }*/
public static void main(String[] args)
{
    WebDriver driver =initializeDriver();
    By path =By.linkText("VBScript");
    pageScroll(path,driver);
}
    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        return driver;
    }
    public static void pageScroll(By xpath1, WebDriver driver)
    {
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        WebElement scrollDown = driver.findElement(xpath1);
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}


