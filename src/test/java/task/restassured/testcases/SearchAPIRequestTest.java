package task.restassured.testcases;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import task.restassured.constants.Constants;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;


public class SearchAPIRequestTest extends BaseTest{
    public static final int limit = 25;
    @Test
    public void searchRequest() {

        Response response=	given()
                .filter(new RequestLoggingFilter(captor)) //This line is mandatory to log the request details to extent report
                .log()
                .all()
                .queryParam("term", "jack johnson")
                .queryParam("limit", limit)
                .get(Constants.BASEURL+Constants.SEARCHRESOURCE);

        /*
         * Writing the request and response to extent report
         * This statement needs to repeated in all your tests to log the req and response in extent report.
         *
         *
         */
        writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());

        //Asserting status code
        response.then().statusCode(200);
        //Asserting the list size in the response
        Assert.assertEquals(response.jsonPath().getInt("resultCount"), limit);
    }


}
