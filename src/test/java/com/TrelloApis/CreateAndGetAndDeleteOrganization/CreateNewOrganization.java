package com.TrelloApis.CreateAndGetAndDeleteOrganization;

import com.TrelloApis.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateNewOrganization {

    public static String buildNewOrganization(String organizationName){
        //take instance from GlobalVariables.
        GlobalVariables global = new GlobalVariables();
        //take object from Response Interface.
        Response response;

        //POST request with RestAssured BDD Style and set Response in response variable.
        response =RestAssured
                .given()
                //set request BaseUrl and path parameter.
                .baseUri(global.getBaseUrl()+"/1/organizations")
                //set request required headers like Content-Type.
                .header("Content-Type","application/json")
                //set OrganizationName in displayName parameter.
                .queryParam("displayName",organizationName)
                //set APIKey in key parameter.
                .queryParam("key",global.getAPIKey())
                //set APIToken in token parameter.
                .queryParam("token",global.getAPIToken())
                .when()
                //use HTTP POST method.
                .post();

        //print response body
        response.prettyPrint();

        //assign response json body
        JsonPath path=response.jsonPath();

        //get Organization ID from JSON Response Body
        String organizationID = path.getString("id");

        //return Organization ID.
        return organizationID;
    }

}
