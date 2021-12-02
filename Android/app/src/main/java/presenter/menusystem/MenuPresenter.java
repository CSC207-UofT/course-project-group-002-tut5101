package presenter.menusystem;

import entity.orderlist.Dish;
import presenter.managersystem.ManageMenuViewInterface;
import use_case.dishlist.DishList;
import use_case.boundary.output.MenuOutputBoundary;


import java.util.HashMap;

/**
 * Presenter class for menu.
 */


public class MenuPresenter implements MenuOutputBoundary {

    public final DishList dishList;
    private DisplayMenuViewInterface displayMenuViewInterface;
    private ManageMenuViewInterface manageMenuViewInterface;
    /**
     * Presenter class for menu.
     */
    public MenuPresenter(){
        dishList = new DishList();
        dishList.setMenuOutputBoundary(this);

        //TODO: Delete later
        generateDishList();
    }

    /**
     * Setting up the DisplayDishesViewInterface.
     * @param displayMenuViewInterface interface for displaying menu.
     */
    public void setDisplayDishesViewInterface(DisplayMenuViewInterface displayMenuViewInterface) {
        this.displayMenuViewInterface = displayMenuViewInterface;
    }



    /**
     * get string representation of dishes in menu from dishList use case
     */
    public void dishesInMenuAsString() {
        dishList.dishesString();
    }

    /**
     * update the display to show dishes in menu
     * @param menuItems the items in the menu as a string
     */
    public void updateMenuItemsDisplay(String menuItems) {
        displayMenuViewInterface.setMenuItemsText(menuItems);
    }

    /**
     * delete a dish by the dish name
     * @param dishName name of dish
     */
    public void deleteDishByName(String dishName) {
        dishList.deleteDishByName(dishName);
    }

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