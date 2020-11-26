package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class FindBrokenLinks {
    public static void main(String args[]) throws IOException {
        WebDriver driver =initializeDriver();
        By path =By.cssSelector("li[class='gf-li'] a");
        findBrokenLinks(path,driver);
    }
    public static void findBrokenLinks(By xpath1, WebDriver driver)
    {
        List<WebElement> links =driver.findElements(xpath1);
        for(WebElement link: links)
        {
            String url=link.getAttribute("href");
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection)new URL(url).openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.setRequestMethod("HEAD");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            try {
                connection.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int respCode = 0;
            try {
                respCode = connection.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(respCode);
            if(respCode>400)
            {
                System.out.println("The link with text "+ link.getText()+" is  broken with code " + respCode);
            }
        }
    }
    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        return driver;
    }
}
