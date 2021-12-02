package presenter.managersystem;

import use_case.boundary.output.ManageMenuOutputBoundary;
import use_case.dishlist.DishList;

/**
 * Presenter class for managing menu.
 */
public class ManageMenuPresenter implements ManageMenuOutputBoundary {
    ManageMenuViewInterface manageMenuViewInterface;
    private final DishList dishList;

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

    public void getDishList(){
        dishList.passDishesAsList();
    }

    @Override
    public void passingDishesAsList(String[] s) {
        manageMenuViewInterface.gettingDishList(s);
    }
}
