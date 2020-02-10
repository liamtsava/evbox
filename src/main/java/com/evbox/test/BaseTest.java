package com.evbox.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.evbox.config.TestRunConfig;
import com.evbox.driver.DriverManager;
import com.evbox.logger.Logger;

public class BaseTest {

    //TODO multithreading

    private static final Logger LOGGER = new Logger(BaseTest.class);

    protected static DriverManager driverManager;
    protected WebDriver driver;

    //TODO move to other place
    protected final String baseUrl = "https://evbox.com/";

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        driverManager = DriverManager.getInstance(TestRunConfig.getBrowerType());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

}

//TODO  README file
