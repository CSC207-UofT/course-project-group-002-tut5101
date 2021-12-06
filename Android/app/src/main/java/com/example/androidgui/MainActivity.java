package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.user_activities.CustomerPickActionActivity;
import com.example.androidgui.user_activities.LoginActivity;
import constant.file_system.FileName;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.HasExpiryDate;
import entity.inventory.HasFreshness;
import entity.inventory.Inventory;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import entity.review.Review;
import presenter.main_information.MainActivityPresenter;
import use_case.dish_list.DishList;
import use_case.kitchen.InventoryList;
import use_case.review.ReviewList;
import use_case.user_list.UserList;

/**
 * Main activity for this project.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Method that runs on creation of class
     * @param savedInstanceState fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setInformation();
    }

    /**
     * Selected customer action.
     * @param v view.
     */
    public void selectCustomerPickAction(View v) {
        Intent intent = new Intent(MainActivity.this, CustomerPickActionActivity.class);
        startActivity(intent);
    }

    /**
     * Select staff login.
     * @param v view.
     */
    public void selectLogin(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * generate information.
     */
    private void setInformation(){
        MainActivityPresenter presenter = new MainActivityPresenter();
        presenter.setContext(this);
        presenter.setData();
    }


}