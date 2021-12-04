package com.example.androidgui.kitchen_activities;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.kitchen_system.KitchenFacade;
import controller.KitchenController;

import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class KitchenActivity extends AppCompatActivity{

    // TODO: improve the design here, try to make it not public.
    public static final KitchenFacade kf = new KitchenFacade();
    public static final KitchenController kc = kf.createKitchen();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
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