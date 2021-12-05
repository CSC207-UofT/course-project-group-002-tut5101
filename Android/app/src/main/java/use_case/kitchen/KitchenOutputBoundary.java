package use_case.kitchen;

import java.util.HashMap;

public interface KitchenOutputBoundary {

    void getNextOrder(HashMap<String, Integer> dishes);
}
