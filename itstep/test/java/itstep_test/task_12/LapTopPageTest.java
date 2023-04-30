package itstep_test.task_12;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import itstep.task11.LapTopPage;
import itstep.task_12.HomePage;
import itstep.task_12.IFrameWrapper;
import itstep.task_12.WebDriverSupplier;
import itstep.task_12.WebElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

import static itstep.task_12.WebDriverSupplier.driver;

public class LapTopPageTest {

    // General tasks
    //  Implement PageFactory for a few pages.
    // Implement Wrapper for common WebElements (choose your wariant).
    // Implement methods for your web element with console logging. Choose your wariant with specific methods

   // 11. Iframes:
   // switchToIframe - switches the driver context to an iframe
   // switchToDefaultContent - switches the driver context back to the default content
   // waitForIframeToBeVisible - waits for an iframe to be visible on the page

    @BeforeTest
    void setup(){
        WebDriverSupplier.setupDriver();
    }


    @Test
    void endToEndTest() throws InterruptedException {
        // target https://www.demoblaze.com/
        //1. Navigate to the Laptops Category
        //2. Check whether MacBook air present or not
        //3. Click on it
        //4. Add to cart
        //5. Check message

        // Implement Wrapper for common WebElements (choose your wariant).

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");

        WebElement iFrameElement = driver.findElement(By.cssSelector("iframe[name='__tcfapiLocator']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameElement));


        driver.switchTo().defaultContent();


        driver.quit();

        // Implement methods for your web element with console logging. Choose your wariant with specific methods

        driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");

        WebElementWrapper webElementWrapper = new WebElementWrapper(driver);

        iFrameElement = webElementWrapper.findElement(By.cssSelector("iframe[name='__tcfapiLocator']"));

        webElementWrapper.switchToIframe(iFrameElement);

        webElementWrapper.switchToDefaultContent();


        driver.quit();
        // -------------------------------
        //1. Navigate to the Laptops Category
        WebDriver newDriver = new ChromeDriver();
        newDriver.get("https://www.demoblaze.com/");
        HomePage homePage = new HomePage(newDriver);
        LapTopPage lapTopPage = homePage.laptops();
        lapTopPage.openLaptops();

        //1.1 Check whether MacBook air present or not
        Assert.assertTrue(lapTopPage.isMacBookAirDisplayed());

        //1.2 Click if element is present
        lapTopPage.clickMacBookAir();

        //1.3 Click on it
        lapTopPage.addToCart();

        //1.4 check message
        lapTopPage.checkMessage("Product added");

        // --------------------------------

      //  driver.get("https://www.demoblaze.com/cart.html");

     //   WebElement iFrameElement = driver.findElement(By.tagName("iframe"));
     //   driver.switchTo().frame(iFrameElement);
    //    IFrameWrapper iFrameWrapper = new IFrameWrapper(driver, iFrameElement);


      //  iFrameWrapper.switchToFrame();

     //   iFrameWrapper.switchToDefaultContent();

      //  iFrameWrapper.waitForIframeToBeVisible(10);
    }

    private String random(){
        return UUID.randomUUID().toString().substring(0,8).replace("-", "");
    }

    @AfterTest
    void closeBrowser(){
        WebDriverSupplier.closeDriver();
    }
}
