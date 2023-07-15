package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//a[text()='Moje konto']")
    private WebElement myAccountButton;

    private WebDriver driver;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public MyAccountPage goToMyAccount() {
        myAccountButton.click();
        return new MyAccountPage(driver);
    }
}
