package com.evbox.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evbox.constant.TestGroup;
import com.evbox.logger.Logger;
import com.evbox.ui.page.ContactUsPage;
import com.evbox.ui.page.MainPage;
import com.evbox.ui.page.SupportPage;

public class RequestHelpTest extends BaseTest {

    private static final Logger LOGGER = new Logger(BaseTest.class);

    private SupportPage supportPage;

    @BeforeMethod(groups = {TestGroup.SMOKE})
    public void precondition() {
        LOGGER.info("Open main page");
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driverManager);
        Assert.assertTrue(mainPage.isPageOpened(), "Main page wasn't opened.");

        ContactUsPage contactUsPage = mainPage.navigateToAboutMenu().openContactUs();
        supportPage = contactUsPage.heroHeader.clickRequestHelp();
    }

    @Test(groups = {TestGroup.SMOKE}, description = "some test description for allure")
    public void test() {
        LOGGER.info("First step");

    }
}
