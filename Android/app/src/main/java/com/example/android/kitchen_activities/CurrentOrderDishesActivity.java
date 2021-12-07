package com.example.android.kitchen_activities;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import com.example.android.order_activities.PlaceOrderActivity;
import presenter.kitchen_system.CookDishPresenter;
import presenter.kitchen_system.CookDishView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class CurrentOrderDishesActivity extends AppCompatActivity implements CookDishView, PropertyChangeListener {

    private CookDishPresenter kp;
    private CurrentOrderDishesAdapter adapter;
    private ArrayList<String[]> dishesToDisplay;

    /**
     * Activity basic function.
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        PlaceOrderActivity.addObserver(this);

        ListView list = findViewById(R.id.dishToCook);

        kp = new CookDishPresenter();
        kp.setView(this);
        kp.checkOrderAvailable();
        dishesToDisplay = kp.exportDishes();

        adapter = new CurrentOrderDishesAdapter(this, R.layout.cook_dish_layout, dishesToDisplay, kp);
        list.setAdapter(adapter);

    }

    /**
     * Listen to the change in Order and update the display if needed.
     * @param propertyChangeEvent A propertyChange Event
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        kp.checkOrderAvailable();
    }

    /**
     * Update the current dishes to display by mutating the arraylist that holds all display info.
     * @param displayDishes the updated array list of dish infos.
     */
    @Override
    public void renewDishes(ArrayList<String[]> displayDishes) {
       dishesToDisplay.clear();
       dishesToDisplay.addAll(displayDishes);
    }

    /**
     * Update the display by notifying the adapter changes have been made.
     */
    @Override
    public void updateListDisplay() {
        this.adapter.notifyDataSetChanged();
    }

    /**
     * Showing toast information on the screen.
     */
    @Override
    public void createToast(String message, boolean shortDisplay) {
        if (shortDisplay) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}