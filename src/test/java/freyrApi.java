import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@Test
public class freyrApi {

    String url_api_freyr = "https://freyr-test.pulsus.mobi";
    String schema_name = "tenant_qa_tenant_teste_bruno_809";
    int tenant = 809;

    @Test(priority = 1)
    public void health() {

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("health")
                .then().log().all().assertThat().statusCode(200).body("api", equalTo(true))
                .header("server", "uvicorn");
    }
    @Test(priority = 2)
    public void tenantId(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("overview/"+tenant)
                .then().log().all().statusCode(200);
    }
    @Test(priority = 3)
    public void tenantActive() {

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("overview/"+tenant+"/active")
                .then().log().all().statusCode(200);
    }
    @Test(priority = 4)
    public void tenantLowBattery(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("overview/"+tenant+"/low_battery")
                .then().log().all().statusCode(200);

    }
    @Test(priority = 5)
    public void tenantGpsOff(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("overview/"+tenant+"/gps_off")
                .then().log().all().statusCode(200);

    }
    @Test(priority = 6)
    public void tenantNotSynchronized(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("overview/"+tenant+"/not_synchronized")
                .then().log().all().statusCode(200);

    }
    @Test(priority = 7)
    public void safetynetSettingSchemaName() {

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("safetynet/setting/"+schema_name)
                .then().log().all().statusCode(200);
    }

    @Test(priority = 8)
    public void attestationKey(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("safetynet/attestation_key")
                .then().log().all().statusCode(200);

    }
    @Test(priority = 9)
    public void wipeMessageWpSchemaName(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("wipe-message/wp/"+schema_name)
                .then().log().all().statusCode(200);

    }
    @Test(priority = 10)
    public void messageWpSchemaName(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("message/wp/"+schema_name)
                .then().log().all().statusCode(200);

    }
    @Test(priority = 11)
    public void groupByIdTenantId(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("group/by_id/"+tenant)
                .then().log().all().statusCode(200);

    }
    @Test(priority = 12)
    public void groupSchemaName(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("group/"+schema_name)
                .then().log().all().statusCode(200);

    }
    @Test(priority = 13)
    public void groupSchemaNameGroupIdApplications(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("group/"+schema_name+"/1/applications")
                .then().log().all().statusCode(200);

    }
    @Test(priority = 14)
    public void groupSchemaNamePolicyPolicyIdApplicationsFilter(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("group/"+schema_name+"/policy/1/applications/filter")
                .then().log().all().statusCode(200);

    }
    @Test(priority = 15)
    public void applicationSchemaName(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("application/"+schema_name)
                .then().log().all().statusCode(200);

    }
    @Test(priority = 16)
    public void applicationTenantIdFilter(){

        RestAssured.baseURI = url_api_freyr;
        given().header("Content-Type", "application/json")
                .when().get("application/"+schema_name+"/filter")
                .then().log().all().statusCode(200);

    }


}
