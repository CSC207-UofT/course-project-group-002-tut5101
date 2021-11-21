package com.example.androidgui;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ServeDishActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        TextView header = findViewById(R.id.header);
        header.setText(R.string.serve_dish_header);
    }
}
