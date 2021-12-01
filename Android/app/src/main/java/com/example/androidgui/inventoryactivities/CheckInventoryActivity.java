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
import controller.inventorysystem.CheckInventoryInterface;
import presenter.inventorysystem.InventoryManager;
import presenter.inventorysystem.InventoryPresenter;


public class CheckInventoryActivity extends AppCompatActivity implements View.OnClickListener, presenter.inventorysystem.CheckInventoryInterface {
    Button button;
    EditText name;
    final InventoryManager im = new InventoryManager();
    InventoryPresenter ip = new InventoryPresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ip.setCheckInventoryInterface(this);
        setContentView(R.layout.activity_check_inventory2);
        button = findViewById(R.id.button7);
        name = findViewById(R.id.editTextTextName);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String iName = name.getText().toString();
        String info = im.getInfo(iName);
        this.ip.checkValidity(info);

    }
    @Override
    public void Checkvalidity(String info){
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}