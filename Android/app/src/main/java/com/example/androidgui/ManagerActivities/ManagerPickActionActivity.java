package com.example.androidgui.ManagerActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.*;

public class ManagerPickActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_pick_action);
    }

    public void ManageMenu(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, ManageMenuActivity.class);
        startActivity(intent);
    }

    public void SeeMenu(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, SeeMenuActivity.class);
        startActivity(intent);
    }

    public void SeeReview(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, SeeReviewActivity.class);
        startActivity(intent);
    }

    public void DeleteReview(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, DeleteReviewActivity.class);
        startActivity(intent);
    }

    public void AddStaff(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, AddStaffActivity.class);
        startActivity(intent);
    }

    public void selectExit(View v) {
        Intent intent = new Intent(ManagerPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }

}