package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverFactory {
    public static WebDriver getDriver() throws IOException {
        String name = PropertiesLoader.loadProperty("browser.name");
        if(name.equals("firefox")){
            String path = "C:\\Users\\Yuumi\\Downloads\\Nowy folder\\geckodriver.exe";
            System.setProperty("webdriver.firefox.driver", path);
            return new FirefoxDriver();
        } else {
            String path = "C:\\Users\\Yuumi\\Downloads\\Nowy folder\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", path);
            return  new ChromeDriver();
        }
    }
}
