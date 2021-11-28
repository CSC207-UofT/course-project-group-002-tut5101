package com.example.androidgui.ManagerActivities;

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
import com.example.androidgui.R;
import constant.mangerSystem.ManagerDecision;
import constant.mangerSystem.ReviewMessage;
import constant.uiMessage.ManagerUIMessage;
import controller.reviewSystem.ReviewController;
import entity.orderList.Dish;

import java.util.Objects;

public class DeleteReviewActivity extends AppCompatActivity {
    NumberPicker selectAction;
    TextView askDeleteCriteria;
    String[] managerDecision;
    ReviewController reviewController = new ReviewController();


    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_review);
        selectAction = findViewById(R.id.selectAction);
        askDeleteCriteria = findViewById(R.id.askDeleteCriteria);
        String askingDeleteCriteria = ManagerUIMessage.DELETE_REVIEW;
        askDeleteCriteria.setText(askingDeleteCriteria);
        managerDecision = new String[]{ManagerDecision.ONE.name(), ManagerDecision.TWO.name(),
                ManagerDecision.THREE.name()};
        selectAction.setDisplayedValues(managerDecision);
        selectAction.setMaxValue(managerDecision.length - 1);
        selectAction.setMinValue(0);
    }

    /**
     * Method to delete the reviews.
     *
     * @param v
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void deleteReview(View v) {
        String action = managerDecision[selectAction.getValue()];
        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(ReviewMessage.CONFIRM)
                .setMessage(ReviewMessage.DELETE_REVIEW)
                .setPositiveButton(ReviewMessage.YES, (dialog, which) -> {
                    if (Objects.equals(action,ManagerDecision.ONE.toString())){
                        reviewController.deleteBelowOne();
                    }
                    else if(Objects.equals(action,ManagerDecision.TWO.toString())) {
                        reviewController.deleteBelowTwo();
                    }
                    else {
                        reviewController.deleteBelowThree();
                    }
                    finish();
                })
                .setNegativeButton(ReviewMessage.NO, (dialog, which) -> dialog.dismiss())
                .create();
        alertDlg.show();

    }

    /**
     * Display AlertDialog to ask manager confirm to delete the reiews.
     *
     * @param view android view
     */
//    public void cancelUserEnroll(View view) {
//        AlertDialog alertDlg = new AlertDialog.Builder(this)
//                .setTitle(ReviewMessage.CONFIRM)
//                .setMessage(ReviewMessage.DELETE_REVIEW)
//                .setPositiveButton(ReviewMessage.YES, (dialog, which) -> finish())
//                .setNegativeButton(ReviewMessage.NO, (dialog, which) -> dialog.dismiss())
//                .create();
//        alertDlg.show();
//    }

}


