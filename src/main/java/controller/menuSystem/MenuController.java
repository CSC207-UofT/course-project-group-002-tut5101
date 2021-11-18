package controller.menuSystem;

import constant.fileSystem.FileLocation;
import use_case.dishList.DishList;
import java.util.HashMap;
import java.util.List;

/**
 * Controller class for menu.
 */


public class MenuController {

    DishList dishList;

    public MenuController(){
        dishList = new DishList(FileLocation.MENU_FILE_LOCATION);
    }

    //TODO: Add methods to get list of dish names from integer in menu


    //TODO: Add method to read things from menu

    public List<String> passDishNumbersOrdered(List<Integer> orderedNum) {
        return dishList.getDishNamesFromInt(orderedNum);
    }

    public String dishesInMenuAsString() {
        return dishList.toString();
    }

    public void saveToFile(){
        this.dishList.saveToFile();
    }

}