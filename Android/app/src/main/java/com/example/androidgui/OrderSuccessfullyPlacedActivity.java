package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OrderSuccessfullyPlacedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_successfully_placed);
    }

    public void returnToCustomerPickAction(View v) {
        Intent intent = new Intent(OrderSuccessfullyPlacedActivity.this, CustomerPickActionActivity.class);
        startActivity(intent);
    }
}