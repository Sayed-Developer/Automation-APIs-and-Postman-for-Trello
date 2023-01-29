package com.TrelloApis;

public class GlobalVariables {
    private final String baseUrl = "https://api.trello.com";
    private final String APIKey = "166b0f076d1e61af43df2fee3adc6a56";
    private final String APIToken = "ATTAd1cc087aa65d9915914fe8cbfcfef1cd1169b0951cf883c85cca0cfae8e672acA4BF4E03";
    private final String memberID = "6307cfed1cec940110141d3b" ;
    private String organizationID;
    private String boardID;
    private String listID;


    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAPIKey() {
        return APIKey;
    }

    public String getAPIToken() {
        return APIToken;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }

    public String getBoardID() {
        return boardID;
    }

    public void setBoardID(String boardID) {
        this.boardID = boardID;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

}
