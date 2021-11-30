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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Edits the existing dishes in the order
 */
public class EditOrderActivity extends AppCompatActivity {
    private OrderType orderType;
    private String location;
    private HashMap<String, Integer> dishesOrdered;

    private NumberPicker orderedDishesPicker;
    private ArrayList<String> collectedDishes;

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
        Intent intent = getIntent();
        if (intent.hasExtra(BuildOrderInfo.ORDER_TYPE.name())) {
            orderType = intent.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
        }
        if (intent.hasExtra(BuildOrderInfo.LOCATION.name())) {
            location = intent.getExtras().getString(BuildOrderInfo.LOCATION.name());
        }
        if (intent.hasExtra(BuildOrderInfo.DISHES.name())) {
            dishesOrdered = (HashMap<String, Integer>) intent.getSerializableExtra(BuildOrderInfo.DISHES.name());
        }

    }


    private void displayDishesOrdered() {
        LinearLayout orderedDishesLayout = findViewById(R.id.orderedDishesLayout);
        orderedDishesLayout.removeAllViews();
        for (String dishNameAndQuantity : collectedDishes) {
            TextView displayedDish = new TextView(this);
            displayedDish.setText(dishNameAndQuantity);
            orderedDishesLayout.addView(displayedDish);
        }
    }

    private void collectDishes() {
        orderedDishesPicker.setMinValue(0);
        collectedDishes = new ArrayList<>();
        String dishNameAndQuantity;
        int maxValue = 0;
        if (dishesOrdered != null) {
            for (String dishName : dishesOrdered.keySet()) {
                dishNameAndQuantity = dishName + " x " + dishesOrdered.get(dishName);
                collectedDishes.add(dishNameAndQuantity);
                maxValue += 1;
            }
            orderedDishesPicker.setMaxValue(maxValue - 1);
            orderedDishesPicker.setDisplayedValues(collectedDishes.toArray(new String[0]));
        }
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

        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);
        intent.putExtra(BuildOrderInfo.DISHES.name(), dishesOrdered);
        startActivity(intent);

    }
}