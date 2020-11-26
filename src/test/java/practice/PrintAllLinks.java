package practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class PrintAllLinks {
    public static void main(String args[]) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("Link Details");
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        sheet1.createRow(0).createCell(0);
        String url = "";
        HttpURLConnection huc;
        int respCode = 200;
        System.out.println(links.size());
        int cell = 0;
        for (int i = 0; i < links.size(); i++) {
            WebElement alinks = links.get(i);
            String allinks = alinks.getAttribute("href");
            XSSFRow row = sheet1.createRow(i);
            XSSFCell excelCell = row.createCell(cell);
            excelCell.setCellValue(allinks);


        }
        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){
            url = it.next().getAttribute("href");
            System.out.println(url);
            if(url == null||url.equals("")){
                System.out.println("URL is not yet published");
                System.out.println(url+" is a broken link");

            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();
                for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
                    Cell resultCell = sheet1.getRow(i).getCell(1);
                    if (resultCell == null) {
                        resultCell = sheet1.getRow(i).createCell(1);
                    }

                    if (respCode >= 400) {
                        System.out.println(url + " is a broken link");
                        resultCell.setCellValue("FAIL");
                    } else {
                        System.out.println(url + " is a valid link");
                        resultCell.setCellValue("PASS");
                    }
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream out = new FileOutputStream(new File("data1.xlsx"));
        workbook.write(out);
    }
    }