package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.SeleniumHelper;

import java.io.File;

public class ProjectTest extends BaseTest{
    @Test
    public void buyProduct(){
        ExtentTest test= extentReports.createTest("Buy product Test");
        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        ProductPage westHamShirt = mainPage.goToShop().goToWestHamShirtPage();
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.selenium-shop.pl/produkt/koszulka-west-ham-united/");

        test.addScreenCaptureFromPath(takeScreenShot("West-ham shirt page"));
       test.log(Status.PASS,"Go to west-ham shirt done");
        Assert.assertEquals(westHamShirt.getNameOfProduct(),"KOSZULKA WEST HAM UNITED");
        Assert.assertTrue(westHamShirt.getPriceOfProduct().contains("90,00"));
        Assert.assertEquals(westHamShirt.getNumberOfProducts(),"1");
        westHamShirt.addToCart();
        SeleniumHelper seleniumHelper = new SeleniumHelper();
       // seleniumHelper.waitForElementToBeVisisble(westHamShirt.);
        System.out.println(westHamShirt.getAddToCartInfo());
        Assert.assertTrue(westHamShirt.getAddToCartInfo().contains("“Koszulka West Ham United” został dodany do koszyka."));
        CartPage cartPage = westHamShirt.goToCart();
        Assert.assertEquals(driver.getTitle(),"Koszyk – Selenium Shop Automatyzacja Testów");
        Assert.assertTrue(cartPage.getFreeShippingRadioButton().isSelected());
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        Assert.assertEquals(driver.getTitle(),"Zamówienie – Selenium Shop Automatyzacja Testów");
      //  System.out.println(checkoutPage.getProductsInCartNames().get(0));
        Assert.assertTrue(checkoutPage.getProductsInCartNames().contains("Koszulka West Ham United  × 1"));
      //  System.out.println(checkoutPage.getProductsInCartPrices().get(0));
        Assert.assertTrue(checkoutPage.getProductsInCartPrices().get(checkoutPage.getProductsInCartNames().indexOf("Koszulka West Ham United  × 1")).contains("90,00 zł"));
        Assert.assertTrue(checkoutPage.getFreeShippingRadioButton().isSelected());
        Assert.assertEquals(checkoutPage.getPriceAmount(),"90,00 zł");


    }
}
