package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.logger.Logger;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("'Cookies' confirmation")
@FindBy(xpath = "//div[contains(@id,'cookie')]")
public class CookiesConfirmation extends HtmlElement {

    private static final Logger LOGGER = new Logger(CookiesConfirmation.class);

    @Name("'Accept' button")
    @FindBy(xpath = "//a[contains(@id,'confirmation')]")
    private Button accept;

    public void clickAcceptBtn() {
        LOGGER.info("Click button:" + accept.getName());
        accept.click();
    }
}
