package com.example.androidgui.manageractivities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import constant.mangersystem.ManagerDecision;
import constant.uimessage.ManagerUIMessage;
import presenter.menusystem.MenuPresenter;

import java.util.Objects;

/**
 * Activity class for the manager to pick whether to edit or to delete the dish.
 *
 */
public class SelectEditOrDeleteActivity extends AppCompatActivity {

    NumberPicker selectEditOrDelete;
    TextView askSelection;
    String[] selectOption;
    final MenuPresenter menuPresenter = new MenuPresenter();


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
        selectOption = new String[]{ManagerDecision.DELETE.name(), ManagerDecision.EDIT.name()};
        selectEditOrDelete.setMaxValue(selectOption.length);
        selectEditOrDelete.setMinValue(0);
        selectEditOrDelete.setDisplayedValues(selectOption);
    }

    /**
     * Manager selects manage menu.
     *
     * @param v android view.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void manageMenu(View v){
        String action = selectOption[selectEditOrDelete.getValue()];
        Intent extras = getIntent();
        String dishName = extras.getStringExtra("dishSelected");
        if (Objects.equals(action,ManagerDecision.EDIT.toString())){
            menuPresenter.deleteDishByName(dishName);
        }
        else {
            menuPresenter.editDishByName(dishName);
        }
    }

}