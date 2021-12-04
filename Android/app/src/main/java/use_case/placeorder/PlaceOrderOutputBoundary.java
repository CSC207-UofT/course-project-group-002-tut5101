package use_case.placeorder;

public interface PlaceOrderOutputBoundary {

    void updateDishesOrdered(String dishName, int dishQuantity);

    void addDishPrices(String dishName, double price);
}
