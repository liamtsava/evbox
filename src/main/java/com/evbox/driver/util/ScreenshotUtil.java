package com.evbox.driver.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.evbox.logger.Logger;

import net.bytebuddy.utility.RandomString;

public final class ScreenshotUtil {

    private static final Logger LOGGER = new Logger(ScreenshotUtil.class);

    private ScreenshotUtil() {
        // final constructor for util class
    }

    public static File takeScreenshotFile(WebDriver driver, String screenshotDir) {
        LOGGER.debug("Taking screenshot");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = String.format("screenshot_%d_%s", System.currentTimeMillis(),
                RandomString.make(5) + ".png");
        String screenshotPath = screenshotDir + File.separator + screenshotName;

        File screenshotFile = new File(screenshotPath);
        try {
            FileUtils.copyFile(scrFile, screenshotFile);
        } catch (IOException e) {
            LOGGER.error("Failure during saving screenshot file.", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return screenshotFile;
    }

    public static byte[] takeScreenshot(WebDriver driver, String screenshotDir) {
        File screenshotFile = takeScreenshotFile(driver, screenshotDir);
        try {
            return Files.readAllBytes(Paths.get(screenshotFile.getAbsolutePath()));
        } catch (IOException e) {
            LOGGER.error("Failure during reading screenshot file.", e);
            return new byte[0];
        }
    }
}
