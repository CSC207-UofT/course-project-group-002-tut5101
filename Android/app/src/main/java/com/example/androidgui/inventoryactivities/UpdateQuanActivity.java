package com.example.androidgui.inventoryactivities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.inventorysystem.InventoryManager;
import presenter.inventorysystem.InventoryPresenter;
import presenter.inventorysystem.UpdateQuanInterface;
import use_case.boundary.output.InventoryOutputBoundary;

public class UpdateQuanActivity extends AppCompatActivity implements View.OnClickListener, InventoryOutputBoundary,
        UpdateQuanInterface{
    Button btn;
    EditText name;
    EditText usage;
    final InventoryManager im = new InventoryManager();
    InventoryPresenter ip = new InventoryPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quan2);
        btn = findViewById(R.id.button8);
        name = findViewById(R.id.editTextTextPersonName6);
        usage = findViewById(R.id.editTextTextPersonName7);
        btn.setOnClickListener(this);
        ip.setUpdateQuanInterface(this);
    }
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String iusage = usage.getText().toString();
        String message = im.newQuantity(iname,iusage,UpdateQuanActivity.this);
        ip.showInfo(message);
    }
    public String getMessage(String message){
        return message;
    }
    public void popInfo(String message){Toast.makeText(UpdateQuanActivity.this,message,Toast.LENGTH_SHORT).show();}

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}