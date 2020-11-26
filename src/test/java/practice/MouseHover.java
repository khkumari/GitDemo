package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
    public static void main(String[] args)
    {
        WebDriver driver =initializeDriver();
        By path =By.id("twotabsearchtextbox");
        By path1 =By.cssSelector("a[id='nav-link-accountList']");
        mouseHoverAndKeyboard(path,path1,driver);



    }
    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        return driver;
    }
    public static void mouseHoverAndKeyboard(By xpath1,By xpath, WebDriver driver)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(xpath1)).click().keyDown(Keys.SHIFT).
                sendKeys("mobile").build().perform();
        //mouse hovering
        WebElement move = driver.findElement(xpath);
        actions.moveToElement(move).build().perform();
    }
}
