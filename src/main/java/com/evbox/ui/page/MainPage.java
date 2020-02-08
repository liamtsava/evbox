package com.evbox.ui.page;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.evbox.driver.DriverManager;
import com.evbox.ui.AbstractPage;
import com.evbox.ui.block.AboutMenu;
import com.evbox.ui.block.MainHeroHeader;
import com.evbox.ui.block.Navigation;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class MainPage extends AbstractPage {

    private static final String PAGE_TITLE = "Electric vehicle charging solutions | EVBox";

    public MainHeroHeader heroHeader;

    public Navigation navigation;

    public MainPage(DriverManager driverManager) {
        super();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @Override
    public boolean isPageOpened() {
        if (isPageTitleCorrect(PAGE_TITLE)) {
            return heroHeader.primaryButton.exists();
        }
        return false;
    }

    public AboutMenu navigateToAboutMenu(){
        new Actions(driver).moveToElement(navigation.aboutMenu.getWrappedElement()).perform();
        return navigation.aboutMenu;
    }


}
