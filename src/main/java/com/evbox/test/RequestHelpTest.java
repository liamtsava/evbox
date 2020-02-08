package com.evbox.test;

import org.testng.annotations.Test;

import com.evbox.driver.factory.ChromeDriverFactory;
import com.evbox.driver.factory.WebDriverFactory;
import com.evbox.logger.Logger;

import static com.evbox.constant.TestGroup.REGRESSION;
import static com.evbox.constant.TestGroup.SMOKE;

public class RequestHelpTest extends BaseTest {

    private static final Logger LOGGER = new Logger(BaseTest.class);

    @Test(description = "some test description for allure")
    public void test() {
        LOGGER.info("First step");

        driverManager.getDriver().get("https://evbox.com/");

    }
}
