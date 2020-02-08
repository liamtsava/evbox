package com.evbox.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.evbox.logger.Logger;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = new Logger(TestListener.class);

    public void onTestStart(ITestResult result) {
        LOGGER.debug("Starting test: " + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.debug("SUCCESS: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        LOGGER.debug("FAILURE: " + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.debug("SKIPPED: " + result.getMethod().getMethodName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }

}
