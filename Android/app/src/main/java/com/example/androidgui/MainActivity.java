package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.user_activities.CustomerPickActionActivity;
import com.example.androidgui.user_activities.LoginActivity;
import constant.file_system.FileName;
import entity.inventory.HasExpiryDate;
import entity.inventory.HasFreshness;
import presenter.main_information.MainActivityPresenter;
import use_case.kitchen.InventoryList;

/**
 * Main activity for this project.
 */
public class MainActivity extends AppCompatActivity {

    /**
     *
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