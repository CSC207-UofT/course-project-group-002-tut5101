package presenter.manager_system;

import use_case.dishlist.ManageMenuOutputBoundary;
import use_case.dishlist.DishList;

/**
 * Presenter class for managing menu.
 */
public class ManageMenuPresenter implements ManageMenuOutputBoundary {
    ManageMenuViewInterface manageMenuViewInterface;
    private final DishList dishList;

    /**
     * Constructor.
     */
    public ManageMenuPresenter(){
        this.dishList = new DishList();
        dishList.setManageMenuOutputBoundary(this);
    }

    /**
     *
     * @param manageMenuViewInterface view interface for managing menu.
     */
    public void setManageMenuViewInterface(ManageMenuViewInterface manageMenuViewInterface) {
        this.manageMenuViewInterface = manageMenuViewInterface;
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
     *
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
