package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("'Products' menu in navigation")
@FindBy(xpath = ".//a[@href='products']")
public class ProductsMenu extends HtmlElement {

}
