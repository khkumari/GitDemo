package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class GenericMethod {
    public static void main(String args[]) throws Exception {
        WebDriver driver =initializeDriver();
/*        By path =By.id("username");
      //  enterText(driver,"Username",path,"khushboonirvana@gmail.com",true);
        By checkBoxPath =By.name("rememberUn");
       // selectCheckBox(driver,"Remember me",checkBoxPath,true);
        By radioButtonPath =By.cssSelector("input[id ='vfb-7-2']");
         selectRadioButton(driver,"Option2",radioButtonPath,true);
         By dropDownPath =By.name("country");
         selectDropdown(driver,"Country",dropDownPath,"BAKER ISLAND",true);
        By buttonPath =By.name("submit");
         clickOnButton(driver,"Submit",buttonPath,true);
         By clickonimagePath=By.cssSelector("a[title='Go to Facebook home']");
         clickOnImage(driver,"facebook",clickonimagePath,true);*/
       // uploadFile(driver,"Upload photo",By.id("photo-preview-lable"),true);
        testDAtePicker(driver,"12/07/2014");

    }

    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
        driver.manage().window().maximize();
        return driver;
    }

    static void testDAtePicker(WebDriver driver,String datetime) throws Exception{


        //button to open calendar

        WebElement selectDate = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[2]/ui-view[1]/div[2]/div[1]/form[1]/materializecss-decorator[3]/div[1]/sf-decorator[1]/div[1]/span[1]/span[1]/i[1]"));

        selectDate.click();

        //button to move next in calendar

        WebElement nextLink = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[2]/ui-view[1]/div[2]/div[1]/form[1]/materializecss-decorator[3]/div[1]/sf-decorator[1]/div[1]/span[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]"));

        //button to click in center of calendar header

        WebElement midLink = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[2]/ui-view[1]/div[2]/div[1]/form[1]/materializecss-decorator[3]/div[1]/sf-decorator[1]/div[1]/span[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"));

        //button to move previous month in calendar

        WebElement previousLink = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[2]/ui-view[1]/div[2]/div[1]/form[1]/materializecss-decorator[3]/div[1]/sf-decorator[1]/div[1]/span[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]"));

        //Split the date time to get only the date part

        String date_dd_MM_yyyy[] = (datetime.split(" ")[0]).split("/");

        //get the year difference between current year and year to set in calander

        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);

        midLink.click();

        if(yearDiff!=0){

            //if you have to move next year

            if(yearDiff>0){

                for(int i=0;i< yearDiff;i++){

                    System.out.println("Year Diff->"+i);

                    nextLink.click();

                }

            }

            //if you have to move previous year

            else if(yearDiff<0){

                for(int i=0;i< (yearDiff*(-1));i++){

                    System.out.println("Year Diff->"+i);

                    previousLink.click();

                }

            }

        }

        Thread.sleep(1000);

        //Get all months from calendar to select correct one

        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//table[@class='picker__table']//tbody//td"));

        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();

        Thread.sleep(1000);

        //get all dates from calendar to select correct one

        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//table[@class='picker__table']//tbody//td"));

        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();



    }


    public void uploadFile(WebDriver driver, String fieldName, By xpath,  boolean fieldFlag)
    {
        try {
            if (driver.findElement(xpath).isEnabled()) {
                driver.findElement(xpath).click();
                Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\fileUpload.exe");

                System.out.println(" Successfully uploaded file in  " + fieldName );

            }

        } catch (Exception e) {
            System.out.println(" Not uploaded file in  " + fieldName);
        }
    }
    static void clickOnImage(WebDriver driver, String fieldName, By xpath,  boolean fieldFlag)
    {
        try {
            if (driver.findElement(xpath).isEnabled()) {
                driver.findElement(xpath).click();
                System.out.println(" Successfully Clicked on " + fieldName + " Image");

            }

        } catch (Exception e) {
            System.out.println(" Not Clicked " + fieldName + " image");
        }
    }
    static void clickOnButton(WebDriver driver, String fieldName, By xpath,  boolean fieldFlag)
    {
        try {
            if (driver.findElement(xpath).isEnabled()) {
                driver.findElement(xpath).click();
                System.out.println(" Successfully Clicked on " + fieldName + " button");

            }

        } catch (Exception e) {
            System.out.println(" Not Clicked " + fieldName + " button");
        }
    }
    static void selectDropdown(WebDriver driver, String fieldName, By xpath,String fieldValue,  boolean fieldFlag) {
        try {
            if (driver.findElement(xpath).isEnabled()) {
                Select country= new Select(driver.findElement(xpath));
                country.selectByVisibleText(fieldValue);
                System.out.println(" Radiobutton is selected successfully in  " + fieldName + " field");
                fieldFlag = true;


            }

        } catch (Exception e) {
            System.out.println(" Radiobutton is not selected in  " + fieldName);
        }
    }
    static void enterText(WebDriver driver, String fieldName, By xpath, String fieldValue, boolean fieldFlag)
    {
        try{
            if(driver.findElement(xpath).isEnabled())
            {
                driver.findElement(xpath).sendKeys(fieldValue);
                System.out.println(fieldValue +" is enterd successfully in  "+ fieldName + " field");
                fieldFlag = true;
                Assert.assertTrue(true,"Passed");


            }

        }
        catch (Exception e)
        {
            System.out.println(fieldValue +" is not enter  in  "+ fieldName);
        }
    }
    static void selectCheckBox(WebDriver driver, String fieldName, By xpath,  boolean fieldFlag)
    {
        try{
            if(driver.findElement(xpath).isEnabled())
            {
                driver.findElement(xpath).click();
                System.out.println( " CheckBox is checked successfully in  "+ fieldName + " field");
                fieldFlag = true;


            }

        }
        catch (Exception e)
        {
            System.out.println(" CheckBox is not checked in  "+ fieldName);
        }
    }
    static void selectRadioButton(WebDriver driver, String fieldName, By xpath,  boolean fieldFlag)
    {
        try{
            if(driver.findElement(xpath).isEnabled())
            {
                driver.findElement(xpath).click();
                System.out.println( " Radiobutton is selected successfully in  "+ fieldName + " field");
                fieldFlag = true;


            }

        }
        catch (Exception e)
        {
            System.out.println(" CheckBox is not checked in  "+ fieldName);
        }

    }

}
