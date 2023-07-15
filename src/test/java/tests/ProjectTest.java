package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;
import pages.ShopPage;

public class ProjectTest extends BaseTest{
    @Test
    public void xx(){
        MainPage mainPage = new MainPage(driver);
        ProductPage westHamShirt = mainPage.goToShop().goToWestHamShirtPage();
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.selenium-shop.pl/produkt/koszulka-west-ham-united/");
        Assert.assertEquals(westHamShirt.getNameOfProduct(),"KOSZULKA WEST HAM UNITED");
        Assert.assertTrue(westHamShirt.getPriceOfProduct().contains("90,00"));
        Assert.assertEquals(westHamShirt.getNumberOfProducts(),"1");

    }
}
