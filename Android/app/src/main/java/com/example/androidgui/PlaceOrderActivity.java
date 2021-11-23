package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import constant.orderSystem.BuildOrderInfo;
import constant.orderSystem.OrderType;
import use_case.boundary.output.MenuOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaceOrderActivity extends AppCompatActivity implements MenuOutputBoundary {


    NumberPicker dishQuantityPicker;
    NumberPicker dishNamePicker;

    LinearLayout orderedDishesLayout;

    HashMap<String, Integer> dishesOrdered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        dishesOrdered = new HashMap<>();
        orderedDishesLayout = findViewById(R.id.orderedDishesLayout);

        MainActivity.menuController.setMenuOutputBoundary(this);


        // get dish quantity
        dishQuantityPicker = findViewById(R.id.dishQuantityPicker);
        dishQuantityPicker.setMinValue(1);
        dishQuantityPicker.setMaxValue(20);

        dishNamePicker = findViewById(R.id.dishNamePicker);
        dishNamePicker.setMinValue(0);

        MainActivity.menuController.numberOfDishesInMenu();
        MainActivity.menuController.allDishNames();
        /**
         * 1. select dish
         * 2. select quantity
         * 3. click 'order dish' button
         * 4. method runs to get current dish and quantity and add them to ordered dishes
         */

        }

    /**
     * method called from the use case through interface to set the number of dish choices
     * @param size the number of dish choices
     */
    public void setDishNamePickerMaxValue(int size) {
        dishNamePicker.setMaxValue(size);
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
            int quantity = dishesOrdered.get(dishName);
            dishQuantity = quantity + dishQuantity;

        }
        dishesOrdered.put(dishName, dishQuantity);
        displayDishesOrdered();
    }

    public void displayDishesOrdered() {
        for (String dishName : dishesOrdered.keySet()) {
            TextView displayedDish = new TextView(this);
            String dishNameAndQuantity = dishName = " x " + dishesOrdered.get(dishName);
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

        Bundle extras = getIntent().getExtras();
        String orderType = extras.getString(BuildOrderInfo.ORDER_TYPE.name());
        String location = extras.getString(BuildOrderInfo.LOCATION.name());
        boolean dineInStatus = orderType.equals(OrderType.DINE_IN.name());

        try {
            MainActivity.orderController.runPlaceOrder(dineInStatus, dishes, location);
        }
        catch (Exception e) {
            //TODO: Handle exception
        }

    }

    private String[] collectDishes() {
        ArrayList<String> collectDishes = new ArrayList<String>();
        for (String dishName : dishesOrdered.keySet()) {
            int count = 1;
            while (count <= dishesOrdered.get(dishName)) {
                collectDishes.add(dishName);
                count += 1;
            }
        }
        String[] dishes = collectDishes.toArray(new String[0]);
        return dishes;
    }


    public void selectEditOrder(View view) {
        Intent intent = new Intent(PlaceOrderActivity.this, EditOrderActivity.class);
        startActivity(intent);
    }
}




