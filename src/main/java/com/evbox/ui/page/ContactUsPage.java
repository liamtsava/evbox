package com.evbox.ui.page;

import org.openqa.selenium.support.PageFactory;

import com.evbox.driver.DriverManager;
import com.evbox.ui.AbstractPage;
import com.evbox.ui.block.ContactUsHeroHeader;
import com.evbox.ui.block.MainHeroHeader;
import com.evbox.ui.block.Navigation;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ContactUsPage extends AbstractPage {

    private static final String PAGE_TITLE = "Contact us | EVBox";

    public ContactUsHeroHeader heroHeader;

    public Navigation navigation;

    public ContactUsPage() {
        super();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @Override
    public boolean isPageOpened() {
        if (isPageTitleCorrect(PAGE_TITLE)) {
//            return heroHeader.primaryButton.exists();
        }
        return false;
    }

}
