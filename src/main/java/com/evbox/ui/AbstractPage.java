package com.evbox.ui;

import org.openqa.selenium.WebDriver;

import com.evbox.driver.DriverManager;
import com.evbox.logger.Logger;

public abstract class AbstractPage {

    private static final Logger LOGGER = new Logger(AbstractPage.class);

    protected WebDriver driver;

    public AbstractPage() {
        this.driver = DriverManager.getInstance().getDriver();
    }

    public abstract boolean isPageOpened();

    protected boolean isPageTitleCorrect(String expPageTitle) {
        String actPageTitle = driver.getTitle();
        LOGGER.info("Opened page title: " + actPageTitle);
        return actPageTitle.equals(expPageTitle);
    }
}
