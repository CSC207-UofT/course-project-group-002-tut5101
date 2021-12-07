package com.example.androidgui.manager_activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import constant.manager_system.DishMessage;
import constant.manager_system.ManagerDecision;
import constant.manager_system.ManagerUIMessage;
import presenter.manager_system.EditDeletePresenter;
import presenter.menu_system.view_interfaces.SelectEditViewInterface;

import java.util.Objects;

/**
 * Activity class for the manager to pick whether to edit or to delete the dish.
 */
public class SelectEditOrDeleteActivity extends AppCompatActivity implements SelectEditViewInterface {

    private NumberPicker selectEditOrDelete;
    private TextView askSelection;
    private String[] selectOption;
    private EditDeletePresenter editDeletePresenter;


    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_edit_or_delete);

        selectEditOrDelete = findViewById(R.id.selectEditOrDelete);
        askSelection = findViewById(R.id.askSelection);
        this.editDeletePresenter = new EditDeletePresenter();

        setupMessage();
        setupOptions();
    }

    /**
     * Setting up message.
     */
    private void setupMessage() {
        askSelection.setText(ManagerUIMessage.EDIT_DELETE);
    }

    /**
     * Setting up options.
     */
    private void setupOptions() {
        selectOption = new String[]{ManagerDecision.INCREASE_CALORIES.toString(),
                ManagerDecision.DELETE.toString(),ManagerDecision.INCREASE_PRICE.toString(),
        ManagerDecision.DECREASE_CALORIES.toString(), ManagerDecision.DECREASE_PRICE.toString()};
        selectEditOrDelete.setMaxValue(selectOption.length - 1);
        selectEditOrDelete.setMinValue(0);
        selectEditOrDelete.setDisplayedValues(selectOption);
    }

    /**
     * Manager selects manage menu.
     *
     * @param v android view.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void manageMenu(View v) {
        String action = selectOption[selectEditOrDelete.getValue()];
        Intent extras = getIntent();
        String dishName = extras.getStringExtra("dishSelected");
        if (Objects.equals(action, ManagerDecision.DELETE.toString())) {
            AlertDialog alertDlg = new AlertDialog.Builder(this)
                    .setTitle(DishMessage.CONFIRM)
                    .setMessage(DishMessage.DELETE_MENU)
                    .setPositiveButton(DishMessage.YES, (dialog, which) -> {
                        editDeletePresenter.deleteDishByName(dishName);
                        finish();
                    })
                    .setNegativeButton(DishMessage.NO, (dialog, which) -> dialog.dismiss())
                    .create();
            alertDlg.show();
        } else {
            AlertDialog alertDlg = new AlertDialog.Builder(this)
                    .setTitle(DishMessage.CONFIRMING)
                    .setMessage(DishMessage.EDIT_MENU)
                    .setPositiveButton(DishMessage.YES, (dialog, which) -> {
                        if (Objects.equals(action, ManagerDecision.INCREASE_CALORIES.toString())){
                            editDeletePresenter.increaseCalories(dishName);
                        } else if (Objects.equals(action, ManagerDecision.DECREASE_CALORIES.toString())){
                            editDeletePresenter.decreaseCalories(dishName);
                        } else if (Objects.equals(action, ManagerDecision.INCREASE_PRICE.toString())){
                            editDeletePresenter.increasePrice(dishName);
                        } else{
                            editDeletePresenter.decreasePrice(dishName);
                        }
                        finish();
                    })
                    .setNegativeButton(DishMessage.NO, (dialog, which) -> dialog.dismiss())
                    .create();
            alertDlg.show();
        }
    }


}