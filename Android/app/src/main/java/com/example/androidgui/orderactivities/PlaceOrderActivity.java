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
import controller.customersystem.PlaceOrderPresenter;
import controller.customersystem.PlaceOrderViewInterface;

import java.util.HashMap;
/**
 * Class that corresponds to the activity_place_order xml and deals with selecting dishes for an order
 */

public class PlaceOrderActivity extends AppCompatActivity implements PlaceOrderViewInterface {

    private HashMap<String, Integer> dishesOrdered;
    private OrderType orderType;
    private String location;


    private TextView errorMessage;

    private NumberPicker dishQuantityPicker;
    private NumberPicker dishNamePicker;

    private LinearLayout orderedDishesLayout;

    private PlaceOrderPresenter placeOrderPresenter;


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

        placeOrderPresenter.setDishesOrdered(dishesOrdered);
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
     * @param dishesOrdered dishes to display
     */
    public void displayDishesOrdered(HashMap<String, Integer> dishesOrdered) {
        orderedDishesLayout.removeAllViews();
        for (String dishName : dishesOrdered.keySet()) {
            TextView displayedDish = new TextView(this);
            String dishNameAndQuantity = dishName + " x " + dishesOrdered.get(dishName);
            displayedDish.setText(dishNameAndQuantity);
            orderedDishesLayout.addView(displayedDish);
        }
    }


    /**
     * method that runs on click of place_order button to collect all dishes in an array and then pass to the next
     * activity where dine in status and location is selected
     * @param v the view on which the user has clicked
     */
    public void placeOrder(View v) {
        Intent intent = getIntent();
        placeOrderPresenter.collectRunPlaceOrderInformation(intent);

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
        Intent intent = new Intent(PlaceOrderActivity.this, EditOrderActivity.class);

        passInformationToEditOrder();

        startActivity(intent);
    }

    /**
     * pass information to the next activity
     */
    private void passInformationToEditOrder() {
        placeOrderPresenter.updateDishesOrdered();

        Intent intent = new Intent(PlaceOrderActivity.this, EditOrderActivity.class);
        intent.putExtra(BuildOrderInfo.DISHES.name(), dishesOrdered);
        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);
        startActivity(intent);
    }

}




