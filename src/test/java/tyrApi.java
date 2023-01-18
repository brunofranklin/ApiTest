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
public class tyrApi {

    String token = "https://tyr-test.pulsus.mobi";
    String url_api = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbiI6InlhMjkuYTBBWDlHQmRWUWt0M0s2RUYxTVdEcTFlaHg0bExwREE1c2ZjYkk4N0pnY0N0XzlRM3ZFVFZUWVVTTTIwakVzb01DSFlHdEFENWs3TU50eHhPN2xHQjRWLURSNzk1OGRqN3FfUnB6aDBwT3V3RG1Ebml4Y1RpRmI5ZWFYNjhpOXV5aDNfLWtsMWRFbFNVWmhVa0RkU2YyQ0llSnB6TDJhQ2dZS0FVTVNBUklTRlFIVUNzYkN5TVFLUVNwWGg5Zk9PTDZUYjNSSm1RMDE2MyIsInJlZnJlc2hfdG9rZW4iOiIxLy8waGpjdUVKeF8yLW55Q2dZSUFSQUFHQkVTTndGLUw5SXJ0VXI5ZVdiOF9pTFlRNjUxejhpUEUxRHJyY2dZdG5RUUtWSVIxVXBkRW9aVlFGMENvT3pyMm5yay1aZ0F5WlUyVEIwIiwidG9rZW5fdXJpIjoiaHR0cHM6Ly9vYXV0aDIuZ29vZ2xlYXBpcy5jb20vdG9rZW4iLCJjbGllbnRfaWQiOiI2NDA0MTU3NDUzOTktcmZscDFhZHFoYTYxNW9oM3EzZjF1amx2aDF1cHVqMzAuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJjbGllbnRfc2VjcmV0IjoiR09DU1BYLTlyVkRHQ2ZYV0kyNU4wal9sSGxfZUtiSVoxRnQiLCJzY29wZXMiOlsiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC91c2VyaW5mby5wcm9maWxlIiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC91c2VyaW5mby5lbWFpbCIsImh0dHBzOi8vYXBwcy1hcGlzLmdvb2dsZS5jb20vYS9mZWVkcy9wb2xpY2llcy8iLCJodHRwczovL2FwcHMtYXBpcy5nb29nbGUuY29tL2EvZmVlZHMvZ3JvdXBzLyIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvY2xvdWQtcGxhdGZvcm0iLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LnBvbGljeSIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvY2hyb21lLm1hbmFnZW1lbnQucG9saWN5LnJlYWRvbmx5IiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkuZGV2aWNlLmNocm9tZW9zIiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkuZGV2aWNlLmNocm9tZW9zLnJlYWRvbmx5IiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkuY3VzdG9tZXIiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2FkbWluLmRpcmVjdG9yeS5jdXN0b21lci5yZWFkb25seSIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvYWRtaW4uZGlyZWN0b3J5Lm9yZ3VuaXQiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2FkbWluLmRpcmVjdG9yeS5vcmd1bml0LnJlYWRvbmx5IiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkudXNlciIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvYWRtaW4uZGlyZWN0b3J5LnVzZXIucmVhZG9ubHkiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LnJlcG9ydHMucmVhZG9ubHkiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LmFwcGRldGFpbHMucmVhZG9ubHkiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LnRlbGVtZXRyeS5yZWFkb25seSIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvYWRtaW4uY2hyb21lLnByaW50ZXJzIiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5jaHJvbWUucHJpbnRlcnMucmVhZG9ubHkiLCJvcGVuaWQiXSwiZXhwaXJ5IjoiMjAyMy0wMS0xMlQxNzoxNjowOC4wMzI4MTNaIn0.inu1hMofpIuiUm8Wb7gKqEQ3WtzGYaGHfCOTLSGFGXE";


    public void health() {

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("health")
                .then().log().all().assertThat().statusCode(200).body("api", equalTo(true))
                .header("server", "uvicorn");
    }

    public void login(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("login?redirect_url=%2Fshow_info")
                .then().log().all().statusCode(200);
    }

    public void defaultShowInfo(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("show_info?auth="+token)
                .then().log().all().statusCode(200);
    }

