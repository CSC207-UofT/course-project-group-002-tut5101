package com.example.android.manager_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.MainActivity;
import com.example.android.R;
import com.example.android.menu_activities.ManageMenuActivity;
import com.example.android.menu_activities.SeeMenuActivity;
import com.example.android.review_activities.DeleteReviewActivity;
import com.example.android.review_activities.SeeReviewActivity;
import com.example.android.user_activities.EnrollStaffActivity;
import com.example.android.user_activities.SeeUserActivity;

/**
 * Activity class for the manager the pick the activities he or she wants to do.
 */
public class ManagerPickActionActivity extends AppCompatActivity {


    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_pick_action);
    }

    /**
     * Manager decides to manage menu.
     *
     * @param v view
     */
    public void ManageMenu(View v) {
        Intent intent = new Intent(ManagerPickActionActivity.this, ManageMenuActivity.class);
        startActivity(intent);
    }


    /**
     * Manager decides to see menu.
     *
     * @param v view
     */
    public void SeeMenu(View v) {
        Intent intent = new Intent(ManagerPickActionActivity.this, SeeMenuActivity.class);
        startActivity(intent);
    }


    /**
     * Manager decides to see reviews.
     *
     * @param v view
     */
    public void SeeReview(View v) {
        Intent intent = new Intent(ManagerPickActionActivity.this, SeeReviewActivity.class);
        startActivity(intent);
    }


    /**
     * Manager decides to delete reviews.
     *
     * @param v view
     */
    public void DeleteReview(View v) {
        Intent intent = new Intent(ManagerPickActionActivity.this, DeleteReviewActivity.class);
        startActivity(intent);
    }


    /**
     * Manager decides exit log in.
     *
     * @param v view
     */
    public void selectExit(View v) {
        Intent intent = new Intent(ManagerPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Manager enroll new staff
     *
     * @param view view
     */
    public void enrollStaff(View view) {
        Intent intent = new Intent(this, EnrollStaffActivity.class);
        startActivity(intent);
    }

    /**
     * Back to main activity
     *
     * @param view view
     */
    public void backToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Display user list
     *
     * @param view view
     */
    public void displayUserList(View view) {
        Intent intent = new Intent(this, SeeUserActivity.class);
        startActivity(intent);
    }
}