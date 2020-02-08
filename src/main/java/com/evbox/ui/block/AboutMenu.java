package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.ui.page.ContactUsPage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("'About' menu in navigation")
@FindBy(xpath = ".//a[@href='about']")
public class AboutMenu extends HtmlElement {

    @FindBy(xpath = "//a[@href='about/contact']")
    public Button contactUs;

    public ContactUsPage openContactUs(){
        //TODO logger
        contactUs.click();
        return new ContactUsPage();
    }
}
