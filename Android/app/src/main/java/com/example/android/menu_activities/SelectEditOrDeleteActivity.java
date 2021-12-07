package com.example.android.menu_activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import constant.manager_system.DishMessage;
import constant.manager_system.ManagerDecision;
import constant.manager_system.ManagerUIMessage;
import presenter.menu_system.EditDeletePresenter;
import presenter.menu_system.view_interface.SelectEditViewInterface;

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
        selectOption = new String[]{ManagerDecision.DELETE.toString(),ManagerDecision.EDIT.toString()};
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
            Intent intent = new Intent(SelectEditOrDeleteActivity.this, SelectPriceOrCaloriesActivity.class);
            intent.putExtra("dishSelected", dishName);
            startActivity(intent);
        }
    }


}