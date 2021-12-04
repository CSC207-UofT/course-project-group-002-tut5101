package com.example.androidgui.order_activities;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import com.example.androidgui.user_activities.CustomerPickActionActivity;

/**
 * Activity when order is successfully placed.
 */
public class OrderSuccessfullyPlacedActivity extends AppCompatActivity {

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_successfully_placed);
    }

    /**
     * return to picking action page.
     *
     * @param v view.
     */
    public void returnToCustomerPickAction(View v) {
        Intent intent = new Intent(OrderSuccessfullyPlacedActivity.this, CustomerPickActionActivity.class);
        startActivity(intent);
    }
}