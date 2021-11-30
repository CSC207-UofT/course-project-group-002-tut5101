package com.example.androidgui.manageractivities;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import controller.reviewsystem.ReviewController;

/**
 * Activity class for the manager to see the reviews, and thus decide to delete the reviews or not.
 */
public class SeeReviewActivity extends AppCompatActivity {

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_review);

        // Create a scroll view of the reviews in the reviewList
        ScrollView reviewItems = findViewById(R.id.reviewItems);

        // Get the review as text and add it to the scroll view
        TextView reviewText = new TextView(this);
        ReviewController reviewController = new ReviewController();
        reviewText.setText(reviewController.reviewsAsString());

        // Add reviews to scroll view
        reviewItems.addView(reviewText);
    }
}