package com.evbox.driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.evbox.driver.constant.BrowserType;
import com.evbox.driver.factory.DriverFactory;
import com.evbox.logger.Logger;

public class DriverManager {

    private static final Logger LOGGER = new Logger(DriverManager.class);

    private static volatile DriverManager instance;

    private final BrowserType browserType;

    //TODO maybe get from threadlocal?
    private static List<WebDriver> createdDrivers = new ArrayList<>();

    private ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static DriverManager getInstance(BrowserType browserType) {
        DriverManager localInstance = instance;
        if (localInstance == null) {
            synchronized (DriverManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    LOGGER.debug("Create driver manager instance.");
                    instance = localInstance = new DriverManager(browserType);
                }
            }
        }
        return localInstance;
    }

    private DriverManager(BrowserType browserType) {
        this.browserType = browserType;
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            synchronized (DriverManager.class) {
                WebDriver driver = DriverFactory.getDriverFactory(browserType).getDriver();
                drivers.set(driver);
                createdDrivers.add(driver);
            }
        }
        return drivers.get();
    }

    public static void quitAll() {
        LOGGER.debug("Quit all created drivers.");
        for (WebDriver driver : createdDrivers) {
            driver.quit();
        }
    }

}
