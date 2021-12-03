package com.example.androidgui.inventoryactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import presenter.inventorysystem.CheckInventoryPresenter;
import presenter.inventorysystem.InventoryFacade;

//import com.example.androidgui.inventory.PresentInventoryActivity;


public class CheckInventoryActivity extends AppCompatActivity implements View.OnClickListener, presenter.inventorysystem.CheckInventoryInterface {
    /**
     * Activity class for checking inventory.
     */
    private EditText name;
    private Button button;
    InventoryFacade ifa = new InventoryFacade();
    final CheckInventoryPresenter cip = ifa.createCheckPresenter();




    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cip.setCheckInventoryInterface(this);
        setContentView(R.layout.activity_check_inventory2);
        button = findViewById(R.id.button7);
        name = findViewById(R.id.editTextTextName);
        button.setOnClickListener(this);
    }

    /**
     *
     * @param v view
     */
    @Override
    public void onClick(View v) {
        String iName = name.getText().toString();
        this.cip.checkValidity(iName);

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