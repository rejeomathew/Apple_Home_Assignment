package task.restassured.constants;

public class Constants {
    private Constants() {
    }
    public static final String BASEURL = "https://itunes.apple.com";
    public static final String SEARCHRESOURCE = "/search";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/test-output/extent";
    private static String extentReportFilePath = "";

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty())
            extentReportFilePath =  EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "report.html";
        return  extentReportFilePath;
    }
}
