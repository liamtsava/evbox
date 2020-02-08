package com.evbox.driver.factory;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.evbox.driver.constant.DriverConstant.DriverConfig;

public class FirefoxDriverFactory implements WebDriverFactory {

    private static final String DRIVER_EXECUTABLE_NAME = "geckodriver";

    @Override
    public FirefoxDriver getDriver() {
        System.setProperty(DriverConfig.FIREFOX_SYS_PROP_NAME, getDriverPath(DRIVER_EXECUTABLE_NAME));
        return new FirefoxDriver();
    }
}
