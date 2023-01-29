package com.TrelloApis;

import com.TrelloApis.CreateAndGetAndArchiveList.ArchiveList;
import com.TrelloApis.CreateAndGetAndArchiveList.CreateNewList;
import com.TrelloApis.CreateAndGetAndArchiveList.GetAllListsBoard;
import com.TrelloApis.CreateAndGetAndDeleteBoard.CreateBoardInsideOrganization;
import com.TrelloApis.CreateAndGetAndDeleteBoard.DeleteBoard;
import com.TrelloApis.CreateAndGetAndDeleteBoard.GetBoardsInOrganization;
import com.TrelloApis.CreateAndGetAndDeleteOrganization.CreateNewOrganization;
import com.TrelloApis.CreateAndGetAndDeleteOrganization.DeleteOrganization;
import com.TrelloApis.CreateAndGetAndDeleteOrganization.GetOrganizationsForMember;

public class Runner {
    static GlobalVariables global;
    public static void main(String[] args) {
        //take instance from GlobalVariables class.
        global =new GlobalVariables();

        //to create organization.
        runNewOrganization();

        //to get organization.
        runGetOrganization();

        //to create board.
        runNewBoard();

        //to get all boards.
        runGetBoards();

        //to create List.
        runNewList();

        //to get all Lists.
        runGetLists();

        //to closeList.
        runCloseList();

        //to deleteBoard.
        runDeleteBoard();

        //to deleteOrganization.
        runDeleteOrganization();


    }

    public static void runNewOrganization(){
        //creat new organization and set OrganizationID  in global instance.
        global.setOrganizationID(
                CreateNewOrganization.
                        buildNewOrganization(
                                "New Trello Organization"));
    }

    public static void runGetOrganization(){
        //get all organizations for specific member.
        GetOrganizationsForMember.getMemberOrganizations();
    }

    public static void runNewBoard(){
        //creat new board and set BoardID in global instance.
        global.setBoardID(
                CreateBoardInsideOrganization.
                        CreateNewBoard(
                                "New Trello Board",
                                global.getOrganizationID()));
    }

    public static void runGetBoards(){
        //get all boards in created organization.
        GetBoardsInOrganization.getBoards(global.getOrganizationID());
    }

    public static void runNewList(){
        //create new list and set ListID in global instance.
        global.setListID(CreateNewList.
                createNewList(
                        "New Trello List",
                        global.getBoardID()));
    }

    public static void runGetLists(){
        //get all lists inside the created board.
        GetAllListsBoard.getAllLists(global.getBoardID());
    }

    public static void runCloseList(){
        //delete identified list.
        ArchiveList.closeList(global.getListID());
    }

    public static void runDeleteBoard(){
        //close or delete identified board.
        DeleteBoard.deleteBoard(global.getBoardID());
    }

    public static void runDeleteOrganization(){
        //delete identified organization.
        DeleteOrganization.deleteOrganization(global.getOrganizationID());
    }

}
