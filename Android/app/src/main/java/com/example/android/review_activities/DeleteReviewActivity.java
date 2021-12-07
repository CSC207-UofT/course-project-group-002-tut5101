package com.example.android.review_activities;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import constant.manager_system.ManagerDecision;
import constant.manager_system.ReviewMessage;
import constant.manager_system.ManagerUIMessage;
import presenter.review_system.DeleteReviewPresenter;


/**
 *
 * Activity class for deleting reviews.
 */
@SuppressWarnings("unused")
public class DeleteReviewActivity extends AppCompatActivity {
    private NumberPicker selectAction;
    private String[] managerDecision;
    private TextView askDeleteCriteria;
    private DeleteReviewPresenter deleteReviewPresenter;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_review);

        askDeleteCriteria = findViewById(R.id.askDeleteCriteria);
        selectAction = findViewById(R.id.selectAction);
        this.deleteReviewPresenter = new DeleteReviewPresenter();

        setupMessage();
        setupOptions();
    }


    /**
     * Set up the message for text.
     */
    private void setupMessage() {
        askDeleteCriteria.setText(ManagerUIMessage.DELETE_REVIEW);
    }

    /**
     * Set up manager options.
     */
    private void setupOptions(){
        managerDecision = new String[]{ManagerDecision.ONE.name(), ManagerDecision.TWO.name(),
                ManagerDecision.THREE.name()};
        selectAction.setDisplayedValues(managerDecision);
        selectAction.setMaxValue(managerDecision.length - 1);
        selectAction.setMinValue(0);
    }


    /**
     * Method to delete the reviews.
     *
     * @param v the current view
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void deleteReview(View v) {
        String action = managerDecision[selectAction.getValue()];
        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(ReviewMessage.CONFIRM)
                .setMessage(ReviewMessage.DELETE_REVIEW)
                .setPositiveButton(ReviewMessage.YES, (dialog, which) -> {
                    deleteReviewPresenter.decideReview(action);
                    finish();
                })
                .setNegativeButton(ReviewMessage.NO, (dialog, which) -> dialog.dismiss())
                .create();
        alertDlg.show();

    }

}