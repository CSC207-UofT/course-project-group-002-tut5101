package com.example.androidgui.kitchen_activities;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.file_system.FileName;
import constant.order_system.OrderType;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import entity.user.User;
import presenter.kitchen_system.KitchenFacade;
import presenter.kitchen_system.KitchenPresenter;
import presenter.kitchen_system.KitchenView;
import use_case.dish_list.DishList;
import use_case.kitchen.InventoryList;
import use_case.placeorder.PlaceOrder;
import use_case.user_list.UserList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class KitchenActivity extends AppCompatActivity implements KitchenView, PropertyChangeListener {

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
//        ListView list = findViewById(R.id.dishToCook);
//
//
////        //----------Initialization below, to be deleted when everything works---------------
////        PlaceOrder po = new PlaceOrder();
////        new DishList("menu.ser");
////        new InventoryList("inventory.ser");
////        try {
////            po.placeOrder(OrderType.DINE_IN, new String[]{"Donut sandwich", "Cheetos sandwich"}, "3");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        //----------------------------------------------------------------------------------
//
//        kp = new KitchenPresenter(this);
//        kp.checkOrderAvailable();
//
//        dishesToDisplay = kp.exportDishes();
//        adapter = new KitchenAdapter(this, R.layout.cook_dish_layout, dishesToDisplay, kp);
//        list.setAdapter(adapter);

        UserList userList = new UserList();
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
        userList.addUser(new ServingStaff("3", "Eve", "12345"));
        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
        userList.addUser(new InventoryStaff("5", "Frank", "12345"));
        UserList.setContext(this);
        UserList.setData(FileName.USER_FILE);

        userList.savetoFile();

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