package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.customerSystem.OrderController;
import controller.inventorySystem.InventoryManager;
import controller.kitchenSystem.KitchenController;
import controller.loginSystem.LoginController;
import controller.managerSystem.ManagerController;
import controller.menuSystem.MenuController;
import controller.reviewSystem.ReviewController;
import controller.staffSystem.StaffController;

public class MainActivity extends AppCompatActivity {
    public static OrderController orderController = new OrderController();
    public static InventoryManager inventoryManager = new InventoryManager();
    public static KitchenController kitchenController = new KitchenController();
    public static LoginController loginController;
    public static ManagerController managerController = new ManagerController();
    public static MenuController menuController = new MenuController();
    public static ReviewController reviewController = new ReviewController();
    public static StaffController staffController = new StaffController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        orderController = new OrderController();
        inventoryManager = new InventoryManager();
        kitchenController = new KitchenController();
//        loginController = new LoginController();
        managerController = new ManagerController();
        menuController = new MenuController();
        reviewController = new ReviewController();
        staffController = new StaffController();

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