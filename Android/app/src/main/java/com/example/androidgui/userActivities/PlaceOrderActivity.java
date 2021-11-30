package com.example.androidgui.userActivities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.MainActivity;
import com.example.androidgui.R;
import constant.orderSystem.BuildOrderInfo;
import constant.orderSystem.OrderType;
import use_case.boundary.output.MenuOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class that corresponds to the activity_place_order xml and deals with selecting dishes for an order
 */

public class PlaceOrderActivity extends AppCompatActivity implements MenuOutputBoundary {

    private TextView errorMessage;

    private NumberPicker dishQuantityPicker;
    private NumberPicker dishNamePicker;

    private LinearLayout orderedDishesLayout;

    private HashMap<String, Integer> dishesOrdered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        this.errorMessage = findViewById(R.id.errorMessage);

        this.dishesOrdered = new HashMap<>();
        this.orderedDishesLayout = findViewById(R.id.orderedDishesLayout);

        MainActivity.menuController.setMenuOutputBoundary(this);

        generateStartingInformation();


    }

    @SuppressWarnings("unchecked")
    private void generateStartingInformation(){
        this.dishQuantityPicker = findViewById(R.id.dishQuantityPicker);
        this.dishQuantityPicker.setMinValue(1);
        this.dishQuantityPicker.setMaxValue(20);

        this.dishNamePicker = findViewById(R.id.dishNamePicker);
        this.dishNamePicker.setMinValue(0);

        MainActivity.menuController.numberOfDishesInMenu();
        MainActivity.menuController.allDishNames();

        Intent intent = getIntent();
        if (intent.hasExtra(BuildOrderInfo.DISHES.name())) {
            dishesOrdered = (HashMap<String, Integer>) intent.getSerializableExtra(BuildOrderInfo.DISHES.name());
            displayDishesOrdered();
        }


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
        MainActivity.menuController.passDishesOrdered(dishNameIndex, dishQuantity);
    }

    /**
     * method called from the use case through interface to update the list of dishes ordered
     * @param dishName the name of dish ordered
     * @param dishQuantity the quantity of dish ordered
     */
    public void updateDishesOrdered(String dishName, int dishQuantity) {
        if (dishesOrdered.containsKey(dishName)) {
            Integer quantity = dishesOrdered.get(dishName);
            if (quantity != null){
                dishQuantity = quantity + dishQuantity;
            }

        }
        dishesOrdered.remove(dishName);
        dishesOrdered.put(dishName, dishQuantity);
        displayDishesOrdered();
    }

    private void displayDishesOrdered() {
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
        String [] dishes = collectDishes();

        Intent intent = getIntent();
        OrderType orderType = intent.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
        String location = intent.getStringExtra(BuildOrderInfo.LOCATION.name());

        try {
            MainActivity.orderController.runPlaceOrder(orderType, dishes, location);
            orderSuccessfullyPlaced();
        }
        catch (Exception e) {
            String message = "Error, please try again";
            errorMessage.setText(message);
            e.printStackTrace();
        }


    }

    private void orderSuccessfullyPlaced(){
        Intent intent = new Intent(PlaceOrderActivity.this, OrderSuccessfullyPlacedActivity.class);
        startActivity(intent);
    }

    private String[] collectDishes() {
        ArrayList<String> collectDishes = new ArrayList<>();
        for (String dishName : dishesOrdered.keySet()) {
            int count = 1;
            Integer quantity = dishesOrdered.get(dishName);
            if (quantity != null) {
                while (count <= quantity) {
                    collectDishes.add(dishName);
                    count += 1;
                }
            }
        }
        return collectDishes.toArray(new String[0]);
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
        if (dishesOrdered != null){
            intent.putExtra(BuildOrderInfo.DISHES.name(), dishesOrdered);
        }
        startActivity(intent);
    }

}




