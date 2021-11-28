package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DeliveryStaffPickActionActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverystaff_pick_action);
        TextView header = findViewById(R.id.header);
        header.setText(R.string.deliver_order_header);
    }

    // When the user selects to get the next order, try to get an order to be delivered.
    public void selectGetNextOrder(View v) {
        Intent intent = new Intent(DeliveryStaffPickActionActivity.this, DeliverOrderActivity.class);
        startActivity(intent);
    }

    // When the user selects to check the current order, show the current order to be delivered.
    public void seeCurrentOrder(View v) {
        Intent intent = new Intent(DeliveryStaffPickActionActivity.this, DeliverOrderActivity.class);
        startActivity(intent);
    }

    // When selected Exit, return to login activity.
    public void selectExit(View v) {
        Intent intent = new Intent(DeliveryStaffPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}