package presenter.customersystem;

import java.util.HashMap;

public interface EditOrderViewInterface {
    void displayDishesOrdered(String[] dishesOrderedList);

    void setOrderedDishesPickerMax(int numDishes);

    void setOrderedDishesPickerValues(String[] dishes);

    void updateDishesOrdered(HashMap<String, Integer> dishesOrdered);
}
