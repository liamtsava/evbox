package com.evbox.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.evbox.config.TestRunConfig;
import com.evbox.constant.FrameworkConstant;
import com.evbox.driver.DriverManager;
import com.evbox.logger.Logger;
import com.evbox.util.FileUtil;

public class SuiteListener implements ISuiteListener {

    private static final Logger LOGGER = new Logger(SuiteListener.class);

    public void onStart(ISuite suite) {
        LOGGER.debug("Start the suite.");
        FileUtil.deleteFolder(FrameworkConstant.SCREENSHOTS_FOLDER);
        FileUtil.deleteFolder(FrameworkConstant.ALLURE_RESULTS_FOLDER);
    }

    public void onFinish(ISuite suite) {
        LOGGER.debug("Finish the suite.");
        DriverManager.quitAll();
    }

}
