package com.example.androidgui.inventory_activities;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;

/**
 * Activity class for inventory starter.
 */
public class InventoryStarterActivity extends AppCompatActivity {

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_starter);
    }

    /**
     * Adding inventory.
     * @param v view
     */
    public void AddInventory(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, AddInventoryActivity.class);
        startActivity(intent);
    }

    /**
     * getting inventory.
     * @param v view.
     */
    public void GetInventoryInfo(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, CheckInventoryActivity.class);
        startActivity(intent);
    }

    /**
     *  updating quantity.
     * @param v view.
     */
    public void UpdateQuantity(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, UpdateQuanActivity.class);
        startActivity(intent);
    }

    /**
     *  updating freshness.
     * @param v view.
     */
    public void UpdateFreshness(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, UpdateFreshnessActivity.class);
        startActivity(intent);
    }
}