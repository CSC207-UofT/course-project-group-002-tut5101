package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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

    public void DeleteReview(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, DeleteReviewActivity.class);
        startActivity(intent);
    }

    public void AddStaff(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, AddStaffActivity.class);
        startActivity(intent);
    }

}