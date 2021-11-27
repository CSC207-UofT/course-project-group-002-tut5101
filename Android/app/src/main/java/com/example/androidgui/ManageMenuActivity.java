package com.example.androidgui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import constant.uiMessage.ManagerUIMessage;
import controller.menuSystem.MenuController;
import entity.orderList.Dish;

public class ManageMenuActivity extends AppCompatActivity {
    NumberPicker selectDish;
    TextView askDishNumber;
    String[] managerDecision;
    MenuController menuController = new MenuController();
//    MenuController menuController = new MenuController();
//    Dish dish = menuController.passDishByString(id);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_menu);
        selectDish = findViewById(R.id.selectDish);
        askDishNumber = findViewById(R.id.askDishNumber);
        String askingDishNumber = ManagerUIMessage.MANAGE_DISH;
        askDishNumber.setText(askingDishNumber);
        managerDecision = new String[]{};
        selectDish.setMaxValue(menuController.length());
        selectDish.setMinValue(0);
        selectDish.setDisplayedValues(managerDecision);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void next(View v){
        Intent intent = new Intent(ManageMenuActivity.this, SelectEditOrDeleteActivity.class);
        Dish dish;
        String dishName = managerDecision[selectDish.getValue()];
        intent.putExtra("dishSelected", dishName);
        startActivity(intent);
    }
//    public void deleteDish(View v) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        // set the messages.
//        builder.setMessage(R.string.delete_message)
//                .setTitle(R.string.delete_title);
//        // Add the buttons
//        builder.setPositiveButton(R.string.agree, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                // Manager clicked OK button
//                menuController.deleteDishByName(dish.getName());
//            }
//        });
//        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                // Manager cancelled the dialog
//                dialog.cancel();
//                ManageMenuActivity.this.finish();
//            }
//        });
//
//        // Create the AlertDialog
//        AlertDialog dialog = builder.create();
//    }
//
//    public void editDish(View v) {
//
//    }
}