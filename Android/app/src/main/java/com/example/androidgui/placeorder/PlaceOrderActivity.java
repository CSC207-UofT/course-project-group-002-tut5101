package com.example.androidgui.placeorder;

import android.content.Intent;
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

    TextView errorMessage;

    NumberPicker dishQuantityPicker;
    NumberPicker dishNamePicker;

    LinearLayout orderedDishesLayout;

    HashMap<String, Integer> dishesOrdered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        errorMessage = findViewById(R.id.errorMessage);

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

        Bundle extras = getIntent().getExtras();
        String orderType = extras.getString(BuildOrderInfo.ORDER_TYPE.name());
        String location = extras.getString(BuildOrderInfo.LOCATION.name());
        boolean dineInStatus = orderType.equals(OrderType.DINE_IN.name());

        try {
            MainActivity.orderController.runPlaceOrder(dineInStatus, dishes, location);
        }
        catch (Exception e) {
            String message = "Error, please try again";
            errorMessage.setText(message);
        }

    }

    private String[] collectDishes() {
        ArrayList<String> collectDishes = new ArrayList<>();
        for (String dishName : dishesOrdered.keySet()) {
            int count = 1;
            while (count <= dishesOrdered.get(dishName)) {
                collectDishes.add(dishName);
                count += 1;
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
        Bundle extras = getIntent().getExtras();
        String orderType = extras.getString(BuildOrderInfo.ORDER_TYPE.name());
        String location = extras.getString(BuildOrderInfo.LOCATION.name());

        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);
        intent.putExtra(BuildOrderInfo.DISHES.name(), dishesOrdered);
        startActivity(intent);
    }
}




