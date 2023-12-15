package com.ecommerce.qa.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.ecommerce.qa.steps.TestBase;

public class TestListener implements ITestListener, IRetryAnalyzer {

    private static final int MAX_RETRY_COUNT = 2;
    private int retryCount = 0;

    Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " Started");
        log.info(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " Passed");
        resetRetryCount();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test case failed because of - " + result.getThrowable());
        captureScreenshot(result.getMethod().getMethodName());

        if (retryCount < MAX_RETRY_COUNT) {
            log.info("Retrying test case " + result.getMethod().getMethodName() + " for the " + (retryCount + 1) + " time.");
            resetRetryCount();
            result.setStatus(ITestResult.FAILURE);
        } else {
            resetRetryCount();
            result.setStatus(ITestResult.FAILURE);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test case skipped because of - " + result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("============onStart:- " + context.getName() + "=============================");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("============onFinish:- " + context.getName() + "=============================");
    }

    private void captureScreenshot(String methodName) {
        ScreenshotUtil.captureScreenshot(TestBase.getdriver(), methodName);
    }

    private void resetRetryCount() {
        retryCount = 0;
    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }
}