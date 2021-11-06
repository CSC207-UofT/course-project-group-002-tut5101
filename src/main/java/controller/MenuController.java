package controller;

import constant.FileLocation;
import gateway.MenuReadWriter;
import use_case.DishList;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    DishList dishList = new DishList();

    public MenuController() {
        if (dishList.getAllDishes().isEmpty())
            loadDishList();
    }

    private void loadDishList() {
        MenuReadWriter readWriter = new MenuReadWriter();
        dishList.loadHashMap(readWriter.readFromFile(FileLocation.MENU_FILE_LOCATION));
    }
    //TODO: Add methods to get list of dish names from integer in menu


    //TODO: Add method to read things from menu

    public List<String> passDishNumbersOrdered(List<Integer> orderedNum) {
        List<String> dishes = new ArrayList<String>();
        dishes = dishList.getDishNamesFromInt(orderedNum);
        return dishes;
    }

    public String dishesInMenuAsString() {
        return dishList.toString();
    }

}