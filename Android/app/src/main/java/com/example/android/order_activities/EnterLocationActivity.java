package com.example.android.order_activities;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.R;
import constant.order_system.BuildOrderInfo;
import constant.order_system.OrderType;

/**
 * If the order is dine in, records the table number
 * If the order is delivery, records the delivery address
 */
public class EnterLocationActivity extends AppCompatActivity{
    private EditText enteredLocation;
    private OrderType orderType;


    /**
     * Method that runs on creation of class
     * @param savedInstanceState saved state of class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_location);

        enteredLocation = findViewById(R.id.enteredLocation);

        collectIntentExtras();
    }

    /**
     * Collect information passed through the intent
     */
    private void collectIntentExtras() {
        Intent extras = getIntent();
        if (extras.hasExtra(BuildOrderInfo.ORDER_TYPE.name())) {
            orderType = extras.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
        }
    }

    /**
     * Switch to the next activity when the "next" button is clicked and pass information to the next class
     * @param v the current view
     */
    public void next(View v) {
        String location = enteredLocation.getText().toString();

        Intent intent = new Intent(EnterLocationActivity.this, PlaceOrderActivity.class);

        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);

        startActivity(intent);
    }

}