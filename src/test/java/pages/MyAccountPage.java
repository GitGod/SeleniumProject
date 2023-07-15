package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(id = "reg_email")
    private WebElement registerEmailInput;

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
