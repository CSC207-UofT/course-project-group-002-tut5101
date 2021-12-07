package com.example.android.menu_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import constant.manager_system.ManagerDecision;
import constant.manager_system.ManagerUIMessage;

import java.util.Objects;

/**
 * Activity class for editing price or calories
 */
public class SelectPriceOrCaloriesActivity extends AppCompatActivity {

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
     * Next activity
     * @param v v
     */
    public void next(View v){
        String action = selectOption[select.getValue()];
        Intent extras = getIntent();
        String dishName = extras.getStringExtra("dishSelected");
        if  (Objects.equals(action, ManagerDecision.PRICE.toString())) {
            Intent intent = new Intent(SelectPriceOrCaloriesActivity.this, EditPriceActivity.class);
            intent.putExtra("dishSelected", dishName);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SelectPriceOrCaloriesActivity.this, EditCaloriesActivity.class);
            intent.putExtra("dishSelected", dishName);
            startActivity(intent);
        }
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