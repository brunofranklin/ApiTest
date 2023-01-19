import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.net.Urls;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Test
public class idunaApi {

    String url_api = "https://iduna-test.pulsus.mobi";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRfaWQiOjgwOSwiYWRtaW5pc3RyYXRvcl9pZCI6NTY1LCJleHAiOjE2NzQyNDkyMzEsIm5iZiI6MTY3NDE2MjgzMX0.hekEnWVztXsZtW9cKIOO8vzPdbUrTwYNh--Ukyh8wDQ";
    String authToken = "Bearer "+token;

    public void tenantIdCredentials() {

        RestAssured.baseURI = url_api;
        given().header("Authorization", authToken)
                .contentType("application/json")
                .when().get("/792/credentials")
                .then().log().all().assertThat().statusCode(200);
    }


}
