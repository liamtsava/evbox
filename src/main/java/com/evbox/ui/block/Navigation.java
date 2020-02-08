package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Header navigation block")
@FindBy(xpath = "//nav[contains(@class,'navigation')]")
public class Navigation  extends HtmlElement {

    public ProductsMenu productsMenu;

    public AboutMenu aboutMenu;

}
