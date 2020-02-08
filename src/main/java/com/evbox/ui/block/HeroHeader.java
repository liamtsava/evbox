package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@Name("Header block of the page")
@FindBy(xpath = "//header[contains(@class,'hero')]")
public class HeroHeader extends HtmlElement {


//    @FindBy(xpath = "//h1[contains(@class,'title')]")
//    public TextBlock title;

    @FindBy(xpath = "//a[contains(@class,'primary')]")
    public Button primaryButton;
//
//    public String getPrimaryButtonText(){
//        return primaryButton.getText();
//    }


}
