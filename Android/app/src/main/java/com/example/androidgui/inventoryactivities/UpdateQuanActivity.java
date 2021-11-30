package com.example.androidgui.inventoryactivities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import controller.inventorysystem.InventoryManager;
import use_case.boundary.output.InventoryOutputBoundary;

public class UpdateQuanActivity extends AppCompatActivity implements View.OnClickListener, InventoryOutputBoundary {
    Button btn;
    EditText name;
    EditText usage;
    InventoryManager im = new InventoryManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quan2);
        btn = findViewById(R.id.button8);
        name = findViewById(R.id.editTextTextPersonName6);
        usage = findViewById(R.id.editTextTextPersonName7);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String iusage = usage.getText().toString();
        String message = im.newQuantity(iname,iusage,UpdateQuanActivity.this);
//        im.SavetoFile();
        Toast.makeText(UpdateQuanActivity.this,message,Toast.LENGTH_SHORT).show();
    }
    public String getMessage(String message){
        return message;
    }
}