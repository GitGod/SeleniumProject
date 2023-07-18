package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.InputStream;

public class ProductPage {
    @FindBy(className = "amount")
    private WebElement priceField;
    @FindBy(className = "product_title")
    private WebElement nameField;
    @FindBy(name = "quantity")
    private WebElement numberOfProducts;

    @FindBy(xpath = "//button[text()='Dodaj do koszyka']")
    private WebElement addToCartButton;
    @FindBy(className = "woocommerce-message")
    private WebElement addToCartInfo;
    @FindBy(xpath = "//a[text()='Zobacz koszyk']")
    private WebElement seeCartButton;

    private WebDriver driver;
    public ProductPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        this.driver=driver;

    }

    public String getPriceOfProduct(){
        return priceField.getText();
    }
    public String getNameOfProduct(){
        return nameField.getText();
    }
    public String getNumberOfProducts(){
        return numberOfProducts.getAttribute("value");
    }

    public ProductPage addToCart(){
        addToCartButton.click();
        return new ProductPage(driver);
    }

    public String getAddToCartInfo()
    {
        return addToCartInfo.getText();
    }

    public CartPage goToCart(){
        seeCartButton.click();
        return new CartPage(driver);
    }
}
