package itstep_test.task_11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import itstep.task11.HomePage;
import itstep.task11.LapTopPage;
import itstep.task_12.WebDriverSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.AssertJUnit.assertEquals;

public class EndToEndTest {

    private WebDriver driver;
    private HomePage homePage;
    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

  //  Make up one simple UI end-to-end test case for your test page from Task_10.
  //  Automate that scenario using WebDriver
  //  Create PageObject (use Busines object if need)for all pages used in scenario


    @Test
    void endToEndTest() throws InterruptedException {
        // target https://www.demoblaze.com/
        //1. Navigate to the Laptops Category
        //2. Check whether MacBook air present or not
        //3. Click on it
        //4. Add to cart
        //5. Check message
       // LapTopPage lapTopPage = homePage.laptops();
       // lapTopPage.openLaptops();
        //Assert.assertTrue(lapTopPage.isMacBookAirDisplayed());
        //lapTopPage.clickMacBookAir();
        //lapTopPage.addToCart();
       // lapTopPage.checkMessage("Product added");

        //1. Navigate to the Laptops Category
        // HomePage homePage = new HomePage(driver);
        //LapTopPage LapTopPage=homePage.laptops();
        HomePage homePage = new HomePage(driver);
        LapTopPage lapTopPage = homePage.laptops();
        lapTopPage.openLaptops();

        //LapTopPage.Open();
        //1.1 Check whether MacBook air present or not
       // Thread.sleep(2000);
       // WebElement element = driver.findElement(By.xpath("//a[@href='prod.html?idp_=11']"));
        //Assert.assertTrue(element.isDisplayed());
        Assert.assertTrue(lapTopPage.isMacBookAirDisplayed());

        //1.2 Click if element is present
        //if (element.isDisplayed()) {
       //     element.click();
       // }
        lapTopPage.clickMacBookAir();

        //1.3 Click on it
        //Thread.sleep(1500);
       // driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
        lapTopPage.addToCart();

        //1.4 check message
        //Thread.sleep(1000);
       // Assert.assertEquals(driver.switchTo().alert().getText(), "Product added", "unexpected message");
        //driver.switchTo().alert().accept();
        lapTopPage.checkMessage("Product added");
    }

    private String random(){
        return UUID.randomUUID().toString().substring(0,8).replace("-", "");
    }

    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
