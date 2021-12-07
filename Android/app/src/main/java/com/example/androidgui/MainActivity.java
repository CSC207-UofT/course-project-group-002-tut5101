package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.customer_activities.CustomerPickActionActivity;
import com.example.androidgui.general_activity.LoginActivity;
import presenter.main_information.MainActivityPresenter;


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