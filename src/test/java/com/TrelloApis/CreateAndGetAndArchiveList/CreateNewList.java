package com.TrelloApis.CreateAndGetAndArchiveList;

import com.TrelloApis.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateNewList {

    public static String createNewList(String ListName,String boardID) {
        //take object from class GlobalVariables
        GlobalVariables globals = new GlobalVariables();

        //take object from Response Interface.

        Response response;

        //POST request with RestAssured BDD Style and set Response in response variable.
        response =RestAssured
                .given()
                //set request BaseUrl and path parameter.
                .baseUri(globals.getBaseUrl()+"/1/lists")
                //set request required headers like Content-Type.
                .header("Content-Type","application/json")
                //set ListName in name parameter.
                .queryParam("name",ListName)
                //set Board ID in name idBoard parameter.
                .queryParam("idBoard",boardID)
                //set APIKey in key parameter.
                .queryParam("key",globals.getAPIKey())
                //set APIToken in token parameter.
                .queryParam("token",globals.getAPIToken())
                .when()
                //use HTTP POST method.
                .post();

        //print response body
        response.prettyPrint();

        //assign response json body
        JsonPath path=response.jsonPath();

        //get List ID from JSON Response Body
        String listID = path.getString("id");

        //return Board ID.
        return listID;

    }

}
