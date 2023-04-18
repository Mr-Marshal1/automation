package itstep.task10;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumStart {
    //General
    //Setup ChromeDriver using driver file and properties.
    //Setup ChromeDriver using DriverManager.
    //My first UI test:
    //go to the page from your variant
    //choose any 5 different elements;
    //Use different WebElement methods to communicate with those elements. (one element - at least one interaction)
    //Make a testNG test case to check visibility of your elements.
    // V11. https://demoqa.com (radio-button)
    public static void main(String[] args) {

        //Setup ChromeDriver using driver file and properties.
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
       // WebDriver driver = new ChromeDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //Setup ChromeDriver using DriverManager.
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/radio-button");

        //1
        WebElement placehoderLink = driver.findElement(By.xpath("//input[@id='impressiveRadio']/following-sibling::label[@class='custom-control-label']"));
        System.out.println(placehoderLink.getAttribute("custom-control-label"));
        placehoderLink.click();
        System.out.println("click " + placehoderLink);

        //2
        driver.get("https://demoqa.com/automation-practice-form/");
        WebElement label = driver.findElement(By.xpath("//input[@id='gender-radio-1']/following-sibling::label[@class='custom-control-label']"));
        System.out.println("label rect " + label.getRect().x + " " + label.getRect().y);

        //3
        driver.get("https://demoqa.com/checkbox");
        WebElement homelabel = driver.findElement(By.xpath("//label[@for='tree-node-home']"));
        System.out.println(homelabel.getText());

        //4
       // driver.get("https://demoqa.com/checkbox");
        WebElement element = driver.findElement(By.className("rct-collapse"));
        element.click();
        WebElement input = driver.findElement(By.xpath("//label[@for='tree-node-downloads']//input[@id='tree-node-downloads']"));
        System.out.println(input.isEnabled());

        //5
       // WebElement element1 = driver.findElement(By.className("rct-collapse"));
       // element1.click();
        WebElement input1 = driver.findElement(By.xpath("//label[@for='tree-node-documents']//input[@id='tree-node-documents']"));
        System.out.println(input1.isDisplayed());
        driver.close();
        driver.quit();
    }
}
