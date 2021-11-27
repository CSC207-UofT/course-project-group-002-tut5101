package controller.menuSystem;

import entity.orderList.Dish;
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

    public void deleteDishByName(String dishName) {
        dishList.deleteDishByName(dishName);
    }

    /**
     * save the dishList(or menu) to file.
     */
    public void saveToFile(){
        this.dishList.saveToFile();
    }

    public void editDishByName(String dishName) {
        this.dishList.editDishByName(dishName);
    }
}