    public void usersList(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("users/list?domain=360pulsus.com&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdOrgUnitsList(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("my_customer/org_units/list?report_type=children&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdOrgUnitsGet(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("my_customer/org_units/get?_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdOrgUnitsInsert(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"name\": \"TestqaAPI\",\n" +
                        "  \"description\": \"TestqaAPI\",\n" +
                        "  \"blockInheritance\": true,\n" +
                        "  \"parentOrgUnitPath\": \"/\"\n" +
                        "}")
                .when().post("my_customer/org_units/insert?_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdOrgUnitsPatch(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"name\": \"testqaAPI\",\n" +
                        "  \"description\": \"testqaAPI\",\n" +
                        "  \"blockInheritance\": true,\n" +
                        "  \"parentOrgUnitPath\": \"/\"\n" +
                        "}")
                .when().post("my_customer/org_units/patch?org_unit_path=testqaAPI&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdChromeDevicesList(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("my_customer/chrome_devices/list?org_unit_path=PulsusSubUnit_3&max_results=10&order_by=lastSync&projection=BASIC&sort_order=ASCENDING&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdChromeDevicesGet(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("my_customer/chrome_devices/get?device_id=de780846-d6c6-4fda-8534-a3cb541420d7&projection=BASIC&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdChromeDevicesMoveToOrgUnit(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"deviceIds\": [\n" +
                        "    \"3a901c3d-b941-4a93-8413-3132b37aede0\"\n" +
                        "  ]\n" +
                        "}")
                .when().post("my_customer/chrome_devices/move_to_org_unit?target_unit_path=PulsusSubUnit_2&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void customerIdChromeDevicesPatch(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"annotatedUser\": \"vitorio.valer@360pulsus.com\",\n" +
                        "  \"annotatedLocation\": \"Rio de Janeiro\",\n" +
                        "  \"notes\": \"NotesFromAPI\",\n" +
                        "  \"orgUnitPath\": \"/PulsusSubUnit_3\",\n" +
                        "  \"annotatedAssetId\": \"V-001\"\n" +
                        "}")
                .when().patch("my_customer/chrome_devices/patch?device_id=3a901c3d-b941-4a93-8413-3132b37aede0&projection=BASIC&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void chromePolicyPatchPolicy(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"device_policies\": {\n" +
                        "    \"allowBluetooth\": true\n" +
                        "  },\n" +
                        "  \"user_policies\": {\n" +
                        "    \"audioCaptureAllowed\": true,\n" +
                        "    \"audioOutputAllowed\": true,\n" +
                        "    \"videoCaptureAllowed\": true,\n" +
                        "    \"externalStorageDevices\": \"EXTERNAL_STORAGE_ENUM_READ_WRITE\",\n" +
                        "    \"urlBlocking\": {\n" +
                        "      \"mode\": \"Blocklist\",\n" +
                        "      \"urls\": [\n" +
                        "        {\n" +
                        "          \"id\": 0,\n" +
                        "          \"url\": \"facebook.com\"\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"network\": {\n" +
                        "    \"mode\": \"neutral\",\n" +
                        "    \"networks\": [\n" +
                        "      {\n" +
                        "        \"name\": \"NetWorkTest\",\n" +
                        "        \"ssid\": \"NetWorkTest\",\n" +
                        "        \"security\": \"WPA-PSK\",\n" +
                        "        \"passphrase\": \"SuperSecreto\",\n" +
                        "        \"hidden\": false,\n" +
                        "        \"autoConnect\": false,\n" +
                        "        \"active\": true,\n" +
                        "        \"device_wide\": true,\n" +
                        "        \"delete\": false\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}")
                .when().post("patch_policy?org_unit_id=03ph8a2z1exbcfg&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void chromePolicyGetCurrentPolicies(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("get_current_policies?org_unit_id=03ph8a2z1exbcfg&customer_id=my_customer&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void chromePolicyListNetworks(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("list_networks?org_unit_id=03ph8a2z1exbcfg&customer_id=my_customer&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void chromePolicyPushApp(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("push_app?org_unit_id=03ph8a2z1exbcfg&type_id=android&app_id=com.reddit.frontpage&install_policy=ALLOWED&customer_id=my_customer&_client_token="+token)
                .then().log().all().statusCode(200);
    }

    public void chromePolicyListInstalledApps(){

        RestAssured.baseURI = url_api;
        given().header("Content-Type", "application/json")
                .when().get("list_installed_apps?org_unit_id=03ph8a2z1exbcfg&customer_id=my_customer&_client_token="+token)
                .then().log().all().statusCode(200);
    }





}
