package com.example.android.inventory_activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import presenter.inventory_system.UpdateFreshnessPresenter;
import presenter.inventory_system.view_interfaces.UpdateFreshnessInterface;

/**
 * Activity class for update the freshness of  inventory.
 */
public class UpdateFreshnessActivity extends AppCompatActivity implements View.OnClickListener,
        UpdateFreshnessInterface {
/**
 * Activity class for updating freshness.
 */
    Button btn;
    EditText name;
    EditText fresh;
    private final UpdateFreshnessPresenter ufp = new UpdateFreshnessPresenter();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ufp.setUpdateFreshnessInterface(this);
        setContentView(R.layout.activity_update_freshness2);
        btn = findViewById(R.id.button11);
        name = findViewById(R.id.editTextTextPersonName8);
        fresh = findViewById(R.id.editTextTextPersonName9);
        btn.setOnClickListener(this);
    }

    /**
     * change the freshness of the item based on the input
     * @param v the view on which the user has clicked
     */
    @Override
    public void onClick(View v) {
        String inventoryItemName = name.getText().toString();
        String inventoryItemFreshness = fresh.getText().toString();
        ufp.popInfo(inventoryItemName, inventoryItemFreshness);
        finish();
    }
    /**
     * Show the message on the screen
     * @param message the message to send
     */
    @Override
    public void popInfo(String message){
        Toast.makeText(UpdateFreshnessActivity.this,message,Toast.LENGTH_SHORT).show();
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