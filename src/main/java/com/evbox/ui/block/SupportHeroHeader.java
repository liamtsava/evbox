package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.logger.Logger;
import com.evbox.ui.page.SupportPage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

@FindBy(xpath = "//header[contains(@class,'hero')]/div[contains(@id,'desktop')]")
public class SupportHeroHeader extends HeroHeader {

    private static final Logger LOGGER = new Logger(SupportHeroHeader.class);

    @Name("'Browse FAQs' button")
    @FindBy(xpath = ".//a[contains(@href,'learn') and contains(@class,'primary')]")
    private Button primaryButton;

    public boolean isBrowseFaqsBtnDisplayed() {
        LOGGER.info("Verify if displayed:" + primaryButton.getName());
        return primaryButton.isDisplayed();
    }
}
