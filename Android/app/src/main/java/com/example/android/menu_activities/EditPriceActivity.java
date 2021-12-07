package com.example.android.menu_activities;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.R;
import constant.manager_system.DishMessage;
import constant.manager_system.ManagerUIMessage;
import presenter.menu_system.EditPricePresenter;

/**
 * Activity class for editing price
 */
public class EditPriceActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private TextView askSelection;
    private EditPricePresenter edit;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_price);
        editTextNumber = findViewById(R.id.textNumber);
        askSelection = findViewById(R.id.askSelection);
        this.edit = new EditPricePresenter();
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
    public void confirm(View v){
        Intent extras = getIntent();
        String dishName = extras.getStringExtra("dishSelected");
        double number = Double.parseDouble( editTextNumber.getText().toString());
        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(DishMessage.CONFIRMING)
                .setMessage(DishMessage.EDIT_MENU)
                .setPositiveButton(DishMessage.INCREASE, (dialog, which) -> {
                    edit.increasePrice(dishName, number);
                    finish();
                })
                .setNegativeButton(DishMessage.DECREASE, (dialog, which) -> {
                    edit.decreasePrice(dishName, number);
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
        Intent intent = new Intent(EditPriceActivity.this, SelectPriceOrCaloriesActivity.class);
        startActivity(intent);
    }

}