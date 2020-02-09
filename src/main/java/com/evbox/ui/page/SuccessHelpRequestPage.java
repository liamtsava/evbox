package com.evbox.ui.page;

import org.openqa.selenium.support.PageFactory;

import com.evbox.ui.AbstractPage;
import com.evbox.ui.block.SuccessHelpRequestHeader;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SuccessHelpRequestPage extends AbstractPage {

    private static final String PAGE_TITLE = "Thank you for your request | EVBox";

    private SuccessHelpRequestHeader heroHeader;

    public SuccessHelpRequestPage() {
        super();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @Override
    public boolean isPageOpened() {
        if (isPageTitleCorrect(PAGE_TITLE)) {
            return heroHeader.isBrowseFaqBtnDisplayed();
        }
        return false;
    }

}
