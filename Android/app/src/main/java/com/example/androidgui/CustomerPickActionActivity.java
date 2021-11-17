package com.example.androidgui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomerPickActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pick_action);

    }

    public void selectSeeMenu(View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, SeeMenuActivity.class);
        startActivity(intent);
    }

    public void selectPlaceOrder(View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, PlaceOrderActivity.class);
        startActivity(intent);
    }
}