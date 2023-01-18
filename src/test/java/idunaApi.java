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

    public void tenantIdCredentials() {

        RestAssured.baseURI = url_api;
        given().queryParam("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRfaWQiOjgwOSwiYWRtaW5pc3RyYXRvcl9pZCI6NTY1LCJleHAiOjE2NzQxNTc1MjMsIm5iZiI6MTY3NDA3MTEyM30.JOIL_v8802EGYchmDS-3QUPhDd7ZfiQzvQqK83AnRRE")
                .header("Content-Type", "application/json")
                .when().get("/792/credentials")
                .then().log().all().assertThat().statusCode(200);
    }


}
