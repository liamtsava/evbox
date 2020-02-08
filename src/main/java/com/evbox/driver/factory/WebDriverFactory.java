package com.evbox.driver.factory;

import org.openqa.selenium.WebDriver;

import com.evbox.driver.constant.DriverConstant;

public interface WebDriverFactory {

    WebDriver getDriver();

    default String getDriverPath(String driverExecName) {
        return DriverConstant.PATH_TO_DRIVERS + driverExecName;
    }
}