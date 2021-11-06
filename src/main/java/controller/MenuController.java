package controller;

import constant.FileLocation;
import gateway.MenuReadWriter;
import use_case.DishList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuController {

    private static MenuReadWriter mrw = new MenuReadWriter();
    private static HashMap map;
    DishList dishList;

    public MenuController(HashMap outmap){
        map = outmap;
        dishList = new DishList(map);
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

    public void SavetoFile(){
        mrw.saveToFile("src/main/resources/menu.ser", map);
    }

}