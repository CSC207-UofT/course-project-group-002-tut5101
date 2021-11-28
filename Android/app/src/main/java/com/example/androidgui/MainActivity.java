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
    public static OrderController orderController;
    public static InventoryManager inventoryManager;
    public static KitchenController kitchenController;
    public static LoginController loginController;
    public static ManagerController managerController;
    public static MenuController menuController;
    public static ReviewController reviewController;
    public static StaffController staffController;


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