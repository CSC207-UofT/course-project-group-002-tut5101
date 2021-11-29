package com.example.androidgui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PresentInventoryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_inventory);
        TextView mTextView1 = findViewById(R.id.textView6);
        TextView mTextView2 = findViewById(R.id.textView7);
        TextView mTextView3 = findViewById(R.id.textView8);
        TextView mTextView4 = findViewById(R.id.textView9);
        TextView mTextView5 = findViewById(R.id.textView10);
        Intent intent = getIntent();
        String showdata = intent.getStringExtra("showdata");
        String[] presenting = showdata.split(",");
        mTextView1.setText(presenting[0]);
        mTextView2.setText(presenting[1]);
        mTextView3.setText(presenting[2]);
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