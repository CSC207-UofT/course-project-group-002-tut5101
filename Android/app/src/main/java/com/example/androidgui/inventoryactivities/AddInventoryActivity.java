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


public class AddInventoryActivity extends AppCompatActivity implements View.OnClickListener, AddinventoryViewInterface {
    Button button;
    EditText name;
    EditText price;
    EditText amount;
    EditText date;
    EditText freshness;
    AddInventoryPresenter aip = new AddInventoryPresenter();

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
