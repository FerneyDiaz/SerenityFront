package com.avaldigitallabs.facilpass.backend;

import io.restassured.RestAssured;


public class RequestMethodBO {


    public static void postRequest(String auth, Object bodyJson){
        RestAssured.baseURI = "https://fap-toll-stg-api-vehicles.avaldigitallabs.com";
        RestAssured.given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+auth)
                .header("request-uuid","1")
                .header("request-date","1")
                .body(bodyJson)
                .when()
                .post("/vehicles/delete")
                .then().statusCode(200);
    }
}
