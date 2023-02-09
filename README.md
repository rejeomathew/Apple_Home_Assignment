# RestAssuredFramework

API Automation Framework built using Rest Assured, Java, Maven, TestNG, Extent Reports.

****************************************************************************

How to use this framework?

Clone the repository to your workspace.

TestData is not maintained for this framework yet.

Run the testng.xml file always.

Note: If you try to run individual tests as testng test, you will get a NullPointerException on the ExtentReport object as the listeners are configured in testng.xml

We can run it using mvn test with surefire plugin as well
******************************************************************************
How the framework works?

All the Business logic is written under src/main/java package

The ListenerClass under task.restassured.listeners implements the ITestListener and ISuiteListener to have a loose 
coupling between the Tests and the setup logic

The task.restassured.reports deals with setting up, logging, maintaining thread synchronization and flushing the reports

The Tests are maintained under src/main/test package

BaseTest takes care of overriding the Hooks Logic for setting up and teardown of test suites.

Our Main Test Class here is SearchAPIRequestTest which does the request to the Search API and Validating the Response 
Schema.


*******************************************************************************
