package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.logger.Logger;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Header navigation block")
@FindBy(xpath = "//nav[contains(@class,'navigation')]")
public class Navigation extends HtmlElement {

    private static final Logger LOGGER = new Logger(Navigation.class);

    public ProductsMenu productsMenu;

    public AboutMenu aboutMenu;

}
