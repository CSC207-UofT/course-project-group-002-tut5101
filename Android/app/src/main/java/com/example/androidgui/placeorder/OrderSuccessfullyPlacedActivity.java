package com.example.androidgui.placeorder;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.CustomerPickActionActivity;
import com.example.androidgui.R;

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