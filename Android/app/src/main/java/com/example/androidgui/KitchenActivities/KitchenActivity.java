package com.example.androidgui.KitchenActivities;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import controller.Facade.KitchenFacade;
import controller.kitchenSystem.KitchenController;

import java.util.ArrayList;

public class KitchenActivity extends AppCompatActivity{

    // TODO: improve the design here, try to make it not public.
    public static KitchenFacade kf = new KitchenFacade();
    public static KitchenController kc = kf.createKitchen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        ListView list = findViewById(R.id.dishToCook);

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
    public String getMessage(String message){
        return message;
    }
    public KitchenController getKitchen() {return kc;}
}