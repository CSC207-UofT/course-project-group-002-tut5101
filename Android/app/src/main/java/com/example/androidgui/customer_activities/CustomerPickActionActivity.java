package com.example.androidgui.customer_activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.androidgui.MainActivity;
import com.example.androidgui.R;
import com.example.androidgui.menu_activities.SeeMenuActivity;
import com.example.androidgui.order_activities.SelectDineInTakeOutActivity;
import com.example.androidgui.review_activities.AddReviewCommentActivity;

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