package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        //driver.findElement(By.id("id")).sendKeys("Khushboo");
        try {
            sendKeys(driver.findElement(By.id("email1")), "Khushboo");
        }
        catch (Exception e)
        {
            System.out.println("found exception");
        }

        sendKeys(driver.findElement(By.id("pass")), "Khushboo");


    }


    public static void sendKeys(WebElement element, String key)
    {
        try {
            element.sendKeys(key);
        } catch (Exception e) {
        e.printStackTrace();
            System.out.println("found exception");
    }
    }

}
