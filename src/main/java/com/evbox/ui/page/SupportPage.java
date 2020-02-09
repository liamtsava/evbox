package com.evbox.ui.page;

import org.openqa.selenium.support.PageFactory;

import com.evbox.driver.js.ScrollTo;
import com.evbox.ui.AbstractPage;
import com.evbox.ui.block.Navigation;
import com.evbox.ui.block.SupportHeroHeader;
import com.evbox.ui.element.RequestHelpForm;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SupportPage extends AbstractPage {

    private static final String PAGE_TITLE = "Support | EVBox";

    public Navigation navigation;

    public SupportHeroHeader supportHeroHeader;

    public RequestHelpForm requestHelpForm;

    public SupportPage() {
        super();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @Override
    public boolean isPageOpened() {
        if (isPageTitleCorrect(PAGE_TITLE)) {
            return supportHeroHeader.isBrowseFaqsBtnDisplayed();
        }
        return false;
    }

    public void scrollToRequestForm() {
        new ScrollTo(driver).execute(requestHelpForm.getWrappedElement());
    }

}
