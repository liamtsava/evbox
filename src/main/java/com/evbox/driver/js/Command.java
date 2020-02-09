package com.evbox.driver.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.evbox.logger.Logger;

public abstract class Command<T> {

    private static final Logger LOGGER = new Logger(Command.class);

    protected JavascriptExecutor jse;

    protected Command(WebDriver driver) {
        jse = (JavascriptExecutor) driver;

    }

    public T execute(Object... args) {
        String command = build();
        jse.executeScript(command, args);
        LOGGER.debug("Execute js command:" + command);
        return (T) jse.executeScript(command, args);
    }

    public abstract String build();

}
