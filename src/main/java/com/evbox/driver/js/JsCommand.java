package com.evbox.driver.js;

public enum JsCommand {

    SCROLL_TO_ELEMENT("arguments[0].scrollIntoView(true);");

    private String commandString;

    JsCommand(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }
}

