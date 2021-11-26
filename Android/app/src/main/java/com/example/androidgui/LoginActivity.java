package com.example.androidgui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import constant.fileSystem.FileLocation;
import constant.uiMessage.LoginLogoutUIMessage;
import constant.uiMessage.LoginResult;
import controller.loginSystem.LoginController;
import gateway.SerReadWriter;
import use_case.boundary.output.LoginOutputBoundary;

public class LoginActivity extends AppCompatActivity implements LoginOutputBoundary {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void runLogin(View view) {
        LoginController controller = new LoginController();
        controller.createUseCaseInteractor(LoginActivity.this);

        TextView userIdText = findViewById(R.id.editTextUserId);
        TextView passwordText = findViewById(R.id.editTextPassword);

        String id = userIdText.getText().toString();
        String password = passwordText.getText().toString();

        SerReadWriter rw = new SerReadWriter();
        rw.readFromFile(FileLocation.USER_FILE_LOCATION);
//        switch (controller.runLogin(id, password)) {
//            case NO_SUCH_USER:
//                System.out.println("No such user");
//                break;
//            case FAILURE:
//                System.out.println("Failed");
//                break;
//            case SUCCESS:
//                System.out.println("Succeed");
//                break;
//            default:
//                System.out.println("... ...");
//                break;
//        }
    }

    @Override
    public LoginResult presentLoginResult(LoginResult result) {
        return result;
    }
}