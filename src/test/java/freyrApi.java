import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@Test
public class freyrApi {

    public void health() {

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi";
        given().header("Content-Type", "application/json")
                .when().get("health")
                .then().log().all().assertThat().statusCode(200).body("api", equalTo(true))
                .header("server", "uvicorn");
    }

    public void tenantId(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("overview/809")
                .then().log().all().statusCode(200);
    }

    public void tenantActive() {

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("overview/809/active")
                .then().log().all().statusCode(200);
    }

    public void tenantLowBattery(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("overview/809/low_battery")
                .then().log().all().statusCode(200);

    }

    public void tenantGpsOff(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("overview/809/gps_off")
                .then().log().all().statusCode(200);

    }

    public void tenantNotSynchronized(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("overview/809/not_synchronized")
                .then().log().all().statusCode(200);

    }

    public void safetynetSettingSchemaName() {

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("safetynet/setting/tenant_felipe_762")
                .then().log().all().statusCode(200);
    }


    public void attestationKey(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("safetynet/attestation_key")
                .then().log().all().statusCode(200);

    }

    public void wipeMessageWpSchemaName(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("wipe-message/wp/tenant_felipe_762")
                .then().log().all().statusCode(200);

    }

    public void messageWpSchemaName(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("message/wp/tenant_felipe_762")
                .then().log().all().statusCode(200);

    }

    public void groupByIdTenantId(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("group/by_id/809")
                .then().log().all().statusCode(200);

    }

    public void groupSchemaName(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("group/tenant_felipe_762")
                .then().log().all().statusCode(200);

    }

    public void groupSchemaNameGroupIdApplications(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("group/tenant_felipe_762/1/applications")
                .then().log().all().statusCode(200);

    }

    public void groupSchemaNamePolicyPolicyIdApplicationsFilter(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("group/tenant_felipe_762/policy/1/applications/filter")
                .then().log().all().statusCode(200);

    }

    public void applicationSchemaName(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("application/tenant_felipe_762")
                .then().log().all().statusCode(200);

    }

    public void applicationTenantIdFilter(){

        RestAssured.baseURI = "https://freyr-test.pulsus.mobi/";
        given().header("Content-Type", "application/json")
                .when().get("application/tenant_felipe_762/filter")
                .then().log().all().statusCode(200);

    }


}
