package com.example.androidgui.placeorder;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.orderSystem.BuildOrderInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Edits the existing dishes in the order
 */
public class EditOrderActivity extends AppCompatActivity {
    String orderType;
    String location;
    HashMap<String, Integer> dishesOrdered;

    NumberPicker orderedDishesPicker;
    ArrayList<String> collectedDishes;
    LinearLayout orderedDishesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);

        collectExtraInformation();

        orderedDishesPicker = findViewById(R.id.orderedDishesPicker);
        collectDishes();

        displayDishesOrdered();

    }

    @SuppressWarnings("unchecked")
    private void collectExtraInformation(){
        Bundle extras = getIntent().getExtras();
        orderType = extras.getString(BuildOrderInfo.ORDER_TYPE.name());
        location = extras.getString(BuildOrderInfo.LOCATION.name());
        dishesOrdered = (HashMap<String, Integer>) extras.getSerializable(BuildOrderInfo.DISHES.name());
    }


    private void displayDishesOrdered() {
        for (String dishNameAndQuantity : collectedDishes) {
            TextView displayedDish = new TextView(this);
            displayedDish.setText(dishNameAndQuantity);
            orderedDishesLayout.addView(displayedDish);
        }
    }

    private void collectDishes() {
        collectedDishes = new ArrayList<>();
        String dishNameAndQuantity;
        for (String dishName : dishesOrdered.keySet()) {
            dishNameAndQuantity = dishName + " x " + dishesOrdered.get(dishName);
            collectedDishes.add(dishNameAndQuantity);
        }
        orderedDishesPicker.setDisplayedValues(collectedDishes.toArray(new String[0]));
    }

    /**
     * Get the dishes to be removed from the xml file and remove them from the current list of dishes
     * @param v the view on which the user has clicked
     */
    public void removeDish(View v) {
        int dishIndex = orderedDishesPicker.getValue();
        String dishName = collectedDishes.get(dishIndex).split(" x ")[0];
        dishesOrdered.remove(dishName);
        collectedDishes.remove(dishIndex);
        collectDishes();
        displayDishesOrdered();
    }

    /**
     * Switch back to the place order page, and send the information
     * @param v the view on which the user has clicked
     */
    public void returnToOrder(View v) {
        Intent intent = new Intent(EditOrderActivity.this, PlaceOrderActivity.class);

        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);
        intent.putExtra(BuildOrderInfo.DISHES.name(), dishesOrdered);
        startActivity(intent);

    }
}