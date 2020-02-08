package com.evbox.driver.factory;

import org.openqa.selenium.chrome.ChromeDriver;

import com.evbox.driver.constant.DriverConstant.DriverConfig;

public class ChromeDriverFactory implements WebDriverFactory {

    private static final String DRIVER_EXECUTABLE_NAME = "chromedriver";

    @Override
    public ChromeDriver getDriver() {
        System.setProperty(DriverConfig.CHROME_SYS_PROP_NAME, getDriverPath(DRIVER_EXECUTABLE_NAME));
        return new ChromeDriver();
    }
}