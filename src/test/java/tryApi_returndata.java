import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@Test
public class tryApi_returndata {

    String token =
    String url_api =


    public void customerIdChromeDevicesMoveToOrgUnit_return(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"deviceIds\": [\n" +
                        "    \"3a901c3d-b941-4a93-8413-3132b37aede0\"\n" +
                        "  ]\n" +
                        "}")
                .when().post("my_customer/chrome_devices/move_to_org_unit?target_unit_path=PulsusSubUnit_3&_client_token="+token)
                .then().log().all().statusCode(200);
    }


    public void customerIdOrgUnitsDelete(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .body(" \"name\": \"testqaAPI\",\n" +
                        "  \"description\": \"testqaAPI\",\n" +
                        "  \"blockInheritance\": true,\n" +
                        "  \"parentOrgUnitPath\": \"/\"")
                .when().delete("my_customer/org_units/delete?org_unit_path=TestqaAPI&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void chromePolicyRemoveNetwork(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().delete("remove_network?org_unit_id=03ph8a2z1exbcfg&network_id=NetWorkTest-Wifi&_client_token="+token)
                .then().log().all().statusCode(200);
    }

}
