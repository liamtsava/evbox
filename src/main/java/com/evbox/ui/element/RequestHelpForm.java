package com.evbox.ui.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.evbox.driver.DriverManager;
import com.evbox.driver.js.PostForm;
import com.evbox.driver.js.SendCaptchaToken;
import com.evbox.driver.util.WaitUtil;
import com.evbox.logger.Logger;
import com.evbox.service.RucaptchaService;
import com.evbox.ui.page.SuccessHelpRequestPage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Form for requesting help on support page")
@FindBy(xpath = "//form")
public class RequestHelpForm extends HtmlElement {

    private static final Logger LOGGER = new Logger(RequestHelpForm.class);

    @Name("'First name' input field")
    @FindBy(xpath = "//input[contains(@id,'firstname')]")
    private TextInput firstName;

    @Name("'Last name' input field")
    @FindBy(xpath = "//input[contains(@id,'lastname')]")
    private TextInput lastName;

    @Name("'Email' input field")
    @FindBy(xpath = "//input[contains(@id,'email')]")
    private TextInput email;

    @Name("'Postal code' input field")
    @FindBy(xpath = "//input[contains(@id,'zip')]")
    private TextInput postalCode;

    @Name("'City' input field")
    @FindBy(xpath = "//input[contains(@id,'city')]")
    private TextInput city;

    @Name("'Country' select")
    @FindBy(xpath = "//select[contains(@id,'country')]")
    private Select country;

    @Name("'Message' input field")
    @FindBy(xpath = "//textarea[contains(@id,'message')]")
    private Select message;

    @Name("'Send' button")
    @FindBy(xpath = "//input[@type='submit']")
    private Button send;

    public void fillFirstName(String text) {
        LOGGER.info("Fill first name:" + text);
        firstName.sendKeys(text);
    }

    public void fillLastName(String text) {
        LOGGER.info("Fill last name:" + text);
        lastName.sendKeys(text);
    }

    public void fillEmail(String text) {
        LOGGER.info("Fill email:" + text);
        email.sendKeys(text);
    }

    public void fillPostalCode(String text) {
        LOGGER.info("Fill postal code:" + text);
        postalCode.sendKeys(text);
    }

    public void fillCity(String text) {
        LOGGER.info("Fill city:" + text);
        city.sendKeys(text);
    }

    public void selectCountry(String text) {
        LOGGER.info("Select country:" + text);
        country.selectByValue(text);
    }

    public void fillMessage(String text) {
        LOGGER.info("Fill message:" + text);
        message.sendKeys(text);
    }

    //clicking on 'Send' button will cause captcha
    public SuccessHelpRequestPage clickSend() {
        send.click();
        return new SuccessHelpRequestPage();
    }

    public SuccessHelpRequestPage sendFormWithAutoCaptchaHandling() {
        LOGGER.info("Send request form with js and posted captcha token.");
        WebDriver driver = DriverManager.getInstance().getDriver();
        //get captcha token
        String token = new RucaptchaService("<user key>").generateToken(driver.getCurrentUrl());
        // send captcha token
        new SendCaptchaToken(driver, token).execute();
        // post form with js as click with driver invokes captcha
        new PostForm(driver).execute();
        // wait for form submit
        WaitUtil.waitFailSafeForNewPageLoad(driver);
        return new SuccessHelpRequestPage();
    }
}
