package com.example.androidgui;

import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.menuSystem.MenuController;
import controller.reviewSystem.ReviewController;

public class DeleteReviewActivity extends AppCompatActivity {
    NumberPicker selectAction;
    TextView askDeleteCriteria;
    String[] managerDecision;
    ReviewController ReviewController = new ReviewController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_review);
    }

}