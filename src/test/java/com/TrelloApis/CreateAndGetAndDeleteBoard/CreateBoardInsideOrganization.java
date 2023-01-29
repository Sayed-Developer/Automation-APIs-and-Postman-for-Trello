package com.TrelloApis.CreateAndGetAndDeleteBoard;

import com.TrelloApis.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateBoardInsideOrganization {

    public static String CreateNewBoard(String boardName,String organizationID) {
        //take instance from GlobalVariables.
        GlobalVariables global = new GlobalVariables();
        //take object from Response Interface.
        Response response;

        //POST request with RestAssured BDD Style and set Response in response variable.
        response =RestAssured
                .given()
                //set request BaseUrl and path parameter.
                .baseUri(global.getBaseUrl()+"/1/boards/")
                //set request required headers like Content-Type.
                .header("Content-Type","application/json")
                //set BoardName in name parameter.
                .queryParam("name",boardName)
                //set Organization ID in name idOrganization parameter.
                .queryParam("idOrganization",organizationID)
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

        //get Board ID from JSON Response Body
        String boardID = path.getString("id");

        //return Board ID.
        return boardID;

    }

}
