package com.evbox.driver.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class Command<T> {

    protected JavascriptExecutor jse;

    protected Command(WebDriver driver) {
        jse = (JavascriptExecutor) driver;

    }

    public T execute(Object... args) {
        String command = build();
        jse.executeScript(command, args);
       //TODO log
        return (T) jse.executeScript(command, args);
    }

    public abstract String build();
}
