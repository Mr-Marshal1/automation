package itstep.task_12;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrameWrapper {private final WebDriver driver;
    private final WebElement iFrameElement;

    public IFrameWrapper(WebDriver driver, WebElement iFrameElement) {
        this.driver = driver;
        this.iFrameElement = iFrameElement;
    }

    public void switchToFrame() {
        driver.switchTo().frame(iFrameElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void waitForIframeToBeVisible(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[name='__tcfapiLocator']")));
    }

}
