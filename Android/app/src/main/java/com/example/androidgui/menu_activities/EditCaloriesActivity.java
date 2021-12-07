package com.example.androidgui.menu_activities;

import android.content.Intent;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.manager_system.ManagerDecision;
import constant.manager_system.ManagerUIMessage;

/**
 * Activity class for editing calories
 */
public class EditCaloriesActivity extends AppCompatActivity {

    private NumberPicker select;
    private TextView askSelection;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_calories);
        select = findViewById(R.id.selectIncreaseOrDecrease);
        askSelection = findViewById(R.id.askSelection);

        setupMessage();
        setupOptions();
    }

    /**
     * Setting up message.
     */
    private void setupMessage() {
        askSelection.setText(ManagerUIMessage.IncreaseDecrease);
    }

    /**
     * Setting up options.
     */
    private void setupOptions() {
        String[] selectOption = new String[]{ManagerDecision.ONE.toString(),
                ManagerDecision.TWO.toString(),
                ManagerDecision.THREE.toString(),
                ManagerDecision.FOUR.toString(),
                ManagerDecision.FIVE.toString(),
                ManagerDecision.SIX.toString(),};
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
        Intent intent = new Intent(EditCaloriesActivity.this, SelectPriceOrCaloriesActivity.class);
        startActivity(intent);
    }

}