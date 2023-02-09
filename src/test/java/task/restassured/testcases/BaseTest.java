package task.restassured.testcases;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import task.restassured.constants.Constants;
import task.restassured.reports.ExtentReport;
import task.restassured.reports.LogStatus;

import java.awt.*;
import java.io.File;
import java.io.PrintStream;
import java.io.StringWriter;

public class BaseTest {


    protected StringWriter writer;
    protected PrintStream captor;


    @BeforeSuite
    public void setUpSuite() {

    }

    @AfterSuite
    public void afterSuite() throws Exception {
        ExtentReport.flushReports();
        File htmlFile = new File(Constants.getExtentReportFilePath());
//        Desktop.getDesktop().browse(htmlFile.toURI());

    }


    @BeforeMethod
    public void setUp() {

        writer = new StringWriter();
        captor = new PrintStream(new WriterOutputStream(writer), true);
    }

    protected void formatAPIAndLogInReport(String content) {
        String prettyPrint = content.replace("\n", "<br>");
        LogStatus.info("<pre>" + prettyPrint + "</pre>");

    }
    public void writeRequestAndResponseInReport(String request,String response) {
        LogStatus.info("---- Request ---");
        formatAPIAndLogInReport(request);
        LogStatus.info("---- Response ---");
        formatAPIAndLogInReport(response);
    }
}
