package com.TrelloApis.CreateAndGetAndDeleteOrganization;

import com.TrelloApis.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteOrganization {

    public static void deleteOrganization(String organizationID) {
        //take object from class GlobalVariables
        GlobalVariables globals = new GlobalVariables();

        //take object from Response Interface.
        Response response;

        //DELETE request with RestAssured BDD Style and set Response in response variable.
        response =RestAssured
                .given()
                //set request BaseUrl and path parameter.
                .baseUri(globals.getBaseUrl()+"/1/organizations/"+organizationID)
                //set request required headers like Content-Type.
                .header("Content-Type","application/json")
                //set APIKey in key parameter.
                .queryParam("key",globals.getAPIKey())
                //set APIToken in token parameter.
                .queryParam("token",globals.getAPIToken())
                .when()
                //use HTTP DELETE method.
                .delete();

        //print response body
        response.prettyPrint();

    }


}
