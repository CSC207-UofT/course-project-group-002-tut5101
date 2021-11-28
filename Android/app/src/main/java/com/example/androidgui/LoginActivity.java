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

        userIdText.setFocusable(true);
        //TODO need test in different jumps
        passwordText.setText("");

    }

    /**
     * Execute login button onClick action
     *
     * @param view current Android view
     */
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
                userNotFound();
        }
    }

    /**
     * Display Toast message at bottom of device that login success, then jump to activity corresponding the UserType of
     * the login user.
     *
     * @param id the user id of the login user
     */
    private void loginSucceed(String id) {
        Toast toast = Toast.makeText(getApplicationContext(), LoginLogoutUIMessage.LOGIN_SUCCEED, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(LoginActivity.this, factoryMethod(id));
        startActivity(intent);
    }

    /**
     * Pop-up alert to user for login failed, requires proper password.
     */
    private void loginFailed() {
        showAlertDialogOneBtn(LoginLogoutUIMessage.LOGIN_FAILED, LoginLogoutUIMessage.LOGIN_FAILED_MESSAGE);
        //clear content of password TextView and auto-focus on it
        passwordText.setText("");
        passwordText.setFocusable(true);
    }

    /**
     * Pop-up alert to user for login failed, requires sign up for staff first.
     */
    private void userNotFound() {
        showAlertDialogOneBtn(LoginLogoutUIMessage.SIGN_UP, LoginLogoutUIMessage.STAFF_SIGNUP);
        //clear content of TextViews
        userIdText.setText("");
        passwordText.setText("");
        userIdText.setFocusable(true);
    }

    /**
     * Pop-up alert dialog with one OK button for title problem and display detail message
     *
     * @param title   alert dialog title
     * @param message detail message for alert dialog
     */
    private void showAlertDialogOneBtn(String title, String message) {
        AlertDialog alertDlg = new AlertDialog.Builder(LoginActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(LoginLogoutUIMessage.OK, (dialog, which) -> dialog.dismiss())
                .create();
        alertDlg.show();
    }


    /**
     * Helper method that returns proper Activity.class based on user type.
     *
     * @param id the user id
     * @return Activity.class of the login user to jump to
     */
    //TODO fill in activity.class
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

    public void enrollStaff(View view) {
        Intent intent = new Intent(LoginActivity.this, EnrollUserActivity.class);
        startActivity(intent);
    }
}