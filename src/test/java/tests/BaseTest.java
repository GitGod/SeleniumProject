package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;

public class BaseTest {

   protected WebDriver driver;
   protected static ExtentSparkReporter htmlReporter;
   protected static ExtentReports extentReports;

@BeforeSuite
   public void beforeSuite(){
       htmlReporter = new ExtentSparkReporter("index.html");
        extentReports = new ExtentReports();
       extentReports.attachReporter(htmlReporter);
   }
   @AfterSuite
   public void afterSuite(){
    extentReports.flush();
   }
    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("http://www.selenium-shop.pl/");
    }

    public String takeScreenShot(String name){
    TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try{
            String destination = "src/main/resources"+name+System.currentTimeMillis()+".png";
            FileUtils.copyFile(src,new File(destination));
           return destination;

        }catch (IOException e){
            System.out.println(e.getMessage());
            return "Save screen failed";
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
