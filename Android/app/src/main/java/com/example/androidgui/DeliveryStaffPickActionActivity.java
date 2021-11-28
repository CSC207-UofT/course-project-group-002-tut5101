package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DeliveryStaffPickActionActivity extends AppCompatActivity {
    private String id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverystaff_pick_action);
        TextView header = findViewById(R.id.header);
        header.setText(R.string.deliver_order_header);
        // Get id for further use
        Bundle b = getIntent().getExtras();
        if(b != null) {
            id = b.getString("id");
        }
    }

    // When the user selects to get the next order, try to get an order to be delivered.
    public void selectGetNextOrder(View v) {
        Intent intent = new Intent(DeliveryStaffPickActionActivity.this, DeliverOrderActivity.class);
        Bundle b = new Bundle();
        b.putString("id", this.id); //Your id
        b.putString("action", "GET_NEXT");
        intent.putExtras(b); //Put your id to next activity
        startActivity(intent);
    }

    // When the user selects to check the current order, show the current order to be delivered.
    public void seeCurrentOrder(View v) {
        Intent intent = new Intent(DeliveryStaffPickActionActivity.this, DeliverOrderActivity.class);
        Bundle b = new Bundle();
        b.putString("id", this.id); //Your id
        b.putString("action", "VIEW_CURRENT");
        intent.putExtras(b); //Put your id to next activity
        startActivity(intent);
    }

    // When selected Exit, return to login activity.
    public void selectExit(View v) {
        Intent intent = new Intent(DeliveryStaffPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}