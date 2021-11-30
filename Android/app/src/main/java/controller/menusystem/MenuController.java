package controller.menusystem;

import entity.orderList.Dish;
import use_case.boundary.output.MenuOutputBoundary;
import use_case.dishlist.DishList;


import java.util.HashMap;
import java.util.List;

/**
 * Controller class for menu.
 */


public class MenuController {

    public DishList dishList;

    public MenuController(){
        dishList = new DishList("src/main/resources/menu.ser");

        //TODO: Delete later
        generateDishList();
    }

    public void setMenuOutputBoundary(MenuOutputBoundary menuOutputBoundary){
        dishList.setMenuOutputBoundary(menuOutputBoundary);
    }


    /**
     *
     * @param orderedNum a List of integers representing numbers from order.
     * @return a list of strings of dish names from a list of integers from order.
     */
    public List<String> passDishNumbersOrdered(List<Integer> orderedNum) {
        return DishList.getDishNamesFromInt(orderedNum);
    }

    public Dish passDishByString(String dishName){
        return DishList.getDishByDishName(dishName);
    }

    public int length(){
        return dishList.size();
    }

    /**
     *
     * @return a string representation of dishlist.
     */
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

    public void deleteDishByName(String dishName) {
        dishList.deleteDishByName(dishName);
    }

//    /**
//     * save the dishList(or menu) to file.
//     */
//    public void saveToFile(){
//        this.dishList.saveToFile();
//    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void editDishByName(String dishName) {
        this.dishList.editDishByName(dishName);
    }

    public String[] passDishesAsList(){
        return this.dishList.passDishesAsList();
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