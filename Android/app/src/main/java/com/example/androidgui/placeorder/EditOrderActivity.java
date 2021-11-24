package com.example.androidgui.placeorder;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;

/**
 * Edits the existing dishes in the order
 */
//TODO: Finish this class
public class EditOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);
    }

    /**
     * Get the dishes to be removed from the xml file and remove them from the current list of dishes
     */
    public void editDishes() {

    }

    /**
     * Switch back to the place order page, and send the information
     * @param v the view on which the user has clicked
     */
    public void returnToOrder(View v) {

    }
}