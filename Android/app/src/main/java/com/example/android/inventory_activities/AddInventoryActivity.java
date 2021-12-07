package com.example.android.inventory_activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import presenter.inventory_system.AddInventoryPresenter;
import presenter.inventory_system.view_interfaces.AddInventoryViewInterface;

/**
 * Activity class for adding inventory.
 */
public class AddInventoryActivity extends AppCompatActivity implements View.OnClickListener, AddInventoryViewInterface {
    private EditText name;
    private EditText price;
    private EditText amount;
    private EditText date;
    private EditText freshness;
    private final AddInventoryPresenter ADD_INVENTORY_PRESENTER = new AddInventoryPresenter();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);
        ADD_INVENTORY_PRESENTER.setAddInventoryViewInterface(this);
        Button button = findViewById(R.id.button);
        name = findViewById(R.id.editTextTextPersonName);
        price = findViewById(R.id.editTextNumberDecimal);
        amount = findViewById(R.id.editTextNumberDecimal2);
        date = findViewById(R.id.editTextDate);
        freshness = findViewById(R.id.editTextTextPersonName10);
        button.setOnClickListener(this);
    }

    /**
     * when clicked， create a new inventory item and add it in the inventory list.
     *
     * @param v view
     */
    @Override
    public void onClick(View v) {
        String inventoryItemName = name.getText().toString();
        String inventoryItemPrice = price.getText().toString();
        String inventoryItemAmount = amount.getText().toString();
        String inventoryItemImportDate = date.getText().toString();
        String inventoryItemFreshness = freshness.getText().toString();
        this.ADD_INVENTORY_PRESENTER.addNewInventory(inventoryItemName, inventoryItemPrice, inventoryItemAmount, inventoryItemImportDate, inventoryItemFreshness);
        finish();
    }
    /**
     * show the toast information on the screen.
     *
     */
    @Override
    public void updateInventoryList(String message){
        Toast.makeText(AddInventoryActivity.this,message,Toast.LENGTH_SHORT).show();
    }
    /**
     * Call when  the pointer is enabled or disable for the current window.
     *
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
