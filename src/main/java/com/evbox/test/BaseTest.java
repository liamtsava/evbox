package com.evbox.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.evbox.config.TestRunConfig;
import com.evbox.config.constant.CliArg;
import com.evbox.driver.DriverManager;
import com.evbox.logger.Logger;

import static com.evbox.constant.TestGroup.REGRESSION;
import static com.evbox.constant.TestGroup.SMOKE;

public class BaseTest {

    //TODO multithreading

    private static final Logger LOGGER = new Logger(BaseTest.class);

    protected static DriverManager driverManager;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        driverManager = DriverManager.getInstance(TestRunConfig.getBrowerType());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        driverManager.quitAll();
   }

}



//TODO  README file
