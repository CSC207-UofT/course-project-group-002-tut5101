package com.example.androidgui;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ServeDishActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff);
        TextView header = (TextView) findViewById(R.id.header);
        header.setText("Serve Dish System");
    }
}
