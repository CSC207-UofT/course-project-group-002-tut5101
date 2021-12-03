package presenter.order_system;

import java.util.HashMap;

public interface PlaceOrderViewInterface {
    void displayDishesOrdered(String[] displayedText);
    void orderSuccessfullyPlaced();
    void setErrorMessage(String message);


    void setDishesOrdered(HashMap<String, Integer> dishesOrdered);
    void setDishPrices(HashMap<String, Double> dishPrices);

    void runEditOrder();
}
