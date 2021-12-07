package presenter.menu_system;

import presenter.menu_system.view_interface.DisplayMenuViewInterface;
import use_case.dish_list.DishList;
import use_case.dish_list.boundaries.MenuOutputBoundary;

/**
 * Presenter class for menu.
 */


public class MenuPresenter implements MenuOutputBoundary{

    private DishList dishList;
    private DisplayMenuViewInterface displayMenuViewInterface;

    /**
     * Presenter class for menu.
     */
    public MenuPresenter(){
        initializeDishList();
    }


    /**
     * Setting up the DisplayDishesViewInterface.
     * @param displayMenuViewInterface the view to display things to
     */
    public void setDisplayDishesViewInterface(DisplayMenuViewInterface displayMenuViewInterface) {
        this.displayMenuViewInterface = displayMenuViewInterface;
    }

    private void initializeDishList(){
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


}