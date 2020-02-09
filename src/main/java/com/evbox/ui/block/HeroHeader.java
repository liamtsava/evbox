package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.logger.Logger;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@Name("Header block of the page")
@FindBy(xpath = "//header[contains(@class,'hero') and contains(@class,'desktop')]")
public class HeroHeader extends HtmlElement {

    private static final Logger LOGGER = new Logger(HeroHeader.class);

    @Name("Title")
    @FindBy(xpath = ".//h1[contains(@class,'title')]")
    protected TextBlock title;


}
