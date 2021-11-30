package controller.customersystem;

import java.util.HashMap;

public interface PlaceOrderViewInterface {
    void displayDishesOrdered(HashMap<String, Integer> dishesOrdered);
    void orderSuccessfullyPlaced();
    void setErrorMessage(String message);
}
