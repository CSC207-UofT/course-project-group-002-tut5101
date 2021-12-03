package com.example.androidgui.orderactivities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.ordersystem.BuildOrderInfo;
import constant.ordersystem.OrderType;
import presenter.customersystem.PlaceOrderPresenter;
import presenter.customersystem.PlaceOrderViewInterface;
import use_case.dishlist.DishList;

import java.util.HashMap;
/**
 * Class that corresponds to the activity_place_order xml and deals with selecting dishes for an order
 */

public class PlaceOrderActivity extends AppCompatActivity implements PlaceOrderViewInterface {

    // Information needed to place order
    private HashMap<String, Integer> dishesOrdered;
    private HashMap<String, Double> dishPrices;
    private OrderType orderType;
    private String location;

    // Displayed texts and number pickers
    private TextView errorMessage;

    private NumberPicker dishQuantityPicker;
    private NumberPicker dishNamePicker;
    private LinearLayout orderedDishesLayout;
    private PlaceOrderPresenter placeOrderPresenter;

    /**
     * Method that runs on creation of this class
     * @param savedInstanceState The saved state of this class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        placeOrderPresenter = new PlaceOrderPresenter();
        placeOrderPresenter.setPlaceOrderViewInterface(this);

        this.errorMessage = findViewById(R.id.errorMessage);
        this.orderedDishesLayout = findViewById(R.id.orderedDishesLayout);

        generateStartingInformation();
        collectDishInformation();

        placeOrderPresenter.displayDishesOrdered();
    }

    /**
     * generate attributes corresponding to user view
     */
    private void generateStartingInformation(){
        this.dishQuantityPicker = findViewById(R.id.dishQuantityPicker);
        this.dishQuantityPicker.setMinValue(1);
        this.dishQuantityPicker.setMaxValue(20);

        this.dishNamePicker = findViewById(R.id.dishNamePicker);
        this.dishNamePicker.setMinValue(0);

        placeOrderPresenter.numberOfDishesInMenu();
        placeOrderPresenter.allDishNames();

    }

    /**
     * collect information passed from last activity
     */
    @SuppressWarnings("unchecked")
    private void collectDishInformation(){
        Intent intent = getIntent();

        if (intent.hasExtra(BuildOrderInfo.DISHES.name())) {
            dishesOrdered = (HashMap<String, Integer>) intent.getSerializableExtra(BuildOrderInfo.DISHES.name());
        }
        else {
            dishesOrdered = new HashMap<>();
        }
        if (intent.hasExtra(BuildOrderInfo.ORDER_TYPE.name())) {
            orderType = intent.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
        }
        if (intent.hasExtra(BuildOrderInfo.LOCATION.name())) {
            location = intent.getExtras().getString(BuildOrderInfo.LOCATION.name());
        }
        if (intent.hasExtra(BuildOrderInfo.PRICES.name())) {
            dishPrices = (HashMap<String, Double>) intent.getSerializableExtra(BuildOrderInfo.PRICES.name());
        }
        else {
            dishPrices = new HashMap<>();
        }
        placeOrderPresenter.setDishesOrdered(dishesOrdered);
        placeOrderPresenter.setDishPrices(dishPrices);

    }

    /**
     * method called from the use case through interface to set the number of dish choices
     * @param size the number of dish choices
     */
    public void setDishNamePickerMaxValue(int size) {
        this.dishNamePicker.setMaxValue(size - 1);
    }

    /**
     * method called from the use case through interface to set the available dish names
     * @param dishNames the array of all dish names
     */
    public void setDisplayedDishNames(String[] dishNames) {
        dishNamePicker.setDisplayedValues(dishNames);
    }

    /**
     * Update dishes ordered
     * @param dishesOrdered new dishes ordered
     */
    @Override
    public void setDishesOrdered(HashMap<String, Integer> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }


    /**
     * Set dish prices
     * @param dishPrices prices of dishes ordered
     */
    @Override
    public void setDishPrices(HashMap<String, Double> dishPrices) {
        this.dishPrices = dishPrices;
    }

    /**
     * Method for order_dish button that runs on click
     * @param v the view on which the user has clicked
     */
    public void orderDish(View v) {
        int dishQuantity = dishQuantityPicker.getValue();
        int dishNameIndex = dishNamePicker.getValue();
        placeOrderPresenter.passDishesOrdered(dishNameIndex, dishQuantity);
    }


    /**
     * display dishes ordered in the ordered dishes
     * @param displayedText text to display
     */
    @Override
    public void displayDishesOrdered(String[] displayedText) {
        orderedDishesLayout.removeAllViews();
        for (String text : displayedText) {
            TextView displayedDish = new TextView(this);
            displayedDish.setText(text);
            orderedDishesLayout.addView(displayedDish);
        }
    }


    /**
     * method that runs on click of place_order button to collect all dishes in an array and then pass to the next
     * activity where dine in status and location is selected
     * @param v the view on which the user has clicked
     */
    public void placeOrder(View v) {

        placeOrderPresenter.runPlaceOrderInformation(orderType, location);

    }

    /**
     * show the order successfully placed view
     */
    public void orderSuccessfullyPlaced(){
        Intent intent = new Intent(PlaceOrderActivity.this, OrderSuccessfullyPlacedActivity.class);
        startActivity(intent);
    }

    /**
     * set the error message
     * @param message message to display
     */
    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }


    /**
     * Sends the information about order type, location, and dishes ordered to the edit order page to allow for changes
     * @param view the view on which the user has clicked
     */
    public void selectEditOrder(View view) {
        placeOrderPresenter.checkRunEditOrder();

    }

    /**
     * pass information to the next activity and run the edit order activity
     */
    @Override
    public void runEditOrder() {
        placeOrderPresenter.updateDishesOrdered();
        placeOrderPresenter.updateDishPrices();

        Intent intent = new Intent(PlaceOrderActivity.this, EditOrderActivity.class);

        if (!dishesOrdered.isEmpty()) {
            intent.putExtra(BuildOrderInfo.DISHES.name(), dishesOrdered);
        }
        if (orderType != null ){
            intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        }
        if (location != null) {
            intent.putExtra(BuildOrderInfo.LOCATION.name(), location);
        }
        if (!dishPrices.isEmpty()) {
            intent.putExtra(BuildOrderInfo.PRICES.name(), dishPrices);
        }
        startActivity(intent);
    }

}




