package com.example.androidgui;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.kitchenSystem.KitchenController;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class KitchenActivity extends AppCompatActivity {

    // TODO: improve the design here, try to make it not public.
    public static KitchenController kc = new KitchenController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        ListView list = (ListView) findViewById(R.id.dishToCook);

        ArrayList<String[]> displayDishes = kc.exportDishes();

        KitchenAdapter adapter = new KitchenAdapter(this, R.layout.cook_dish_layout,
                displayDishes);
        list.setAdapter(adapter);

//        Button button = (Button) findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // kc.add("Pressed button");
//                adapter.notifyDataSetChanged();
//            }
//        });

    }
}