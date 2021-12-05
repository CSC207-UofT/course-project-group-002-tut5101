package presenter.menu_system;

import use_case.dish_list.MenuOutputBoundary;
import use_case.dish_list.DishList;

/**
 * Controller class for menu.
 */


public class MenuPresenter implements MenuOutputBoundary {

    public DishList dishList;
    private DisplayMenuViewInterface displayMenuViewInterface;

    /**
     * Presenter class for menu.
     */
    public MenuPresenter(){
    }


    /**
     * Setting up the DisplayDishesViewInterface.
     * @param displayMenuViewInterface the view to display things to
     */
    public void setDisplayDishesViewInterface(DisplayMenuViewInterface displayMenuViewInterface) {
        this.displayMenuViewInterface = displayMenuViewInterface;
        initializeDishList();
    }

    /**
     * Initialize the dishList
     */
    private void initializeDishList() {
        dishList = new DishList();
        dishList.setMenuOutputBoundary(this);
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
        dishList.editDishByName(dishName);
    }


}