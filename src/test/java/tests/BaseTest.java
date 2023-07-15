package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;

public class BaseTest {

   protected WebDriver driver;
    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    public void takeScreenShot(){
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src,new File("src/main/resources" + System.currentTimeMillis() + " sccreenshot.png"));

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
