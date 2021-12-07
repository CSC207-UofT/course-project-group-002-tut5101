package com.example.android.inventory_activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;

/**
 * Activity class for presenting inventory.
 */
public class PresentInventoryActivity extends AppCompatActivity{

    /**
     * Activity basic function. Take the passing in information and present them
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_inventory);
        TextView mTextView1 = findViewById(R.id.textView8);
        TextView mTextView2 = findViewById(R.id.textView9);
        TextView mTextView3 = findViewById(R.id.textView10);
        TextView mTextView4 = findViewById(R.id.textView11);
        TextView mTextView5 = findViewById(R.id.textView12);
        Intent intent = getIntent();
        String showData = intent.getStringExtra("showData");
        String[] presenting = showData.split(",");
        mTextView1.setText(presenting[0]);
        String price = presenting[1]+"$";
        mTextView2.setText(price);
        String amount = presenting[2]+"kg";
        mTextView3.setText(amount);
        String num4;
        String num5;
        if(presenting.length == 5){
            num4 = "Freshness:" + presenting[3];
            num5 = "Import on" + presenting[4];
        }
        else{
            num4 = "Best before" + presenting[3];
            num5 = "N/A";
        }
        mTextView4.setText(num4);
        mTextView5.setText(num5);
        Button btn = findViewById(R.id.button6);
        btn.setOnClickListener(v -> {
            Intent intent1 = new Intent(PresentInventoryActivity.this, InventoryStarterActivity.class);
            startActivity(intent1);
        });
    }
}