package com.example.androidgui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.inventorySystem.InventoryManager;
import use_case.boundary.output.InventoryOutputBoundary;

public class UpdateFreshnessActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText name;
    EditText fresh;
    InventoryManager im = new InventoryManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_freshness);
        btn = findViewById(R.id.button8);
        name = findViewById(R.id.textInputEditText7);
        fresh = findViewById(R.id.textInputEditText8);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String ifreshness = fresh.getText().toString();
        String message = im.newFreshness(iname,ifreshness);
        im.SavetoFile();
        Toast.makeText(UpdateFreshnessActivity.this,message,Toast.LENGTH_SHORT).show();
    }



}