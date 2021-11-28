package com.example.androidgui;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class SeeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_menu);

        // Get the menu as text and add it to the scroll view
        TextView menuItemsText = new TextView(this);
        menuItemsText.setText(MainActivity.menuController.dishesInMenuAsString());

        LinearLayout menuItems = findViewById(R.id.menuItemsLayout);
        menuItems.addView(menuItemsText);


        // Add menu items to scroll view;
    }


}