package use_case.boundary.output;

public interface MenuOutputBoundary {
    void setDishNamePickerMaxValue(int size);

    void setDisplayedDishNames(String[] dishNames);

    void updateDishesOrdered(String dishName, int dishQuantity);
}
