package use_case.kitchen.boundary;

import java.util.HashMap;

/**
 * The output use_case.boundary for Kitchen presenter.
 */
public interface KitchenOutputBoundary {
    /**
     * Update the current dishes to be the potentially new orders.
     *
     * @param dishes the new dishes (order) to be cooked
     */
    void getNextOrder(HashMap<String, Integer> dishes);
}
