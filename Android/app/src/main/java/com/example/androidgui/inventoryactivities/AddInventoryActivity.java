package com.example.androidgui.inventoryactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import presenter.inventorysystem.AddInventoryPresenter;
import presenter.inventorysystem.AddinventoryViewInterface;

/**
 * Activity class for adding inventory.
 */
public class AddInventoryActivity extends AppCompatActivity implements View.OnClickListener, AddinventoryViewInterface {
    private Button button;
    private EditText name;
    private EditText price;
    private EditText amount;
    private EditText date;
    private EditText freshness;
    private AddInventoryPresenter aip = new AddInventoryPresenter();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);
        aip.setAddInventoryViewInterface(this);
        button = findViewById(R.id.button);
        name = findViewById(R.id.editTextTextPersonName);
        price = findViewById(R.id.editTextNumberDecimal);
        amount = findViewById(R.id.editTextNumberDecimal2);
        date = findViewById(R.id.editTextDate);
        freshness = findViewById(R.id.editTextTextPersonName10);
        button.setOnClickListener(this);
    }

    /**
     * when clicked.
     *
     * @param v view
     */
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String iprice = price.getText().toString();
        String iamount = amount.getText().toString();
        String idate = date.getText().toString();
        String ifreshness = freshness.getText().toString();
        this.aip.addNewInventory(iname, iprice, iamount, idate, ifreshness);
    }
    @Override
    public void updateInventoryList(String message){
        Toast.makeText(AddInventoryActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
