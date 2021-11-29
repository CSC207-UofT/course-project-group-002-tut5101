package com.example.androidgui;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import constant.orderSystem.BuildOrderInfo;
import constant.orderSystem.OrderType;

/**
 * If the order is dine in, records the table number
 * If the order is delivery, records the delivery address
 */
public class EnterLocationActivity extends AppCompatActivity {
    TextView askEnterAddressMessage;
    EditText enteredLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_location);

        askEnterAddressMessage = findViewById(R.id.askEnterAddressMessage);
        String enterLocationMessage = "Please enter the table number or delivery address below";
        askEnterAddressMessage.setText(enterLocationMessage);

        enteredLocation = findViewById(R.id.enteredLocation);

    }

    /**
     * Switch to the next activity when the "next" button is clicked
     * @param v the current view
     */
    public void next(View v) {
        String location = enteredLocation.getText().toString();
        System.out.println(location);

        Intent intent = new Intent(EnterLocationActivity.this, PlaceOrderActivity.class);
        Intent extras = getIntent();
        OrderType orderType = null;
        if (extras.hasExtra(BuildOrderInfo.ORDER_TYPE.name())) {
            orderType = extras.getParcelableExtra(BuildOrderInfo.ORDER_TYPE.name());
        }
        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), (Parcelable) orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);

        startActivity(intent);
    }

}