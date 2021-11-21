package controller.menuSystem;

import constant.fileSystem.FileLocation;
import use_case.dishList.DishList;
import java.util.HashMap;
import java.util.List;

/**
 * Controller class for menu.
 */


public class MenuController {

    public DishList dishList;

    public MenuController(){
        dishList = new DishList("src/main/resources/menu.ser");
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