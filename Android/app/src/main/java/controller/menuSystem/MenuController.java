package controller.menuSystem;

import use_case.boundary.output.MenuOutputBoundary;
import use_case.dishList.DishList;

import java.util.List;

/**
 * Controller class for menu.
 */


public class MenuController {

    public DishList dishList;
    private MenuOutputBoundary menuOutputBoundary;

    public MenuController(){
        dishList = new DishList("src/main/resources/menu.ser");
    }

    public void setMenuOutputBoundary(MenuOutputBoundary menuOutputBoundary){
        this.menuOutputBoundary = menuOutputBoundary;
        dishList.setMenuOutputBoundary(menuOutputBoundary);
    }

    //TODO: Add methods to get list of dish names from integer in menu


    //TODO: Add method to read things from menu

    public List<String> passDishNumbersOrdered(List<Integer> orderedNum) {
        return dishList.getDishNamesFromInt(orderedNum);
    }

    public String dishesInMenuAsString() {
        return dishList.toString();
    }

    public void numberOfDishesInMenu() {
        dishList.numberOfDishesForPresenter();
    }

    public void allDishNames() {
        dishList.getAllDishNamesAsListForPresenter();
    }

    public void passDishesOrdered(int dishNameIndex, int dishQuantity) {
        dishList.passDishesOrdered(dishNameIndex, dishQuantity);
    }

    public void saveToFile(){
        this.dishList.saveToFile();
    }

}