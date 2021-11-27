package com.example.androidgui;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import constant.mangerSystem.ManagerDecision;
import constant.uiMessage.ManagerUIMessage;
import controller.menuSystem.MenuController;
import entity.orderList.Dish;

import java.util.Objects;

public class SelectEditOrDeleteActivity extends AppCompatActivity {

    NumberPicker selectEditOrDelete;
    TextView askSelection;
    String[] selectOption;
    MenuController menuController = new MenuController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_edit_or_delete);

        selectEditOrDelete = findViewById(R.id.selectEditOrDelete);
        askSelection = findViewById(R.id.askSelection);
        String askingSelection = ManagerUIMessage.EDIT_DELETE;
        askSelection.setText(askingSelection);
        selectOption = new String[]{ManagerDecision.DELETE.name(), ManagerDecision.EDIT.name()};
        selectEditOrDelete.setMaxValue(selectOption.length);
        selectEditOrDelete.setMinValue(0);
        selectEditOrDelete.setDisplayedValues(selectOption);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void manageMenu(View v){
        String action = selectOption[selectEditOrDelete.getValue()];
        Intent extras = getIntent();
        String dishName = extras.getStringExtra("dishSelected");
        Dish dish = menuController.passDishByString(dishName);
        if (Objects.equals(action,ManagerDecision.EDIT.toString())){
            menuController.deleteDishByName(dishName);
        }
        else {
            menuController.editDishByName(dishName);
        }
    }

}