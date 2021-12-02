package presenter.managersystem;

/**
 * Presenter class for managing menu.
 */
public class ManageMenuPresenter {
    ManageMenuViewInterface manageMenuViewInterface;

    public ManageMenuPresenter(){}

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
}
