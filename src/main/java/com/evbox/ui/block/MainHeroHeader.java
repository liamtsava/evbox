package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.logger.Logger;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class MainHeroHeader extends HeroHeader {

    private static final Logger LOGGER = new Logger(MainHeroHeader.class);

    @Name("'Explore our products' button")
    @FindBy(xpath = ".//a[@href='products']")
    private Button primaryButton;

    public boolean isExloreOurProductsBtnDisplayed() {
        LOGGER.info("Verify is displayed: " + primaryButton.getName());
        return primaryButton.isDisplayed();
    }
}
