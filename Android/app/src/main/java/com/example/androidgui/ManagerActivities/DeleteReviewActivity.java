package com.example.androidgui.ManagerActivities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import constant.mangerSystem.ManagerDecision;
import constant.uiMessage.ManagerUIMessage;
import controller.reviewSystem.ReviewController;
import entity.orderList.Dish;

import java.util.Objects;

public class DeleteReviewActivity extends AppCompatActivity {
    NumberPicker selectAction;
    TextView askDeleteCriteria;
    String[] managerDecision;
    ReviewController reviewController = new ReviewController();

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
        selectAction.setMaxValue(reviewController.length());
        selectAction.setMinValue(0);
        selectAction.setDisplayedValues(managerDecision);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void deleteReview(View v) {
        String action = managerDecision[selectAction.getValue()];
        if (Objects.equals(action,ManagerDecision.ONE.toString())){
            reviewController.deleteBelowOne();
        }
        else if(Objects.equals(action,ManagerDecision.TWO.toString())) {
            reviewController.deleteBelowTwo();
        }
        else {
            reviewController.deleteBelowThree();
        }
    }

}


