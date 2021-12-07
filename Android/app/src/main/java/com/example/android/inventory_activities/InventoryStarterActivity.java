package com.example.android.inventory_activities;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.MainActivity;
import com.example.android.R;

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
     * Moving to the Adding inventory page.
     * @param v view
     */
    public void AddInventory(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, AddInventoryActivity.class);
        startActivity(intent);
    }

    /**
     * Moving to the getting inventory page.
     * @param v view.
     */
    public void GetInventoryInfo(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, CheckInventoryActivity.class);
        startActivity(intent);
    }

    /**
     * Moving to the updating quantity page.
     * @param v view.
     */
    public void UpdateQuantity(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, UpdateQuantityActivity.class);
        startActivity(intent);
    }

    /**
     * Moving to the  updating freshness page.
     * @param v view.
     */
    public void UpdateFreshness(View v) {
        Intent intent = new Intent(InventoryStarterActivity.this, UpdateFreshnessActivity.class);
        startActivity(intent);
    }

    /**
     * back to main activity
     * @param view view
     */
    public void backToMainActivity(View view) {
        Intent intent = new Intent(InventoryStarterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}