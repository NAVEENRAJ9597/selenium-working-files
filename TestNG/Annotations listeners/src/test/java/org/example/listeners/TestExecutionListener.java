package org.example.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n[Listener] === TEST XML BLOCK STARTED: " + context.getName() + " ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[Listener] Test Method Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[Listener] Test Method PASSED: " + result.getMethod().getMethodName() + "\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.err.println("[Listener] Test Method FAILED: " + result.getMethod().getMethodName());
        // E.g., WebDriver driver = ((BaseTest)result.getInstance()).getDriver();
        // Take Screenshot logic goes here...
        System.err.println("[Listener] Screenshot dynamically captured for failure.\n");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[Listener] Test Method SKIPPED: " + result.getMethod().getMethodName() + "\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[Listener] === TEST XML BLOCK FINISHED: " + context.getName() + " ===\n");
    }
}
