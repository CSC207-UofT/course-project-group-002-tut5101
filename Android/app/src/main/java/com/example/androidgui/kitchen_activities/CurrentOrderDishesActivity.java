package com.example.androidgui.kitchen_activities;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.kitchen_system.KitchenFacade;
import presenter.kitchen_system.KitchenPresenter;
import presenter.kitchen_system.KitchenView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class CurrentOrderDishesActivity extends AppCompatActivity implements KitchenView, PropertyChangeListener {

    private KitchenPresenter kp;
    private CurrentOrderDishesAdapter adapter;
    private ArrayList<String[]> dishesToDisplay;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        ListView list = findViewById(R.id.dishToCook);


//        //----------Initialization below, to be deleted when everything works---------------
//        PlaceOrder po = new PlaceOrder();
//        new DishList("menu.ser");
//        new InventoryList("inventory.ser");
//        try {
//            po.placeOrder(OrderType.DINE_IN, new String[]{"Donut sandwich", "Cheetos sandwich"}, "3");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //----------------------------------------------------------------------------------

        kp = new KitchenPresenter(this);
        kp.checkOrderAvailable();

        dishesToDisplay = kp.exportDishes();
        adapter = new CurrentOrderDishesAdapter(this, R.layout.cook_dish_layout, dishesToDisplay, kp);
        list.setAdapter(adapter);

    }

    /**
     * Listen to the change in Order and update the display if needed.
     * @param propertyChangeEvent
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
       this.dishesToDisplay.clear();
       this.dishesToDisplay.addAll(displayDishes);
    }

    /**
     * Update the display by notifying the adapter changes have been made.
     */
    @Override
    public void updateListDisplay() {
        this.adapter.notifyDataSetChanged();
    }
}