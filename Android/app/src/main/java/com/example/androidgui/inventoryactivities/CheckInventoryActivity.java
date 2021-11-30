package com.example.androidgui.inventoryactivities;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import com.example.androidgui.inventory.PresentInventoryActivity;
import com.example.androidgui.R;
import controller.inventorysystem.InventoryManager;


public class CheckInventoryActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText name;
    final InventoryManager im = new InventoryManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_inventory2);
        button = findViewById(R.id.button7);
        name = findViewById(R.id.editTextTextName);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String iName = name.getText().toString();
        String info = im.getInfo(iName);
        boolean wrongName = info.equals("Invalid name");
        String fail = "Invalid name";
        if (wrongName) {
            Toast.makeText(CheckInventoryActivity.this,fail,Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(CheckInventoryActivity.this, PresentInventoryActivity.class);
            intent.putExtra("showData",info);
            startActivity(intent);
        }
    }

}