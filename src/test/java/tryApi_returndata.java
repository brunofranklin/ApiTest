import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@Test
public class tryApi_returndata {

    String url_api = "https://tyr-test.pulsus.mobi";
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbiI6InlhMjkuYTBBWDlHQmRWUWt0M0s2RUYxTVdEcTFlaHg0bExwREE1c2ZjYkk4N0pnY0N0XzlRM3ZFVFZUWVVTTTIwakVzb01DSFlHdEFENWs3TU50eHhPN2xHQjRWLURSNzk1OGRqN3FfUnB6aDBwT3V3RG1Ebml4Y1RpRmI5ZWFYNjhpOXV5aDNfLWtsMWRFbFNVWmhVa0RkU2YyQ0llSnB6TDJhQ2dZS0FVTVNBUklTRlFIVUNzYkN5TVFLUVNwWGg5Zk9PTDZUYjNSSm1RMDE2MyIsInJlZnJlc2hfdG9rZW4iOiIxLy8waGpjdUVKeF8yLW55Q2dZSUFSQUFHQkVTTndGLUw5SXJ0VXI5ZVdiOF9pTFlRNjUxejhpUEUxRHJyY2dZdG5RUUtWSVIxVXBkRW9aVlFGMENvT3pyMm5yay1aZ0F5WlUyVEIwIiwidG9rZW5fdXJpIjoiaHR0cHM6Ly9vYXV0aDIuZ29vZ2xlYXBpcy5jb20vdG9rZW4iLCJjbGllbnRfaWQiOiI2NDA0MTU3NDUzOTktcmZscDFhZHFoYTYxNW9oM3EzZjF1amx2aDF1cHVqMzAuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJjbGllbnRfc2VjcmV0IjoiR09DU1BYLTlyVkRHQ2ZYV0kyNU4wal9sSGxfZUtiSVoxRnQiLCJzY29wZXMiOlsiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC91c2VyaW5mby5wcm9maWxlIiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC91c2VyaW5mby5lbWFpbCIsImh0dHBzOi8vYXBwcy1hcGlzLmdvb2dsZS5jb20vYS9mZWVkcy9wb2xpY2llcy8iLCJodHRwczovL2FwcHMtYXBpcy5nb29nbGUuY29tL2EvZmVlZHMvZ3JvdXBzLyIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvY2xvdWQtcGxhdGZvcm0iLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LnBvbGljeSIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvY2hyb21lLm1hbmFnZW1lbnQucG9saWN5LnJlYWRvbmx5IiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkuZGV2aWNlLmNocm9tZW9zIiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkuZGV2aWNlLmNocm9tZW9zLnJlYWRvbmx5IiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkuY3VzdG9tZXIiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2FkbWluLmRpcmVjdG9yeS5jdXN0b21lci5yZWFkb25seSIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvYWRtaW4uZGlyZWN0b3J5Lm9yZ3VuaXQiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2FkbWluLmRpcmVjdG9yeS5vcmd1bml0LnJlYWRvbmx5IiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5kaXJlY3RvcnkudXNlciIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvYWRtaW4uZGlyZWN0b3J5LnVzZXIucmVhZG9ubHkiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LnJlcG9ydHMucmVhZG9ubHkiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LmFwcGRldGFpbHMucmVhZG9ubHkiLCJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2Nocm9tZS5tYW5hZ2VtZW50LnRlbGVtZXRyeS5yZWFkb25seSIsImh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvYWRtaW4uY2hyb21lLnByaW50ZXJzIiwiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9hZG1pbi5jaHJvbWUucHJpbnRlcnMucmVhZG9ubHkiLCJvcGVuaWQiXSwiZXhwaXJ5IjoiMjAyMy0wMS0xMlQxNzoxNjowOC4wMzI4MTNaIn0.inu1hMofpIuiUm8Wb7gKqEQ3WtzGYaGHfCOTLSGFGXE";



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
