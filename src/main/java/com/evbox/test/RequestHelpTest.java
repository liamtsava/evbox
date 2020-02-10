package com.evbox.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.evbox.constant.TestGroup;
import com.evbox.logger.Logger;
import com.evbox.ui.page.ContactUsPage;
import com.evbox.ui.page.MainPage;
import com.evbox.ui.page.SuccessHelpRequestPage;
import com.evbox.ui.page.SupportPage;

public class RequestHelpTest extends BaseTest {

    private static final Logger LOGGER = new Logger(BaseTest.class);

    private String email = "alena_liamtsava.5xqxzeas@mailosaur.io";
    private String message = "This is a test message generated by automated script.";

    @Test(groups = {TestGroup.SMOKE}, description = "some test description for allure")
    public void requestHelpTest() {
        LOGGER.info("Open main page");
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driverManager);
        Assert.assertFalse(mainPage.isPageOpened(), "Main page wasn't opened.");
        mainPage.cookiesConfirmation.clickAcceptBtn();
        ContactUsPage contactUsPage = mainPage.navigateToAboutMenu().openContactUs();
        Assert.assertTrue(contactUsPage.isPageOpened(), "Contact us page wasn't opened.");
        SupportPage supportPage = contactUsPage.heroHeader.clickRequestHelp();
        Assert.assertTrue(supportPage.isPageOpened(), "Support page wasn't opened.");

        LOGGER.info("Fill form with valid data.");
        supportPage.scrollToRequestForm();
        supportPage.requestHelpForm.fillFirstName("Alena");
        supportPage.requestHelpForm.fillLastName("Liamtsava");
        supportPage.requestHelpForm.fillEmail(email);
        supportPage.requestHelpForm.fillPostalCode("220110");
        supportPage.requestHelpForm.fillCity("Minsk");
        supportPage.requestHelpForm.selectCountry("Belarus");
        supportPage.requestHelpForm.fillMessage(message);
        SuccessHelpRequestPage successHelpRequestPage = supportPage.requestHelpForm.sendFormWithAutoCaptchaHandling();
        Assert.assertTrue(successHelpRequestPage.isPageOpened(), "Success help request page wasn't opened");
    }

}
