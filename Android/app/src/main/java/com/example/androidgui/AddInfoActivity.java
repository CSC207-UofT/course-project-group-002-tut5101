package com.example.androidgui;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddInfoActivity extends AppCompatActivity {
    EditText Name, Email;
    String name;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        Name = (EditText)findViewById(R.id.et_name);
        Email = (EditText)findViewById(R.id.et_email);
    }

    public void saveInfo(View view){
        name = Name.getText().toString();
        email = Email.getText().toString();
    }

//    class BackgroundTask extends AsyncTask<void, void, void>
}