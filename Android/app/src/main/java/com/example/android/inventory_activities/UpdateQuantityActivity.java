package com.example.android.inventory_activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import presenter.inventory_system.view_interfaces.UpdateQuantityInterface;
import presenter.inventory_system.UpdateQuantityPresenter;

/**
 * Activity class for updating quantity of inventory.
 */
public class UpdateQuantityActivity extends AppCompatActivity implements View.OnClickListener,
        UpdateQuantityInterface {
    private EditText name;
    private EditText usage;
    private final UpdateQuantityPresenter uqp = new UpdateQuantityPresenter();
    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quan2);
        Button btn = findViewById(R.id.button8);
        name = findViewById(R.id.editTextTextPersonName6);
        usage = findViewById(R.id.editTextTextPersonName7);
        btn.setOnClickListener(this);
        uqp.setUpdateQuantityInterface(this);
    }
    /**
     * change the quantity of the item based on the input
     * @param v the view on which the user has clicked
     */
    @Override
    public void onClick(View v) {
        String inventoryItemName = name.getText().toString();
        String inventoryItemUsage = usage.getText().toString();
        uqp.showInfo(inventoryItemName, inventoryItemUsage);
        finish();
    }

    /**
     * Show the message on the screen
     * @param message the message to send
     */
    public void popInfo(String message){Toast.makeText(UpdateQuantityActivity.this,message,Toast.LENGTH_SHORT).show();}
    /**
     * Call when  the pointer is enabled or disable for the current window.
     *
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}