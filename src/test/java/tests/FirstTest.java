package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class FirstTest extends BaseTest{

    //WebDriver driver;
    @Test
    public void test(){
        driver.get("http://www.selenium-shop.pl/");

        Assert.assertEquals(driver.getTitle(),"Selenium Shop Automatyzacja Testów");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMyAccount();
        takeScreenShot();
    }
}
