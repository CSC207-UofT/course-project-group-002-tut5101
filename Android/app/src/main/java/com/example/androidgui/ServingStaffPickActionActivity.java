package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ServingStaffPickActionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servingstaff_pick_action);
        TextView header = findViewById(R.id.header);
        header.setText(R.string.serve_dish_header);
    }

    // When the user selects to get the next dish, try to get a dish to be delivered.
    public void selectGetNextDish(View v) {
        Intent intent = new Intent(ServingStaffPickActionActivity.this, ServeDishActivity.class);
        startActivity(intent);
    }

    // When the user selects to check the current dish, show the current dish to be served.
    public void seeCurrentDish(View v) {
        Intent intent = new Intent(ServingStaffPickActionActivity.this, ServeDishActivity.class);
        startActivity(intent);
    }

    // When selected Exit, return to login activity.
    public void selectExit(View v) {
        Intent intent = new Intent(ServingStaffPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
