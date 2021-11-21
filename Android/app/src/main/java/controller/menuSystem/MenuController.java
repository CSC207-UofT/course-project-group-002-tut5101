package controller.menuSystem;

import use_case.boundary.output.MenuOutputBoundary;
import use_case.dishList.DishList;

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

    public void numberOfDishesInMenu(MenuOutputBoundary menuOutputBoundary) {
        dishList.numberOfDishesForPresenter(menuOutputBoundary);
    }

    public void allDishNames(MenuOutputBoundary menuOutputBoundary) {
        dishList.getAllDishNamesAsListForPresenter(menuOutputBoundary);
    }

    public void passDishesOrdered(MenuOutputBoundary menuOutputBoundary, int dishNameIndex, int dishQuantity) {
        dishList.passDishesOrdered(menuOutputBoundary, dishNameIndex, dishQuantity);
    }

    public void saveToFile(){
        this.dishList.saveToFile();
    }

}