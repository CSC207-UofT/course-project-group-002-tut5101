package com.example.androidgui;

import android.view.View;
import android.widget.NumberPicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.customerSystem.OrderController;
import controller.menuSystem.MenuController;
import use_case.boundary.output.MenuOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

public class PlaceOrderActivity extends AppCompatActivity implements MenuOutputBoundary {
    MenuController menuController;
    OrderController orderController;

    NumberPicker dishQuantityPicker;
    NumberPicker dishNamePicker;

    HashMap<String, Integer> dishesOrdered;

    public PlaceOrderActivity() {
        menuController = new MenuController();
        orderController = new OrderController();
        dishesOrdered = new HashMap<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);


        // get dish quantity
        dishQuantityPicker = findViewById(R.id.dishQuantityPicker);
        dishQuantityPicker.setMinValue(1);
        dishQuantityPicker.setMaxValue(20);

        dishNamePicker = findViewById(R.id.dishNamePicker);
        dishNamePicker.setMinValue(0);

        menuController.numberOfDishesInMenu(this);
        menuController.allDishNames(this);
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
        menuController.passDishesOrdered(this, dishNameIndex, dishQuantity);
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
    }

        //TODO: Display the dishes ordered

    /**
     * method that runs on click of place_order button to collect all dishes in an array and then pass to the next
     * activity where dine in status and location is selected
     * @param v the view on which the user has clicked
     */
    public void placeOrder(View v) {
        ArrayList<String> collectDishes = new ArrayList<String>();
        for (String dishName : dishesOrdered.keySet()) {
            int count = 0;
            while (count <= dishesOrdered.get(dishName)) {
                collectDishes.add(dishName);
            }
        }
        String[] dishes = collectDishes.toArray(new String[collectDishes.size()]);
        // TODO: Pass the dishes onto the page where select dine in or takeout and enter address
    }


}




