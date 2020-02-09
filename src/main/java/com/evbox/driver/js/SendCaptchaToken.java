package com.evbox.driver.js;

import org.openqa.selenium.WebDriver;

public class SendCaptchaToken extends Command<Object> {

    private final String token;

    public SendCaptchaToken(WebDriver driver, String token) {
        super(driver);
        this.token = token;
    }

    @Override
    public String build() {
        return String.format(JsCommand.SEND_CAPTCHA_TOKEN.getCommandString(), token);
    }

}
