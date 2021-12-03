package presenter.manager_system;

/**
 * View interface for managing menu activity.
 */
public interface ManageMenuViewInterface {

    /**
     *
     * @param dishName name of the dish
     */
    void getDish(String dishName);

    /**
     *
     * @param s array of string.
     */
    void gettingDishList(String[] s);
}
