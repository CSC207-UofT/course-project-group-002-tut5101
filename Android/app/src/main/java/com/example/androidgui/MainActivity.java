package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.user_activities.CustomerPickActionActivity;
import com.example.androidgui.user_activities.LoginActivity;
import presenter.main_information.MainActivityPresenter;

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
        generateInformation();
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
    private void generateInformation(){
        MainActivityPresenter presenter = new MainActivityPresenter(this);
        presenter.useCaseDataGenerate();
    }


}