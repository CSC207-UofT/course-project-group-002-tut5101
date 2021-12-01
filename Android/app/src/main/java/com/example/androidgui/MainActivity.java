package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.useractivities.CustomerPickActionActivity;
import com.example.androidgui.useractivities.LoginActivity;
import presenter.kitchensystem.KitchenFacade;
import presenter.inventorysystem.InventoryManager;
import presenter.kitchensystem.KitchenController;
import presenter.loginsystem.LoginController;
import presenter.managersystem.ManagerController;
import presenter.menusystem.MenuPresenter;
import presenter.reviewsystem.ReviewController;
import presenter.staffsystem.StaffController;

public class MainActivity extends AppCompatActivity {
    public static InventoryManager inventoryManager = new InventoryManager();
    public static final KitchenFacade kitchenFacade = new KitchenFacade();
    public static KitchenController kitchenController = kitchenFacade.createKitchen();
    public static LoginController loginController;
    public static ManagerController managerController = new ManagerController();
    public static final MenuPresenter menuController = new MenuPresenter();
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