package com.example.androidgui.userActivities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.androidgui.MainActivity;
import com.example.androidgui.R;

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
        Intent intent = new Intent(CustomerPickActionActivity.this, SelectDineInTakeOutActivity.class);
        startActivity(intent);
    }

    public void selectExit(View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}