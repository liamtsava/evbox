package com.evbox.driver.js;

public enum JsCommand {

    POST_FORM("$(\"form\")[0].submit();"),
    SEND_CAPTCHA_TOKEN("$(\"#g-recaptcha-response\").val(\"%s\");"),
    SCROLL_TO_ELEMENT("arguments[0].scrollIntoView(true);");

    private String commandString;

    JsCommand(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }
}

