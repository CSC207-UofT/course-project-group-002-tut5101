package com.example.androidgui.kitchen_activities;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.order_system.OrderType;
import presenter.kitchen_system.KitchenFacade;
import presenter.kitchen_system.KitchenPresenter;
import presenter.kitchen_system.KitchenView;
import use_case.dish_list.DishList;
import use_case.kitchen.InventoryList;
import use_case.placeorder.PlaceOrder;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class KitchenActivity extends AppCompatActivity implements KitchenView, PropertyChangeListener {

    // TODO: improve the design here, try to make it not public.
    public static final KitchenFacade kf = new KitchenFacade();
    private KitchenPresenter kp;
    private KitchenAdapter adapter;
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


        //----------Initialization below, to be deleted when everything works---------------
        PlaceOrder po = new PlaceOrder();
        new DishList("menu.ser", this);
        new InventoryList("inventory.ser", this);
        try {
            po.placeOrder(OrderType.DINE_IN, new String[]{"Donut sandwich", "Cheetos sandwich"}, "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //----------------------------------------------------------------------------------

        kp = new KitchenPresenter(this);
        kp.checkOrderAvailable();

        dishesToDisplay = kp.exportDishes();
        adapter = new KitchenAdapter(this, R.layout.cook_dish_layout, dishesToDisplay, kp);
        list.setAdapter(adapter);
    }


    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        kp.checkOrderAvailable();
    }

    @Override
    public void renewDishes(ArrayList<String[]> displayDishes) {
       this.dishesToDisplay.clear();
       this.dishesToDisplay.addAll(displayDishes);
    }

    @Override
    public void updateListDisplay() {
        this.adapter.notifyDataSetChanged();
    }
}