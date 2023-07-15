package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//a[text()='Moje konto']")
    private WebElement myAccountButton;
    @FindBy(xpath = "//a[text()='Sklep']")
    private WebElement shopButton;

    private WebDriver driver;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public MyAccountPage goToMyAccount() {
        myAccountButton.click();
        return new MyAccountPage(driver);
    }
    public ShopPage goToShop() {
        shopButton.click();
        return new ShopPage(driver);
    }
}
