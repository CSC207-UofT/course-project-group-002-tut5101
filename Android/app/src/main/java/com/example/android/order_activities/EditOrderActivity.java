package com.example.android.order_activities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.R;
import constant.order_system.BuildOrderInfo;
import constant.order_system.OrderType;
import presenter.order_system.EditOrderPresenter;
import presenter.order_system.view_interfaces.EditOrderViewInterface;

import java.util.HashMap;
import java.util.Objects;

/**
 * Edits the existing dishes in the order
 */
public class EditOrderActivity extends AppCompatActivity implements EditOrderViewInterface {
    private HashMap<String, Integer> dishesOrdered;
    private HashMap<String, Double> dishPrices;

    private OrderType orderType;
    private String location;

    private EditOrderPresenter editOrderPresenter;

    private NumberPicker orderedDishesPicker;
    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);

        orderedDishesPicker = findViewById(R.id.orderedDishesPicker);
        orderedDishesPicker.setMinValue(0);

        editOrderPresenter = new EditOrderPresenter();
        editOrderPresenter.setEditOrderViewInterface(this);

        collectDishInformation();
        editOrderPresenter.collectDishes();

        editOrderPresenter.displayDishesOrdered();

    }

    /**
     * Collecting dish information.
     */
    @SuppressWarnings("unchecked")
    private void collectDishInformation(){
        Intent intent = getIntent();
        System.out.println(intent.getExtras());
        if (intent.hasExtra(BuildOrderInfo.DISHES.name())) {
            System.out.println("has Dishes");
            dishesOrdered = (HashMap<String, Integer>) intent.getSerializableExtra(BuildOrderInfo.DISHES.name());
        }
        else {
            dishesOrdered = new HashMap<>();
        }
        System.out.println("Edit Order Activity collect Dish Info");
        System.out.println(dishesOrdered);
        if (intent.hasExtra(BuildOrderInfo.ORDER_TYPE.name())) {
            orderType = intent.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
        }
        if (intent.hasExtra(BuildOrderInfo.LOCATION.name())) {
            location = Objects.requireNonNull(intent.getExtras()).getString(BuildOrderInfo.LOCATION.name());
        }
        if (intent.hasExtra(BuildOrderInfo.PRICES.name())) {
            System.out.println("Has prices");
            dishPrices = (HashMap<String, Double>) intent.getSerializableExtra(BuildOrderInfo.PRICES.name());
        }
        else {
            dishPrices = new HashMap<>();
        }
        System.out.println(dishPrices);
        editOrderPresenter.setDishesOrdered(dishesOrdered);
        editOrderPresenter.setDishPrices(dishPrices);
        editOrderPresenter.collectDishes();
    }

    /**
     * Display the ordered dishes
     * @param dishesOrderedList dishes ordered
     */
    @Override
    public void displayDishesOrdered(String[] dishesOrderedList) {
        LinearLayout orderedDishesLayout = findViewById(R.id.orderedDishesLayout);
        orderedDishesLayout.removeAllViews();
        for (String dishNameAndQuantity : dishesOrderedList) {
            TextView displayedDish = new TextView(this);
            displayedDish.setText(dishNameAndQuantity);
            orderedDishesLayout.addView(displayedDish);
        }
    }

    /**
     * Set the number of options to pick from
     * @param numDishes number of options
     */
    @Override
    public void setOrderedDishesPickerMax(int numDishes) {
        orderedDishesPicker.setMaxValue(numDishes);
    }

    /**
     * Set the ordered dishes options to edit
     * @param dishes dishes ordered
     */
    @Override
    public void setOrderedDishesPickerValues(String[] dishes) {
        orderedDishesPicker.setDisplayedValues(dishes);
    }

    /**
     * Get the dishes to be removed from the xml file and remove them from the current list of dishes
     * @param v the view on which the user has clicked
     */
    public void removeDish(View v) {
        int dishIndex = orderedDishesPicker.getValue();
        editOrderPresenter.removeOrderedDish(dishIndex);
    }

    /**
     * Update the dishes ordered
     * @param dishesOrdered the new dishes ordered
     */
    public void updateDishesOrdered(HashMap<String, Integer> dishesOrdered) {
        this.dishesOrdered = dishesOrdered;
    }

    /**
     * Switch back to the place order page, and send the information
     * @param v the view on which the user has clicked
     */
    public void returnToOrder(View v) {
        editOrderPresenter.updateDishesOrdered();

        Intent intent = new Intent(EditOrderActivity.this, PlaceOrderActivity.class);
        intent.putExtra(BuildOrderInfo.DISHES.name(), dishesOrdered);
        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);
        intent.putExtra(BuildOrderInfo.PRICES.name(), dishPrices);
        startActivity(intent);
    }

}