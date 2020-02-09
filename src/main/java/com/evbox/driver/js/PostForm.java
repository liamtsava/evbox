package com.evbox.driver.js;

import org.openqa.selenium.WebDriver;

public class PostForm extends Command<Object> {

    public PostForm(WebDriver driver) {
        super(driver);
    }

    @Override
    public String build() {
        return JsCommand.POST_FORM.getCommandString();
    }

}
