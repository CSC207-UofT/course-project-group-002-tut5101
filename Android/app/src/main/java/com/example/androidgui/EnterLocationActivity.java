package com.example.androidgui;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import constant.orderSystem.BuildOrderInfo;

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

    public void next() {
        String location = enteredLocation.getText().toString();

        Intent intent = new Intent(EnterLocationActivity.this, PlaceOrderActivity.class);
        Bundle extras = getIntent().getExtras();
        String orderType = extras.getString(BuildOrderInfo.ORDER_TYPE.name());

        intent.putExtra(BuildOrderInfo.ORDER_TYPE.name(), orderType);
        intent.putExtra(BuildOrderInfo.LOCATION.name(), location);

        startActivity(intent);
    }

}