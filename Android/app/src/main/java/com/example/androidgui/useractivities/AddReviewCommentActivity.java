package com.example.androidgui.useractivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;
import controller.ReviewController;

/**
 * Activity class for adding use_case.review.
 */
public class AddReviewCommentActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText name;
    EditText ifAnonymous;
    EditText rate;
    EditText comment;
    EditText id;
    final ReviewController rc = new ReviewController();

    /**
     *
     * @param savedInstanceState fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review_comment);
        button = findViewById(R.id.bt1);
        name = findViewById(R.id.textInputEdit);
        ifAnonymous = findViewById(R.id.textInputEdit1);
        rate = findViewById(R.id.textInputEdit2);
        comment = findViewById(R.id.textInputEdit3);
        id = findViewById(R.id.textInputEdit4);
        button.setOnClickListener(this);
    }

    /**
     * Clicking response.
     * @param v view.
     */
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        boolean iifAnonymous = ifAnonymous.getText().toString().equals("Y");
        int irate = Integer.parseInt(rate.getText().toString());
        String icomment = comment.getText().toString();
        String identity = id.getText().toString();
        rc.addToReviewList(iname,iifAnonymous, irate, icomment, identity);
//        rc.saveToFile();
    }
}