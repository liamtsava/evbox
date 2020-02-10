package com.evbox.config;

import java.util.HashMap;
import java.util.Map;

import com.evbox.config.constant.CliArg;
import com.evbox.driver.constant.BrowserType;
import com.evbox.logger.Logger;

public class TestRunConfig {

    private static final Logger LOGGER = new Logger(TestRunConfig.class);

    private static volatile Map<String, String> runConfig;

    public static String getParam(CliArg param) {
        initRunConfig();
        return runConfig.get(param.getName());
    }

    public static BrowserType getBrowerType() {
        return BrowserType.getByName(getParam(CliArg.BROWSER_TYPE));
    }

    private static void initRunConfig() {
        if (runConfig == null) {
            synchronized (TestRunConfig.class) {
                if (runConfig == null) {
                    LOGGER.debug("Init run configs.");
                    runConfig = parseSystemPropertiesToMap();
                }
            }
        }
    }

    private static Map<String, String> parseSystemPropertiesToMap() {
        LOGGER.debug("Parse system properties to map.");
        Map<String, String> props = new HashMap<>();
        for (Map.Entry<Object, Object> x : System.getProperties().entrySet()) {
            props.put(x.getKey().toString(), x.getValue().toString());
        }
        return props;
    }
}
