package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class InventoryStarterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_starter);
    }

    public void AddInventory(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, AddInventoryActivity.class);
        startActivity(intent);
    }

    public void GetInventoryInfo(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, CheckInventoryActivity.class);
        startActivity(intent);
    }

    public void UpdateQuan(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, UpdateQuanActivity.class);
        startActivity(intent);
    }

    public void UpdateFreshness(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, UpdateFreshnessActivity.class);
        startActivity(intent);
    }
}