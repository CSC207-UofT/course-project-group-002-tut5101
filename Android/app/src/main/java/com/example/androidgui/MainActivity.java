package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.useractivities.CustomerPickActionActivity;
import com.example.androidgui.useractivities.LoginActivity;
import controller.facade.KitchenFacade;
import controller.customersystem.OrderController;
import controller.inventorysystem.InventoryManager;
import controller.kitchensystem.KitchenController;
import controller.loginsystem.LoginController;
import controller.managersystem.ManagerController;
import controller.menusystem.MenuController;
import controller.reviewsystem.ReviewController;
import controller.staffsystem.StaffController;

public class MainActivity extends AppCompatActivity {
    public static OrderController orderController = new OrderController();
    public static InventoryManager inventoryManager = new InventoryManager();
    public static KitchenFacade kitchenFacade = new KitchenFacade();
    public static KitchenController kitchenController = kitchenFacade.createKitchen();
    public static LoginController loginController;
    public static ManagerController managerController = new ManagerController();
    public static MenuController menuController = new MenuController();
    public static ReviewController reviewController = new ReviewController();
    public static StaffController staffController = new StaffController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

    public void selectCustomerPickAction(View v) {
        Intent intent = new Intent(MainActivity.this, CustomerPickActionActivity.class);
        startActivity(intent);
    }

    public void selectLogin(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}