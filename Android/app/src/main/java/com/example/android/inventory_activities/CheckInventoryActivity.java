package com.example.android.inventory_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import presenter.inventory_system.CheckInventoryPresenter;
import presenter.inventory_system.view_interfaces.CheckInventoryInterface;


public class CheckInventoryActivity extends AppCompatActivity implements View.OnClickListener,
        CheckInventoryInterface {
    /**
     * Activity class for checking inventory.
     */
    private EditText name;
    private final CheckInventoryPresenter cip = new CheckInventoryPresenter();




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
        Button button = findViewById(R.id.button7);
        name = findViewById(R.id.editTextTextName);
        button.setOnClickListener(this);
    }

    /**
     * Check whether the name is valid and pass the information of item to another page
     * @param v view
     */
    @Override
    public void onClick(View v) {
        String iName = name.getText().toString();
        this.cip.checkValidity(iName);
        finish();

    }
    /**
     * Check whether the name is valid and pass the information of item to another page
     * @param info the action response information success or wrong name
     */
    @Override
    public void CheckValidity(String info){
        boolean wrongName = info.equals("Invalid name");
        String fail = "Invalid name";
        if (wrongName) {
            Toast.makeText(CheckInventoryActivity.this,fail,Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, PresentInventoryActivity.class);
            intent.putExtra("showData",info);
            startActivity(intent);
        }
    }
    /**
     * Call when  the pointer is enabled or disable for the current window.
     *
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}