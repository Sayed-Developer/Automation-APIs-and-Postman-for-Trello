package com.TrelloApis.CreateAndGetAndArchiveList;

import com.TrelloApis.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ArchiveList {

    public static void closeList(String listID) {
        //take object from class GlobalVariables
        GlobalVariables globals = new GlobalVariables();

        //take object from Response Interface.
        Response response;

        //PUT request with RestAssured BDD Style and set Response in response variable.
        response =RestAssured
                .given()
                //set request BaseUrl and path parameter.
                .baseUri(globals.getBaseUrl()+"/1/lists/"+listID+"/closed")
                //set request required headers like Content-Type.
                .header("Content-Type","application/json")
                //Set value to true to close (archive) the list
                .queryParam("value",true)
                //set APIKey in key parameter.
                .queryParam("key",globals.getAPIKey())
                //set APIToken in token parameter.
                .queryParam("token",globals.getAPIToken())
                .when()
                //use HTTP PUT method.
                .put();

        //print response body
        response.prettyPrint();

    }


}
