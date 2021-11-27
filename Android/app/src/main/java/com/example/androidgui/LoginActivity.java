package com.example.androidgui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import constant.mangerSystem.UserType;
import constant.uiMessage.LoginLogoutUIMessage;
import constant.uiMessage.LoginResult;
import controller.loginSystem.LoginController;
import use_case.boundary.output.LoginOutputBoundary;

public class LoginActivity extends AppCompatActivity implements LoginOutputBoundary {

    private LoginController controller;
    private TextView userIdText;
    private TextView passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.controller = new LoginController();
        this.controller.createUseCaseInteractor(LoginActivity.this);

        userIdText = findViewById(R.id.editTextUserId);
        passwordText = findViewById(R.id.editTextPassword);

        //TODO need test in different jumps
        passwordText.setText("");
    }

    public void runLogin(View view) {


        String id = userIdText.getText().toString();
        String password = passwordText.getText().toString();
        switch (this.controller.runLogin(id, password)) {
            case FAILURE:
                loginFailed();
                break;
            case SUCCESS:
                loginSucceed(id);
                break;
            default:
                register();
        }
    }

    private void register() {
    }

    private void loginFailed() {
        showAlertDialog();
        passwordText.setText("");
        passwordText.setFocusable(true);
    }

    private void showAlertDialog() {
        AlertDialog alertDlg = new AlertDialog.Builder(LoginActivity.this)
                .setTitle(LoginLogoutUIMessage.LOGIN_FAILED)
                .setMessage(LoginLogoutUIMessage.LOGIN_FAILED_MESSAGE)
                .setPositiveButton(LoginLogoutUIMessage.OK, (dialog, which) -> dialog.dismiss())
                .create();
        alertDlg.show();
    }

    private void loginSucceed(String id) {
        Toast toast = Toast.makeText(getApplicationContext(),LoginLogoutUIMessage.LOGIN_SUCCEED, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(LoginActivity.this, factoryMethod(id));
        startActivity(intent);
    }

    private Class factoryMethod(String id) {
        UserType loginUserType = this.controller.getUserTypeById(id);
        switch (loginUserType) {
            case CUSTOMER:
                return CustomerPickActionActivity.class;
            case MANAGER:
//                return ManagerActivity.class;
            case DELIVERY_STAFF:
                return DeliverOrderActivity.class;
            case KITCHEN:
                return KitchenActivity.class;
            case INVENTORY_STAFF:
//                return InventoryActivity.class;
            case SERVING_STAFF:
//                return ServingActivity.class;
        }
        return LoginActivity.class;
    }

    @Override
    public LoginResult presentLoginResult(LoginResult result) {
        return result;
    }
}