package itstep_test.task_13;

import itstep.task11.HomePage;
import itstep.task11.LapTopPage;
import itstep.task13.SuiteListener;
//import itstep.task_12.HomePage;
//import itstep.task_12.WebDriverSupplier;
import itstep.task_12.WebDriverSupplier;
import itstep.task_12.WebElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

@Listeners({SuiteListener.class})
public class LapTopPageTest {
    private WebDriver driver;

    @BeforeTest
    void setup() {
        driver = WebDriverSupplier.setupDriver();
    }

    @Test
    void endToEndTest() throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        HomePage homePage = new HomePage(driver);
        LapTopPage lapTopPage = homePage.laptops();
        lapTopPage.openLaptops();
        Assert.assertTrue(lapTopPage.isMacBookAirDisplayed());
        lapTopPage.clickMacBookAir();
        lapTopPage.addToCart();
        lapTopPage.checkMessage("Product added");
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }
}
