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

    public static final KitchenFacade kf = new KitchenFacade();
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

//        UserList userList = new UserList();
//        userList.addUser(new Manager());
//        userList.addUser(new Customer("1", "James", "12345"));
//        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
//        userList.addUser(new ServingStaff("3", "Eve", "12345"));
//        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
//        userList.addUser(new InventoryStaff("5", "Frank", "12345"));
//        UserList.setContext(this);
//        UserList.setData(FileName.USER_FILE);
//
//        userList.savetoFile();

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