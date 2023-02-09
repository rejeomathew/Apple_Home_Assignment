package task.restassured.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import task.restassured.constants.Constants;

import java.util.Objects;


public final class ExtentReport {

    private ExtentReport() {
    }
    private static ExtentReports extentReports;
    private static ExtentTest test;

    public static void initReports() throws Exception {
        if (Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(Constants.getExtentReportFilePath());
            extentReports.attachReporter(extentSparkReporter);

            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setDocumentTitle("Apple Home Assignment Report");
            extentSparkReporter.config().setReportName("search-api-challenge");
        }
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extentReports))
            extentReports.flush();
//        Desktop.getDesktop().browse(new File(Constants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors){
        for(String author: authors){
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(String[] categories){
        for(String category: categories){
            ExtentManager.getExtentTest().assignCategory(category);
        }
    }
}
