package com.evbox.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.evbox.logger.Logger;

public class SuiteListener implements ISuiteListener {

    private static final Logger LOGGER = new Logger(SuiteListener.class);

    public void onStart(ISuite suite) {
        LOGGER.debug("Start the suite.");
        //TODO clean report folder

    }

    public void onFinish(ISuite suite) {
        //TODO report

        LOGGER.debug("Finish the suite.");
    }

}
