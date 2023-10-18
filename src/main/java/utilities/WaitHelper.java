package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitHelper {

    private static final Logger oLog = LogManager.getLogger(WaitHelper.class);


    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        Duration timeout = Duration.ofSeconds(timeToWaitInSec);
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeToWaitInSec) {
        Duration timeout = Duration.ofSeconds(timeToWaitInSec);
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
