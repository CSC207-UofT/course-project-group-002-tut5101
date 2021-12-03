package com.example.androidgui.inventoryactivities;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.inventorysystem.InventoryManager;

/**
 * Activity class for updating freshness.
 */
public class UpdateFreshnessActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText name;
    EditText fresh;
    final InventoryManager im = new InventoryManager();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_freshness2);
        btn = findViewById(R.id.button11);
        name = findViewById(R.id.editTextTextPersonName8);
        fresh = findViewById(R.id.editTextTextPersonName9);
        btn.setOnClickListener(this);
    }

    /**
     *
     * @param v view
     */
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        String ifreshness = fresh.getText().toString();
        String message = im.newFreshness(iname,ifreshness);
//        im.SavetoFile();
        Toast.makeText(UpdateFreshnessActivity.this,message,Toast.LENGTH_SHORT).show();
    }



}