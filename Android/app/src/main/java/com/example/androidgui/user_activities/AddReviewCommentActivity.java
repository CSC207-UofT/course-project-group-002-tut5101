package com.example.androidgui.user_activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import presenter.review_system.AddReviewPresenter;

/**
 * Activity class for adding use_case.review.
 */
public class AddReviewCommentActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText editTextName;
    EditText editTextIfAnonymous;
    EditText editTextRate;
    EditText editTextComment;
    private AddReviewPresenter rc;

    /**
     *
     * @param savedInstanceState fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rc = new AddReviewPresenter();
        setContentView(R.layout.activity_add_review_comment);
        button = findViewById(R.id.bt1);
        editTextName = findViewById(R.id.textInputEdit);
        editTextIfAnonymous = findViewById(R.id.textInputEdit1);
        editTextRate = findViewById(R.id.textInputEdit2);
        editTextComment = findViewById(R.id.textInputEdit3);
        button.setOnClickListener(this);
    }

    /**
     * Clicking response.
     * @param v view.
     */
    @Override
    public void onClick(View v) {
        String name = editTextName.getText().toString();
        boolean iifAnonymous = editTextIfAnonymous.getText().toString().equals("Y");
        int irate = Integer.parseInt(editTextRate.getText().toString());
        String comment = editTextComment.getText().toString();
        rc.addToReviewList(name,iifAnonymous, irate, comment);
        finish();
    }
}