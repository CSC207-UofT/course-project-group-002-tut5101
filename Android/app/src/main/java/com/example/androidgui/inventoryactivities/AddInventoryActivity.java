package com.example.androidgui.inventoryactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import presenter.inventorysystem.InventoryManager;

/**
 * Activity class for adding inventory.
 */
public class AddInventoryActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText editTextName;
    EditText editTextPrice;
    EditText editTextAmount;
    EditText editTextFate;
    EditText editTextFreshness;
    final InventoryManager im = new InventoryManager();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory2);
        button = findViewById(R.id.button10);
        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextPrice = findViewById(R.id.editTextTextPersonName2);
        editTextAmount = findViewById(R.id.editTextTextPersonName3);
        editTextFate = findViewById(R.id.editTextTextPersonName4);
        editTextFreshness = findViewById(R.id.editTextTextPersonName5);
        button.setOnClickListener(this);
    }

    /**
     * when clicked.
     *
     * @param v view
     */
    @Override
    public void onClick(View v) {
        String name = editTextName.getText().toString();
        String price = editTextPrice.getText().toString();
        String amount = editTextAmount.getText().toString();
        String date = editTextFate.getText().toString();
        String freshness = editTextFreshness.getText().toString();
        String para;
        if (freshness.equals("N/A")) {
            para = name + "," + price + "," + amount + "," + date;
        } else {
            para = name + "," + price + "," + amount + "," + freshness + "," + date;
        }
        String[] paras = para.split(",");
        im.addNewInventory(paras);
//        im.SavetoFile();
    }

}
