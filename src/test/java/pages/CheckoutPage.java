package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage {
    @FindBy (xpath = "//tr[@class='cart_item']//td[@class='product-name']")
    private List<WebElement> productsInCartNames;
    @FindBy (xpath = "//tr[@class='cart_item']//td[@class='product-total']//span")
    private List<WebElement> productsInCartPrices;
    @FindBy (id="shipping_method_0_free_shipping2")
    private WebElement freeShippingRadioButton;
    @FindBy (className = "woocommerce-Price-amount")
    private WebElement priceAmount;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public List<String> getProductsInCartNames(){
        return productsInCartNames.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
        //getAttribute("textContent")
    }
    public List<String> getProductsInCartPrices(){
        return productsInCartPrices.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
        //getAttribute("textContent")
    }
    public WebElement getFreeShippingRadioButton(){
        return freeShippingRadioButton;
    }

    public String getPriceAmount(){
        return priceAmount.getText();
    }
}
