package com.example.androidgui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import controller.inventorySystem.InventoryManager;

public class AddInventoryActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText name;
    EditText price;
    EditText amount;
    EditText date;
    EditText freshness;
    InventoryManager im = new InventoryManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);
        button = findViewById(R.id.button7);
        name = findViewById(R.id.textInputEditText5);
        price = findViewById(R.id.textInputEditText2);
        amount = findViewById(R.id.textInputEditText3);
        date = findViewById(R.id.textInputEditText4);
        freshness = findViewById(R.id.textInputEditText6);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String iprice = price.getText().toString();
        String iamount = amount.getText().toString();
        String idate = date.getText().toString();
        String ifreshness = freshness.getText().toString();
        String para;
        if(ifreshness.equals("N/A")){
            para = iname+","+iprice+","+iamount+","+idate;
        }
        else{para = iname+","+iprice+","+iamount+","+ifreshness+","+idate;}
        String[] paras = para.split(",");
        im.addNewInventory(paras);
        im.SavetoFile();
        }
    }
