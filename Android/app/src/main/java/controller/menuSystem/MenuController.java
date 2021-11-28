package controller.menuSystem;

import entity.orderList.Dish;
import use_case.boundary.output.MenuOutputBoundary;
import use_case.dishList.DishList;

import java.util.HashMap;
import java.util.List;

/**
 * Controller class for menu.
 */


public class MenuController {

    public DishList dishList;
    private MenuOutputBoundary menuOutputBoundary;

    public MenuController(){
        dishList = new DishList("src/main/resources/menu.ser");

        //TODO: Delete later
        generateDishList();
    }

    public void setMenuOutputBoundary(MenuOutputBoundary menuOutputBoundary){
        dishList.setMenuOutputBoundary(menuOutputBoundary);
        this.menuOutputBoundary = menuOutputBoundary;
    }


    public List<String> passDishNumbersOrdered(List<Integer> orderedNum) {
        return DishList.getDishNamesFromInt(orderedNum);
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


    // TODO: Delete hardcoded dishes later
    //Hardcoded dishList for testing

    private void generateDishList() {
        Dish d1 = new Dish("dish1", 10, new HashMap<>(), 20);
        Dish d2 = new Dish("dish2", 30, new HashMap<>(), 200);
        Dish d3 = new Dish("dish3", 100, new HashMap<>(), 10);
        Dish d4 = new Dish("dish4", 10, new HashMap<>(), 20);
        Dish d5 = new Dish("dish5", 10, new HashMap<>(), 20);
        Dish d6 = new Dish("dish6", 10, new HashMap<>(), 20);
        Dish d7 = new Dish("dish7", 10, new HashMap<>(), 20);
        dishList.addDish(d1);
        dishList.addDish(d2);
        dishList.addDish(d3);
        dishList.addDish(d4);
        dishList.addDish(d5);
        dishList.addDish(d6);
        dishList.addDish(d7);
    }

}