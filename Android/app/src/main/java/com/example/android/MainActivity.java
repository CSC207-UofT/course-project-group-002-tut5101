package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.customer_activities.CustomerPickActionActivity;
import com.example.android.user_activities.LoginActivity;
import presenter.main_information.MainActivityPresenter;


/**
 * Main activity for this project.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Method that runs on creation of class
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
     *
     * @param v view.
     */
    public void selectCustomerPickAction(View v) {
        Intent intent = new Intent(MainActivity.this, CustomerPickActionActivity.class);
        startActivity(intent);
    }

    /**
     * Select staff login.
     *
     * @param v view.
     */
    public void selectLogin(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * generate information.
     */
    private void setInformation() {
        MainActivityPresenter presenter = new MainActivityPresenter();
        presenter.setContext(this);
        presenter.setData();
    }
}