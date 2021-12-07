package com.example.android.customer_activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.android.MainActivity;
import com.example.android.R;
import com.example.android.menu_activities.SeeMenuActivity;
import com.example.android.order_activities.SelectDineInTakeOutActivity;
import com.example.android.review_activities.AddReviewCommentActivity;

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
    /**
     * Moving to the menu page.
     * @param v view
     */
    public void selectSeeMenu(@SuppressWarnings("unused") View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, SeeMenuActivity.class);
        startActivity(intent);
    }
    /**
     * Moving to the placing order page.
     * @param v view
     */
    public void selectPlaceOrder(@SuppressWarnings("unused") View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, SelectDineInTakeOutActivity.class);
        startActivity(intent);
    }
    /**
     * Moving to the add review page.
     * @param v view
     */
    public void selectAddReview(@SuppressWarnings("unused") View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, AddReviewCommentActivity.class);
        startActivity(intent);
    }
    /**
     * Moving to the main page, exit current.
     * @param v view
     */
    public void selectExit(@SuppressWarnings("unused") View v) {
        Intent intent = new Intent(CustomerPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}