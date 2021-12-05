package use_case.dish_list;

public interface PlaceOrderMenuOutputBoundary {
    void setDishNamePickerMaxValue(int size);

    void setDisplayedDishNames(String[] dishNames);
}
