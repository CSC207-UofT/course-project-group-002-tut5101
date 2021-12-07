package use_case.dish_list.boundaries;

/**
 * The output use_case.boundary for ManageMenu presenter.
 */

public interface ManageMenuOutputBoundary {
    /**
     * passing dishList as array.
     *
     * @param s array of string.
     */
    void passingDishesAsList(String[] s);
}
