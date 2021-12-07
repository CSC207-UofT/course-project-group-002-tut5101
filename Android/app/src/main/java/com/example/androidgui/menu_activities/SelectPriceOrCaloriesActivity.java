package com.example.androidgui.menu_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import constant.manager_system.ManagerDecision;
import constant.manager_system.ManagerUIMessage;
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

        setupMessage();
        setupOptions();
    }

    /**
     * Setting up message.
     */
    private void setupMessage() {
        askSelection.setText(ManagerUIMessage.PRICE_CALORIES);
    }

    /**
     * Setting up options.
     */
    private void setupOptions() {
        selectOption = new String[]{ManagerDecision.CALORIES.toString(), ManagerDecision.PRICE.toString()};
        select.setMaxValue(selectOption.length - 1);
        select.setMinValue(0);
        select.setDisplayedValues(selectOption);
    }


    /**
     * Manager decides to go back.
     *
     * @param v view
     */
    public void selectExit(View v) {
        Intent intent = new Intent(SelectPriceOrCaloriesActivity.this, SelectEditOrDeleteActivity.class);
        startActivity(intent);
    }

}