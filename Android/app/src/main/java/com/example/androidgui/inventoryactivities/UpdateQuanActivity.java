package com.example.androidgui.inventoryactivities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.inventory_system.UpdateQuanInterface;
import presenter.inventory_system.UpdateQuanPresenter;
import use_case.inventory_factory.InventoryOutputBoundary;

public class UpdateQuanActivity extends AppCompatActivity implements View.OnClickListener, InventoryOutputBoundary,
        UpdateQuanInterface{
    private EditText name;
    private EditText usage;
    private final UpdateQuanPresenter uqp = new UpdateQuanPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quan2);
        Button btn = findViewById(R.id.button8);
        name = findViewById(R.id.editTextTextPersonName6);
        usage = findViewById(R.id.editTextTextPersonName7);
        btn.setOnClickListener(this);
        uqp.setUpdateQuanInterface(this);
    }
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String iusage = usage.getText().toString();
        uqp.showInfo(iname, iusage, this);
    }
    public String getMessage(String message){
        return message;
    }
    public void popInfo(String message){
        Toast.makeText(UpdateQuanActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}