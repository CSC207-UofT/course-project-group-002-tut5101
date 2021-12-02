package use_case.placeorder;

public interface PlaceOrderOutputBoundary {
    void setDishNamePickerMaxValue(int size);

    void setDisplayedDishNames(String[] dishNames);

    void updateDishesOrdered(String dishName, int dishQuantity);

    void addDishPrices(String dishName, double price);
}
