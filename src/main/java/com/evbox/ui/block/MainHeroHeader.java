package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class MainHeroHeader extends HeroHeader {

    @FindBy(xpath = ".//a[@href='products']")
    public Button primaryButton;

}
