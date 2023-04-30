package itstep.task_12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.time.Duration;
// General tasks
//  Implement PageFactory for a few pages.
// Implement Wrapper for common WebElements (choose your wariant).
// Implement methods for your web element with console logging. Choose your wariant with specific methods

// 11. Iframes:
// switchToIframe - switches the driver context to an iframe
// switchToDefaultContent - switches the driver context back to the default content
// waitForIframeToBeVisible - waits for an iframe to be visible on the page

public class LapTopPage {
    private WebDriver driver;

    // driver.findElement(By.xpath("//a[text()='Laptops']")).click();
    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement aTextLaptops;
    // driver.findElement(By.xpath("//a[@href='prod.html?idp_=11']"));
    @FindBy(xpath = "//a[@href='prod.html?idp_=11']")
    private WebElement prodHtml11;

    // driver.findElement(By.xpath("//a[text()='Add to cart']"));
    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement ToCart;

    public LapTopPage(){
        PageFactory.initElements(driver, this);
    }
    public LapTopPage(WebDriver driver) {
        this.driver=driver;

    }

    public void openLaptops() {
        driver.get("https://www.demoblaze.com/");
        aTextLaptops.click();
    }

    public boolean isMacBookAirDisplayed() throws InterruptedException {
        //driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);
        WebElement element = prodHtml11;
        return element.isDisplayed();
    }

    public void clickMacBookAir() {
        WebElement element = prodHtml11;
        element.click();
    }

    public void addToCart() throws InterruptedException {
        //driver.get("https://www.demoblaze.com/cart.html");
        Thread.sleep(2000);
        WebElement addToCartButton = ToCart;
        addToCartButton.click();
    }

    public void checkMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage = alert.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Unexpected message");
        alert.accept();
    }
}
