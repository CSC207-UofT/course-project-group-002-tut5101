package com.example.androidgui.manageractivities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import presenter.reviewsystem.DisplayReviewViewInterface;
import presenter.reviewsystem.ReviewPresenter;

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
     *
     * @param reviewsText texts of review.
     */
    public void setReviewsText(String reviewsText){
        TextView reviewText = new TextView(this);
        reviewText.setText(reviewsText);

        LinearLayout menuItemsLayout = findViewById(R.id.reviewsLayout);
        menuItemsLayout.addView(reviewText);
    }
}