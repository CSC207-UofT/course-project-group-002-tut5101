package com.example.android.review_activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import presenter.review_system.view_interface.DisplayReviewViewInterface;
import presenter.review_system.ReviewPresenter;

/**
 * Activity class for the manager to see the reviews, and thus decide to delete the reviews or not.
 */
public class SeeReviewActivity extends AppCompatActivity implements DisplayReviewViewInterface {

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_review);

        ReviewPresenter reviewPresenter = new ReviewPresenter();
        reviewPresenter.setDisplayReviewViewInterface(this);

        reviewPresenter.reviewsInListAsString();
    }

    /**
     * Set the text to present
     * @param reviewsText texts of use_case.review.
     */
    public void setReviewsText(String reviewsText){
        TextView reviewText = new TextView(this);
        reviewText.setText(reviewsText);

        LinearLayout menuItemsLayout = findViewById(R.id.reviewsLayout);
        menuItemsLayout.addView(reviewText);
    }
}