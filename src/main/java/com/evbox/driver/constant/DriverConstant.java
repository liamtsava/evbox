package com.evbox.driver.constant;

public final class DriverConstant {

    private DriverConstant() {
        // private constructor for constants class
    }

    public final class DriverConfig {

        private DriverConfig() {
            // private constructor for constants class
        }

        public static final String CHROME_SYS_PROP_NAME = "webdriver.chrome.driver";

        public static final String FIREFOX_SYS_PROP_NAME = "webdriver.gecko.driver";
    }

    public static final String PATH_TO_DRIVERS = "src/main/resources/driver/";
}
