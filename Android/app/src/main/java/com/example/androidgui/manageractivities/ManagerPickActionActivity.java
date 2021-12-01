package com.example.androidgui.manageractivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.MainActivity;
import com.example.androidgui.R;
import com.example.androidgui.useractivities.SeeMenuActivity;

/**
 * Activity class for the manager the pick the activities he or she wants to do.
 *
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
    public void ManageMenu(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, ManageMenuActivity.class);
        startActivity(intent);
    }


    /**
     * Manager decides to see menu.
     *
     * @param v view
     */
    public void SeeMenu(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, SeeMenuActivity.class);
        startActivity(intent);
    }


    /**
     * Manager decides to see reviews.
     *
     * @param v view
     */
    public void SeeReview(View v){
        Intent intent = new Intent(ManagerPickActionActivity.this, SeeReviewActivity.class);
        startActivity(intent);
    }


    /**
     * Manager decides to delete reviews.
     *
     * @param v view
     */
    public void DeleteReview(View v){
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

}