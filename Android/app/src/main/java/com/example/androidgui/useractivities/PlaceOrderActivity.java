package com.example.androidgui.useractivities;

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
import controller.menusystem.DisplayDishesViewInterface;
import controller.menusystem.MenuPresenter;

import java.util.HashMap;
/**
 * Class that corresponds to the activity_place_order xml and deals with selecting dishes for an order
 */

public class PlaceOrderActivity extends AppCompatActivity implements PlaceOrderViewInterface, DisplayDishesViewInterface {

    private TextView errorMessage;

    private NumberPicker dishQuantityPicker;
    private NumberPicker dishNamePicker;

    private LinearLayout orderedDishesLayout;

    private PlaceOrderPresenter placeOrderPresenter;
    private MenuPresenter menuPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        placeOrderPresenter = new PlaceOrderPresenter();
        placeOrderPresenter.setPlaceOrderViewInterface(this);

        menuPresenter = new MenuPresenter();
        menuPresenter.setDisplayDishesViewInterface(this);

        this.errorMessage = findViewById(R.id.errorMessage);

        this.orderedDishesLayout = findViewById(R.id.orderedDishesLayout);

        generateStartingInformation();

    }

    private void generateStartingInformation(){
        this.dishQuantityPicker = findViewById(R.id.dishQuantityPicker);
        this.dishQuantityPicker.setMinValue(1);
        this.dishQuantityPicker.setMaxValue(20);

        this.dishNamePicker = findViewById(R.id.dishNamePicker);
        this.dishNamePicker.setMinValue(0);

        menuPresenter.numberOfDishesInMenu();
        menuPresenter.allDishNames();

        Intent intent = getIntent();
        placeOrderPresenter.checkIntentDishes(intent);

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
     * Method for order_dish button that runs on click
     * @param v the view on which the user has clicked
     */
    public void orderDish(View v) {
        int dishQuantity = dishQuantityPicker.getValue();
        int dishNameIndex = dishNamePicker.getValue();
        menuPresenter.passDishesOrdered(dishNameIndex, dishQuantity);
    }


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

    public void orderSuccessfullyPlaced(){
        Intent intent = new Intent(PlaceOrderActivity.this, OrderSuccessfullyPlacedActivity.class);
        startActivity(intent);
    }

    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }


    /**
     * Sends the information about order type, location, and dishes ordered to the edit order page to allow for changes
     * @param view the view on which the user has clicked
     */
    public void selectEditOrder(View view) {
        Intent intent = new Intent(PlaceOrderActivity.this, EditOrderActivity.class);
        Intent extras = getIntent();
        OrderType orderType = null;
        String location = null;
        if (extras.hasExtra(BuildOrderInfo.ORDER_TYPE.name())) {
            orderType = extras.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
        }
        if (extras.hasExtra(BuildOrderInfo.LOCATION.name())) {
            location = extras.getExtras().getString(BuildOrderInfo.LOCATION.name());
        }
        if (orderType != null) {
            intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        }
        if (location != null){
            intent.putExtra(BuildOrderInfo.LOCATION.name(), location);
        }
        if (placeOrderPresenter != null){
            intent.putExtra("Place Order Presenter", (Parcelable) placeOrderPresenter);
        }
        startActivity(intent);
    }

}




