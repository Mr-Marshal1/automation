package itstep_test.task_10;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import itstep.task2.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleWebDriverTest {
   private WebDriver driver;
    @BeforeTest
    void setup(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        // WebDriver driver = new ChromeDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //Setup ChromeDriver using DriverManager.
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }
    @Test
    void simpleWDTest(){

        //step 1
        driver.get("https://demoqa.com/radio-button");

        //step 2

        //1
        WebElement placehoderLink = driver.findElement(By.xpath("//label[@for='impressiveRadio']/preceding-sibling::input[@type='radio']"));
        Assert.assertTrue(!placehoderLink.isDisplayed());
        Assert.assertEquals(placehoderLink.getAttribute("name"), "like", "unexpected name");

        //2
        driver.get("https://demoqa.com/automation-practice-form/");
        WebElement label = driver.findElement(By.xpath("//input[@id='gender-radio-1']/following-sibling::label[@class='custom-control-label']"));
        Assert.assertTrue(label.isDisplayed());

        //3
        driver.get("https://demoqa.com/checkbox");
        WebElement homelabel = driver.findElement(By.xpath("//label[@for='tree-node-home']"));
        Assert.assertTrue(homelabel.isDisplayed());

        //4
        // driver.get("https://demoqa.com/checkbox");
        WebElement element = driver.findElement(By.className("rct-collapse"));
        element.click();
        WebElement input = driver.findElement(By.xpath("//label[@for='tree-node-downloads']//input[@id='tree-node-downloads']"));
        Assert.assertTrue(!input.isDisplayed());

        //5
        // WebElement element1 = driver.findElement(By.className("rct-collapse"));
        // element1.click();
        WebElement input1 = driver.findElement(By.xpath("//label[@for='tree-node-documents']//input[@id='tree-node-documents']"));
        Assert.assertTrue(!input1.isDisplayed());
    }
    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
