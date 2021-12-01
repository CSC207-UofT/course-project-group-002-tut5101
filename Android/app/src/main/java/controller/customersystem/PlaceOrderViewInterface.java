package controller.customersystem;

import java.util.HashMap;

public interface PlaceOrderViewInterface {
    void displayDishesOrdered(String[] displayedText);
    void orderSuccessfullyPlaced();
    void setErrorMessage(String message);

    void setDishNamePickerMaxValue(int size);
    void setDisplayedDishNames(String[] dishNames);

    void setDishesOrdered(HashMap<String, Integer> dishesOrdered);
}
