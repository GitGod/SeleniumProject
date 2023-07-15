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


    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
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
}
