package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    @FindBy(xpath = "//h2[text()='Koszulka West Ham United']")
    private WebElement westHamShirt;

    private WebDriver driver;
    public ShopPage (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver =driver;
    }

    public ProductPage goToWestHamShirtPage(){
        westHamShirt.click();
        return new ProductPage(driver);
    }
}
