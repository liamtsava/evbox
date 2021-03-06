package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.logger.Logger;
import com.evbox.ui.page.SupportPage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

@FindBy(xpath = "//header[contains(@class,'hero')]/div[contains(@id,'desktop')]")
public class ContactUsHeroHeader extends HeroHeader {

    private static final Logger LOGGER = new Logger(ContactUsHeroHeader.class);

    @Name("'Request help' button")
    @FindBy(xpath = ".//a[contains(@href,'learn/support')]")
    private Button primaryButton;

    public SupportPage clickRequestHelp() {
        LOGGER.info("Click button: " + primaryButton.getName());
        primaryButton.click();
        return new SupportPage();
    }

    public boolean isRequestBtnDisplayed() {
        LOGGER.info("Verify if displayed:" + primaryButton.getName());
        return primaryButton.isDisplayed();
    }
}
