package controller;

import constant.FileLocation;
import gateway.MenuReadWriter;
import use_case.DishList;

import java.util.HashMap;
import java.util.List;

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

    public void SavetoFile(){
        mrw.saveToFile("src/main/resources/menu.ser", map);
    }

}