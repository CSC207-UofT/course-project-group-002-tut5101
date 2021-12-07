package com.example.android.menu_activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import com.example.android.manager_activities.ManagerPickActionActivity;
import constant.manager_system.ManagerUIMessage;
import presenter.menu_system.ManageMenuPresenter;
import presenter.menu_system.view_interface.ManageMenuViewInterface;

/**
 * Activity class for the manager to manage menu.
 */
public class ManageMenuActivity extends AppCompatActivity implements ManageMenuViewInterface {

    private NumberPicker selectDish;
    private TextView askDishNumber;
    private String[] managerDecision;
    private ManageMenuPresenter manageMenuPresenter;

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
        this.manageMenuPresenter = new ManageMenuPresenter();
        this.manageMenuPresenter.setManageMenuViewInterface(this);
        setupMessage();
        setupOptions();
    }

    /**
     * Set up the message for text.
     */
    private void setupMessage() {
        askDishNumber.setText(ManagerUIMessage.MANAGE_DISH);
    }

    /**
     * Set up manager options.
     */
    private void setupOptions(){
        manageMenuPresenter.getDishList();
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
        manageMenuPresenter.getDish(managerDecision[selectDish.getValue()]);
    }

    /**
     * Getting the selected dish.
     */
    public void getDish(String dishName){
        Intent intent = new Intent(ManageMenuActivity.this, SelectEditOrDeleteActivity.class);
        intent.putExtra("dishSelected", dishName);
        startActivity(intent);
    }

    /**
     *
     * @param s array of strings of dishes.
     */
    @Override
    public void gettingDishList(String[] s) {
        managerDecision = s;
    }


    /**
     * Manager decides to go back.
     *
     * @param v view
     */
    public void selectExit(View v) {
        Intent intent = new Intent(ManageMenuActivity.this, ManagerPickActionActivity.class);
        startActivity(intent);
    }



}