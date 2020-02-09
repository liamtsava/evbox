package com.evbox.ui.element;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.evbox.driver.DriverManager;
import com.evbox.driver.js.ScrollTo;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

@Name("Form for requesting help on support page")
@FindBy(xpath = "//form")
public class RequestHelpForm extends HtmlElement {

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
        scrollIfNeedAndApply(firstName);
        //        firstName.sendKeys(text);
        sendText(firstName, text);
    }

    public void fillLastName(String text) {
        scrollIfNeedAndApply(lastName);
        //        lastName.sendKeys(text);
        sendText(lastName, text);
    }

    public void fillEmail(String text) {
        scrollIfNeedAndApply(email);
        //        email.sendKeys(text);
        sendText(email, text);
    }

    public void fillPostalCode(String text) {
        scrollIfNeedAndApply(postalCode);
        //        postalCode.sendKeys(text);
        sendText(postalCode, text);
    }

    public void fillCity(String text) {
        scrollIfNeedAndApply(city);
        //        city.sendKeys(text);
        sendText(city, text);
    }

    public void selectCountry(String text) {
        scrollIfNeedAndApply(country);
        country.selectByValue(text);
    }

    public void fillMessage(String text) {
        scrollIfNeedAndApply(message);
        sendText(message, text);

    }

    private void sendText(TypifiedElement element, String text) {
        for (char symbol : text.toCharArray()) {
            element.sendKeys(String.valueOf(symbol));
            try {
                Thread.sleep(200);
            } catch (Exception e) {

            }

        }
    }

    public void clickSend() {
        //        scrollIfNeedAndApply(firstName);
        //        send.click();
        new Actions(DriverManager.getInstance().getDriver()).moveToElement(send.getWrappedElement()).click().perform();
    }

    private void scrollIfNeedAndApply(TypifiedElement element) {
        //TODO change to passing method
        new ScrollTo(DriverManager.getInstance().getDriver()).execute(element.getWrappedElement());
    }
}
