package com.evbox.driver.js;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollTo extends Command<Object> {

    public ScrollTo(WebDriver driver) {
        super(driver);
    }

    @Override
    public String build() {
        return JsCommand.SCROLL_TO_ELEMENT.getCommandString();
    }

}
