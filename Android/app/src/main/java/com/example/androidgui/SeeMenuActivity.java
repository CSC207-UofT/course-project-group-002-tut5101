package com.example.androidgui;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import constant.customerSystem.CustomerUIMessage;
import controller.menuSystem.MenuController;

public class SeeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_menu);

        TextView menuItems = (TextView) findViewById(R.id.menuItems);

        MenuController menuController = new MenuController();

        menuItems.setText(CustomerUIMessage.MENU_TITLE + menuController.dishesInMenuAsString());
    }
}