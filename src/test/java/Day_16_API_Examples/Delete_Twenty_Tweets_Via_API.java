package Day_16_API_Examples;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class Delete_Twenty_Tweets_Via_API {

    String consumerKey = "hKGoNqebhzwZgz1jXeg4lIE2E";
    String consumerSecret = "SKjjhLIOBfp1sFa2YmOW77HJJSLyd0zXx4x1GaBO8FRow39WMx";
    String accessToken = "1433866008125743114-jN72dtk0wLC1m6TYWVT8QEA7OtcWX0";
    String tokenSecret = "7ZuD4y8U3NRdLlKjdw3TovuWl1YK0IvXUT8CBHqmieIDf";
    //String id = "";


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/";
    }//end of set up

    //create 20 twitter post through rest api
    @Test
    public void deleteRecentTwentyTweets() throws InterruptedException {

        for (int i = 1; i <= 20; i++) {
            Response response =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
                            //get the time line
                            .when().get("user_timeline.json")
                            .then().extract().response();


            if (response.statusCode() == 200) {
                System.out.println("Status code is 200 as expected");
            } else {
                System.out.println("Actual status code is " + response.statusCode());
            }

            //verify the id and the text after posting
            String resp = response.asString();
            JsonPath json = new JsonPath(resp);
            //id
            String id = json.getString("id[0]");
            //System.out.println("MY id is " + id);

            Response response2 =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                            queryParam("id", id)
                            .when().post("destroy.json")
                            .then().extract().response();
            if (response2.statusCode() == 200) {
                System.out.println("Successfully deleted id " + id);
            } else {
                System.out.println("Actual status code is " + response2.statusCode());
            }
        }//end of for loop
    }//end of test

}//end of class
