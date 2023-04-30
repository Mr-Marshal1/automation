package itstep.task_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
// Implement methods for your web element with console logging. Choose your wariant with specific methods

public class WebElementWrapper {
    private WebDriver driver;

    public WebElementWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By by) {
        System.out.println("Found element: " + by.toString());
        return driver.findElement(by);
    }

    public void switchToIframe(WebElement iFrameElement) {
        System.out.println("iframe connect: " + iFrameElement.getAttribute("name"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameElement));
    }

    public void switchToDefaultContent() {
        System.out.println("Default");
        driver.switchTo().defaultContent();
    }

    public void waitForIframeToBeVisible(WebElement iFrameElement) {
        System.out.println("Wait until it's visible: " + iFrameElement.getAttribute("name"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(iFrameElement));
    }
}