package presenter.menu_system;

import presenter.menu_system.view_interface.ManageMenuViewInterface;
import use_case.dish_list.boundaries.ManageMenuOutputBoundary;
import use_case.dish_list.DishList;

/**
 * Presenter class for managing menu.
 */
public class ManageMenuPresenter implements ManageMenuOutputBoundary {
    private ManageMenuViewInterface manageMenuViewInterface;
    public DishList dishList;

    /**
     * Constructor for this class.
     */
    public ManageMenuPresenter(){
    }

    /**
     *
     * @param manageMenuViewInterface view interface for managing menu.
     */
    public void setManageMenuViewInterface(ManageMenuViewInterface manageMenuViewInterface) {
        this.manageMenuViewInterface = manageMenuViewInterface;
        initializeDishList();
    }

    /**
     * Initialize the dishList
     */
    private void initializeDishList() {
        dishList = new DishList();
        dishList.setManageMenuOutputBoundary(this);
    }

    /**
     * Getting the dish.
     *
     * @param dishName name of the dish.
     */
    public void getDish(String dishName) {
        manageMenuViewInterface.getDish(dishName);
    }

    /**
     * getting the dish list.
     */
    public void getDishList(){
        dishList.passDishesAsList();
    }

    /**
     * passing dishList as array.
     *
     * @param s array of string.
     */
    @Override
    public void passingDishesAsList(String[] s) {
        manageMenuViewInterface.gettingDishList(s);
    }
}
