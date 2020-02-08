package com.evbox.driver.constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum BrowserType {

    FIREFOX("firefox"), CHROME("chrome");

    private String browserName;

    BrowserType(String browserName) {
        this.browserName = browserName;
    }

    public String getName() {
        return browserName;
    }

    public static BrowserType getByName(String browserName) {
        for (BrowserType browserType : values()) {
            if (browserType.getName().equals(browserName.toLowerCase())) {
                return browserType;
            }
        }
        throw new RuntimeException(String.format("No support for browser '%s'. Please use one of the supported browsers: %s", browserName, getBrowserNamesAsString()));
    }

    private static String getBrowserNamesAsString() {
        return Arrays.stream(values()).map(browserType -> browserType.getName()).collect(Collectors.joining(","));
    }
}

