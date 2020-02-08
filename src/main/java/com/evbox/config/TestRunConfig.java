package com.evbox.config;

import com.evbox.config.constant.CliArg;
import com.evbox.driver.constant.BrowserType;
import com.evbox.logger.Logger;

public class TestRunConfig {

    private static final Logger LOGGER = new Logger(TestRunConfig.class);


    //TODO get arg from map
    public static String getParam(CliArg param) {
        return System.getProperty(param.getName());
    }

    //TODO add parsin args into map

    public static BrowserType getBrowerType(){
        return BrowserType.getByName(getParam(CliArg.BROWSER_TYPE));
    }
}
