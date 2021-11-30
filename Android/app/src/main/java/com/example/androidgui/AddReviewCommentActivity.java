package com.example.androidgui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import controller.reviewSystem.ReviewController;

public class AddReviewCommentActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText name;
    EditText ifAnonymous;
    EditText rate;
    EditText comment;
    EditText ifComplain;
    EditText complain;
    ReviewController rc = new ReviewController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review_comment);
        button = findViewById(R.id.bt1);
        name = findViewById(R.id.textInputEdit);
        ifAnonymous = findViewById(R.id.textInputEdit1);
        rate = findViewById(R.id.textInputEdit2);
        comment = findViewById(R.id.textInputEdit3);
        ifComplain = findViewById(R.id.textInputEdit4);
        complain = findViewById(R.id.textInputEdit5);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String iname = name.getText().toString();
        boolean iifAnonymous = ifAnonymous.getText().toString().equals("Y");
        int irate = Integer.parseInt(rate.getText().toString());
        String icomment = comment.getText().toString();
        boolean iifComplain = ifComplain.getText().toString().equals("Y");
        String icomplain = complain.getText().toString();
        rc.addToReviewList(iname,iifAnonymous, irate, icomment, iifComplain, icomplain);
//        rc.saveToFile();
    }
}