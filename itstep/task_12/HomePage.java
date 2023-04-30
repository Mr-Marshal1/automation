package itstep.task_12;

import itstep.task11.LapTopPage;
import org.openqa.selenium.WebDriver;

// General tasks
//  Implement PageFactory for a few pages.
// Implement Wrapper for common WebElements (choose your wariant).
// Implement methods for your web element with console logging. Choose your wariant with specific methods

// 11. Iframes:
// switchToIframe - switches the driver context to an iframe
// switchToDefaultContent - switches the driver context back to the default content
// waitForIframeToBeVisible - waits for an iframe to be visible on the page

public class HomePage {
    private WebDriver driver;

    public static final String URL = "https://www.demoblaze.com/";

    public HomePage(WebDriver driver){
        this.driver=driver;
        if(!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
    }

    public itstep.task11.LapTopPage laptops() {
        return new LapTopPage(driver);
    }
}
