package com.example.androidgui.menu_activities;

import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.menu_system.view_interface.SelectPriceOrCaloriesViewInterface;

/**
 * Activity class for editing price or calories
 */
public class SelectPriceOrCaloriesActivity extends AppCompatActivity implements SelectPriceOrCaloriesViewInterface {

    private NumberPicker select;
    private TextView askSelection;
    private String[] selectOption;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_price_or_calories);
        select = findViewById(R.id.selectPriceOrCalories);
        askSelection = findViewById(R.id.askSelection);
    }
}