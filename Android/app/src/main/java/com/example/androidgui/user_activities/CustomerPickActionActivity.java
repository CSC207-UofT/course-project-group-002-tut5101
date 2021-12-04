package com.example.androidgui.user_activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.androidgui.MainActivity;
import com.example.androidgui.R;
import com.example.androidgui.order_activities.SelectDineInTakeOutActivity;

/**
 * Activity class for the customer to pick action.
 */
public class CustomerPickActionActivity extends AppCompatActivity {

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pick_action);

    }

    public void selectSeeMenu(View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, SeeMenuActivity.class);
        startActivity(intent);
    }

    public void selectPlaceOrder(View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, SelectDineInTakeOutActivity.class);
        startActivity(intent);
    }

    public void selectAddReview(View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, AddReviewCommentActivity.class);
        startActivity(intent);
    }

    public void selectExit(View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}