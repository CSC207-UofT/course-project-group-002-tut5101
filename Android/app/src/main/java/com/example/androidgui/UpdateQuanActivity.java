package com.example.androidgui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.inventorySystem.InventoryManager;

public class UpdateQuanActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText name;
    EditText usage;
    InventoryManager im = new InventoryManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_freshness);
        btn = findViewById(R.id.button9);
        name = findViewById(R.id.textInputEditText9);
        usage = findViewById(R.id.textInputEditText10);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String iusage = usage.getText().toString();
        im.newQuantity(iname,iusage);
        Toast.makeText(UpdateQuanActivity.this,"Check in get info",Toast.LENGTH_SHORT).show();
    }
}