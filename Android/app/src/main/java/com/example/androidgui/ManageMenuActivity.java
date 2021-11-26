package com.example.androidgui;

import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.menuSystem.MenuController;

public class ManageMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_menu);
        ScrollView menuItems = findViewById(R.id.menuItems);

        // Get the menu as text and add it to the scroll view
        TextView menuItemsText = new TextView(this);
        MenuController menuController = new MenuController();
        menuItemsText.setText(menuController.dishesInMenuAsString());

        // Add menu items to scroll view
        menuItems.addView(menuItemsText);

    }
}