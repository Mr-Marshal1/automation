package itstep.task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;

    public static final String URL = "https://www.demoblaze.com/";

    public HomePage(WebDriver driver){
        this.driver=driver;
        if(!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
    }

    public LapTopPage laptops() {
        return new LapTopPage(driver);
    }
}
