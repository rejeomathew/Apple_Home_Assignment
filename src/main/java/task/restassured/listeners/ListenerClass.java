package task.restassured.listeners;
import org.testng.*;

import task.restassured.reports.ExtentReport;
import task.restassured.reports.LogStatus;

import java.io.IOException;

public class ListenerClass implements ITestListener, ISuiteListener {

    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getMethodName());
        LogStatus.pass(result.getMethod().getMethodName()+ " is started successfully");
    }

    public void onTestSuccess(ITestResult result) {
        LogStatus.pass(result.getMethod().getMethodName()+ " test case is passed");
    }

    public void onTestFailure(ITestResult result) {
        LogStatus.fail(result.getMethod().getMethodName()+ " is failed");
        LogStatus.fail(result.getThrowable().toString());

    }

    public void onTestSkipped(ITestResult result) {
        LogStatus.skip(result.getMethod().getMethodName()+ " is skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Override
    public void onStart(ISuite suite) {
    }

    @Override
    public void onFinish(ISuite suite) {
        try{
            ExtentReport.flushReports();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
