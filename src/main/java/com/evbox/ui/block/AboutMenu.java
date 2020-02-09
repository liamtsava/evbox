package com.evbox.ui.block;

import org.openqa.selenium.support.FindBy;

import com.evbox.logger.Logger;
import com.evbox.ui.page.ContactUsPage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("'About' menu in navigation")
@FindBy(xpath = ".//a[@href='about']")
public class AboutMenu extends HtmlElement {

    private static final Logger LOGGER = new Logger(AboutMenu.class);

    @Name("'Contact us' menu")
    @FindBy(xpath = "//a[@href='about/contact']")
    private Button contactUs;

    public ContactUsPage openContactUs() {
        LOGGER.info("Open menu: " + contactUs.getName());
        contactUs.click();
        return new ContactUsPage();
    }
}
