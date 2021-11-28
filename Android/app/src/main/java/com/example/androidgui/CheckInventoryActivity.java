package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.inventorySystem.InventoryManager;

public class CheckInventoryActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText name;
    InventoryManager im = new InventoryManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_inventory);
        button = (Button)findViewById(R.id.button);
        name = (EditText)findViewById(R.id.textInputEditText);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String info = im.getInfo(iname);
        boolean wrongname = info.equals("Invalid name");
        String fail = "Invalid name";
        if (wrongname) {
            Toast.makeText(CheckInventoryActivity.this,fail,Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(CheckInventoryActivity.this, PresentInventoryActivity.class);
            intent.putExtra("showdata",info);
            startActivity(intent);
        }
    }
}