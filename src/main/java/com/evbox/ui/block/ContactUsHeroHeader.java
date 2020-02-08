package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.ui.page.SupportPage;

import ru.yandex.qatools.htmlelements.element.Button;

public class ContactUsHeroHeader extends HeroHeader {

    @FindBy(xpath = "//a[contains(@href,'learn/support')]")
    public Button primaryButton;

    public SupportPage clickRequestHelp(){
        primaryButton.click();
        //TODO logs
        return new SupportPage();
    }
}
