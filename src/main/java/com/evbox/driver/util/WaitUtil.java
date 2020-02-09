package com.evbox.driver.util;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import com.evbox.logger.Logger;

public final class WaitUtil {

    private static final Logger LOGGER = new Logger(WaitUtil.class);

    private WaitUtil() {
        // private constructor for util class
    }

    public static void waitFailSafeForNewPageLoad(WebDriver driver) {
        try {
            String currentUrl = driver.getCurrentUrl();
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2));
            wait.until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver driver) {
                    String newUrl = driver.getCurrentUrl();
                    LOGGER.debug("URL: " + currentUrl + " " + newUrl);
                    return !newUrl.equals(currentUrl);

                }
            });
        } catch (TimeoutException e) {
            LOGGER.info("New page wasn't opened.");
        }
    }
}
