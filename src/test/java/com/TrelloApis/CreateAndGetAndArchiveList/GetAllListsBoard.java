package com.TrelloApis.CreateAndGetAndArchiveList;

import com.TrelloApis.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllListsBoard {

    public static void getAllLists(String boardID) {
        //take object from class GlobalVariables
        GlobalVariables globals = new GlobalVariables();

        //take object from Response Interface.
        Response response;

        //GET request with RestAssured BDD Style and set Response in response variable.
        response =RestAssured
                .given()
                //set request BaseUrl and path parameter.
                .baseUri(globals.getBaseUrl()+"/1/boards/"+boardID+"/lists")
                //set request required headers like Content-Type.
                .header("Content-Type","application/json")
                //set APIKey in key parameter.
                .queryParam("key",globals.getAPIKey())
                //set APIToken in token parameter.
                .queryParam("token",globals.getAPIToken())
                .when()
                //use HTTP GET method.
                .get();

        //print response body
        response.prettyPrint();

    }


}
