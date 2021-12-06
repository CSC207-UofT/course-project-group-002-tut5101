package com.example.androidgui.kitchen_activities;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.MainActivity;
import com.example.androidgui.R;
import presenter.kitchen_system.KitchenPresenter;
import presenter.kitchen_system.KitchenView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class CurrentOrderDishesActivity extends AppCompatActivity implements KitchenView, PropertyChangeListener {

    private KitchenPresenter kp;
    private CurrentOrderDishesAdapter adapter;
    private ArrayList<String[]> dishesToDisplay;

    /**
     * Activity basic function.
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        ListView list = findViewById(R.id.dishToCook);

        kp = new KitchenPresenter(this);
        kp.checkOrderAvailable();
        dishesToDisplay = kp.exportDishes();
        adapter = new CurrentOrderDishesAdapter(this, R.layout.cook_dish_layout, dishesToDisplay, kp);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("did");
                Toast.makeText(CurrentOrderDishesActivity.this,
                        "One " + dishesToDisplay.get(i) + "has been cooked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Listen to the change in Order and update the display if needed.
     * @param propertyChangeEvent A propertyChange Event
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        kp.checkOrderAvailable();
    }

    /**
     * Update the current dishes to display by mutating the arraylist that holds all display info.
     * @param displayDishes the updated array list of dish infos.
     */
    @Override
    public void renewDishes(ArrayList<String[]> displayDishes) {
       dishesToDisplay.clear();
       dishesToDisplay.addAll(displayDishes);
    }

    /**
     * Update the display by notifying the adapter changes have been made.
     */
    @Override
    public void updateListDisplay() {
        this.adapter.notifyDataSetChanged();
    }


    @Override
    public void createToast(String message, boolean shortDisplay) {
        if (shortDisplay) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}