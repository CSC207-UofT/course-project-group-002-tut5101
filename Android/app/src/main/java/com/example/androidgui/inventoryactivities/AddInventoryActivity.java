package com.example.androidgui.inventoryactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import presenter.inventorysystem.AddinventoryViewInterface;
import presenter.inventorysystem.InventoryManager;
import presenter.inventorysystem.InventoryPresenter;


public class AddInventoryActivity extends AppCompatActivity implements View.OnClickListener, AddinventoryViewInterface {
    Button button;
    EditText name;
    EditText price;
    EditText amount;
    EditText date;
    EditText freshness;
    final InventoryManager im = new InventoryManager();
    InventoryPresenter ip = new InventoryPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);
        ip.setAddInventoryViewInterface(this);
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
        String[] paras = this.updateInventoryList(iname, iprice, iamount, idate, ifreshness);
        im.addNewInventory(paras);
    }
    @Override
    public String[] updateInventoryList(String name, String price, String amount, String date, String freshness){
        String para;
        if(freshness.equals("N/A")){
            para = name+","+price+","+amount+","+date;
        }
        else{para = name+","+price+","+amount+","+freshness+","+date;}
        String[] paras = para.split(",");
        return paras;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
