package com.example.android.menu_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import constant.manager_system.DishMessage;
import constant.manager_system.ManagerUIMessage;
import presenter.menu_system.EditCaloriesPresenter;


/**
 * Activity class for editing calories
 */
public class EditCaloriesActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private TextView askSelection;
    private EditCaloriesPresenter edit;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_calories);
        editTextNumber = findViewById(R.id.textNumber);
        askSelection = findViewById(R.id.askSelection);
        this.edit = new EditCaloriesPresenter();
        setupMessage();
    }

    /**
     * Setting up message.
     */
    private void setupMessage() {
        askSelection.setText(ManagerUIMessage.IncreaseDecrease);
    }


    /**
     * Next activity
     * @param v v
     */
    public void confirms(View v){
        Intent extras = getIntent();
        String dishName = extras.getStringExtra("dishSelected");
        double number = Double.parseDouble( editTextNumber.getText().toString());
        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(DishMessage.CONFIRMING)
                .setMessage(DishMessage.EDIT_MENU)
                .setPositiveButton(DishMessage.INCREASE, (dialog, which) -> {
                    edit.increaseCalories(dishName, number);
                    finish();
                })
                .setNegativeButton(DishMessage.DECREASE, (dialog, which) -> {
                    edit.decreaseCalories(dishName, number);
                    finish();
                })
                .create();
        alertDlg.show();

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