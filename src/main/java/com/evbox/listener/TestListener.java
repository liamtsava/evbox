package com.evbox.listener;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.evbox.constant.FrameworkConstant;
import com.evbox.driver.DriverManager;
import com.evbox.driver.util.ScreenshotUtil;
import com.evbox.logger.Logger;
import com.evbox.report.ReportAttachment;

public class TestListener implements ITestListener, IInvokedMethodListener {

    private static final Logger LOGGER = new Logger(TestListener.class);

    public void onTestStart(ITestResult result) {
        LOGGER.debug("Starting test: " + getMethodName(result));
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.debug("SUCCESS: " + getMethodName(result));
    }

    public void onTestFailure(ITestResult result) {
        LOGGER.debug("FAILURE: " + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.debug("SKIPPED: " + getMethodName(result));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // Auto-generated method stub
    }

    public void onFinish(ITestContext context) {
        // Auto-generated method stub
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Auto-generated method stub
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            WebDriver driver = DriverManager.getInstance().getDriver();
            ReportAttachment.attachScreenshot(ScreenshotUtil.takeScreenshot(driver, FrameworkConstant.SCREENSHOTS_FOLDER));
        }
    }

    private String getMethodName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

}
