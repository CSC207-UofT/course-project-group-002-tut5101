package controller.menuSystem;

import constant.fileSystem.FileLocation;
import gateway.MenuReadWriter;
import use_case.dishList.DishList;

import java.util.HashMap;
import java.util.List;

/**
 * Controller class for menu.
 */


public class MenuController {

    private static MenuReadWriter mrw = new MenuReadWriter();
    private static HashMap map;
    DishList dishList;

    public MenuController(){
        map = mrw.readFromFile(FileLocation.MENU_FILE_LOCATION);
        dishList = new DishList(map);
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
        mrw.saveToFile(FileLocation.MENU_FILE_LOCATION, map);
    }

}