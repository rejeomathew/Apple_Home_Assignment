package task.restassured.reports;

import com.aventstack.extentreports.Status;

public class LogStatus {

    private LogStatus() {

    }
    public static void pass(String message)
    {
        ExtentManager.getExtentTest().pass(message);

    }

    public static void fail(String message)
    {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void info(String message)
    {
        ExtentManager.getExtentTest().info(message);
    }

    public static void skip(String message)
    {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void warning(String message)
    {
        ExtentManager.getExtentTest().warning(message);
    }

}

