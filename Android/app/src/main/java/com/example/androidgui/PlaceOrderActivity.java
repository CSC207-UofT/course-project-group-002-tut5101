package com.example.androidgui;

import android.widget.NumberPicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class PlaceOrderActivity extends AppCompatActivity {

    NumberPicker dishQuantityPicker;
    NumberPicker dishNamePicker;

    HashMap<String, Integer> dishesOrdered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);


        // get dish quantity
        dishQuantityPicker = findViewById(R.id.dishQuantityPicker);
        dishQuantityPicker.setMinValue(0);
        dishQuantityPicker.setMaxValue(20);

        dishNamePicker = findViewById(R.id.dishNamePicker);
        dishNamePicker.setMinValue(0);
        dishNamePicker.setMaxValue(10); //TODO: Change 10 to number of dishes in menu
        // dishNamePicker.setDisplayedValues(); TODO: Display each dish name from List
        /**
         * 1. select dish
         * 2. select quantity
         * 3. click 'order dish' button
         * 4. method runs to get current dish and quantity and add them to ordered dishes
         */

        }
        public void selectPlaceOrder() {
            int dishQuantity = dishQuantityPicker.getValue();
            // String dishName = dishNamePicker.getValue(); TODO: get dish from menu at index value
            //TODO: Add this dish to the dishesOrdered

        }

        //TODO: Display the dishes ordered




}




