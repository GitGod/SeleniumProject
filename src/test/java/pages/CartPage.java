package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
@FindBy(id = "shipping_method_0_free_shipping2")
   private WebElement freeShippingRadioButton;
@FindBy(className = "checkout-button")
private WebElement goToCheckoutButton;

private WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver= driver;
    }

    public WebElement getFreeShippingRadioButton(){
        return freeShippingRadioButton;
    }
    public CheckoutPage goToCheckout(){
        goToCheckoutButton.click();
        return new CheckoutPage(driver);
    }
}
