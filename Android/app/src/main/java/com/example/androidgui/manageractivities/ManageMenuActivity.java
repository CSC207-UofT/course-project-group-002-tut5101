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
import constant.uimessage.ManagerUIMessage;
import controller.menusystem.MenuController;

/**
 * Activity class for the manager to manage menu.
 */
public class ManageMenuActivity extends AppCompatActivity {

    NumberPicker selectDish;
    TextView askDishNumber;
    String[] managerDecision;
    final MenuController menuController = new MenuController();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_menu);
        selectDish = findViewById(R.id.selectDish);
        askDishNumber = findViewById(R.id.askDishNumber);
        String askingDishNumber = ManagerUIMessage.MANAGE_DISH;
        askDishNumber.setText(askingDishNumber);
        managerDecision = menuController.passDishesAsList();
        selectDish.setMaxValue(managerDecision.length - 1);
        selectDish.setMinValue(0);
        selectDish.setDisplayedValues(managerDecision);
    }

    /**
     * Function to approach the next activity.
     *
     * @param v View parameter.
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void next(View v){
        Intent intent = new Intent(ManageMenuActivity.this, SelectEditOrDeleteActivity.class);
        String dishName = managerDecision[selectDish.getValue()];
        intent.putExtra("dishSelected", dishName);
        startActivity(intent);
    }

}