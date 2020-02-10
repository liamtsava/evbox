package com.evbox.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.evbox.config.TestRunConfig;
import com.evbox.driver.DriverManager;
import com.evbox.logger.Logger;

public class BaseTest {

    private static final Logger LOGGER = new Logger(BaseTest.class);

    protected static final String baseUrl = "https://evbox.com/";

    protected static DriverManager driverManager;
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        driverManager = DriverManager.getInstance(TestRunConfig.getBrowerType());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

}