package com.example.androidgui.useractivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.deliverystaffactivities.DeliverOrderActivity;

import com.example.androidgui.inventoryactivities.InventoryStarterActivity;
import com.example.androidgui.kitchenactivities.KitchenActivity;
import com.example.androidgui.R;
import constant.mangersystem.UserType;
import constant.uimessage.EnrollUserMessage;
import constant.uimessage.LoginLogoutUIMessage;
import constant.uimessage.LoginResult;
import presenter.loginsystem.LoginController;
import use_case.boundary.output.LoginOutputBoundary;

import java.lang.reflect.GenericDeclaration;

public class LoginActivity extends AppCompatActivity implements LoginOutputBoundary {

    private LoginController controller;
    private EditText editTextUserId;
    private EditText editTextPassword;
    private LoginResult loginResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.controller = new LoginController();
        this.controller.createUseCaseInteractor(LoginActivity.this);

        editTextUserId = findViewById(R.id.editTextUserId);
        editTextPassword = findViewById(R.id.editTextPassword);

        editTextUserId.setFocusable(true);
        editTextPassword.setText("");

    }

    /**
     * Execute login button onClick action
     *
     * @param view current Android view
     */
    public void runLogin(View view) {
        if (!isAllInfoFilled()) {
            setEmptyErrorMessage(editTextUserId);
            setEmptyErrorMessage(editTextPassword);
        } else {
            String id = editTextUserId.getText().toString();
            this.controller.runLogin(id, editTextPassword.getText().toString());
            switch (this.loginResult) {
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
    }

    /**
     * Return ture if and only if both user id and password EditText are filled in.
     *
     * @return true iff both user id and password EditText are filled in.
     */
    private boolean isAllInfoFilled() {
        return editTextUserId.getText().toString().trim().length() > 0 &&
                editTextPassword.getText().toString().trim().length() > 0;
    }

    /**
     * Add error message on EditText that is not filled.
     *
     * @param editText that are required to be fille.
     */
    private void setEmptyErrorMessage(EditText editText) {
        if (editText.getText().toString().trim().length() <= 0)
            editText.setError(EnrollUserMessage.INFO_REQUIRED);
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
        Intent intent = new Intent(LoginActivity.this, (Class<?>) factoryMethod(id));
        startActivity(intent);
    }

    /**
     * Pop-up alert to user for login failed, requires proper password.
     */
    private void loginFailed() {
        showAlertDialogOneBtn(LoginLogoutUIMessage.LOGIN_FAILED, LoginLogoutUIMessage.LOGIN_FAILED_MESSAGE);
        //clear content of password TextView and auto-focus on it
        editTextPassword.setText("");
        editTextPassword.setFocusable(true);
    }

    /**
     * Pop-up alert to user for login failed, requires sign up for staff first.
     */
    private void userNotFound() {
        showAlertDialogOneBtn(LoginLogoutUIMessage.SIGN_UP, LoginLogoutUIMessage.STAFF_SIGNUP);
        //clear content of TextViews
        editTextUserId.setText("");
        editTextPassword.setText("");
        editTextUserId.setFocusable(true);
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
    private GenericDeclaration factoryMethod(String id) {
        UserType loginUserType = this.controller.getUserTypeById(id);
        switch (loginUserType) {
            case CUSTOMER:
                return CustomerPickActionActivity.class;
            case MANAGER:
//              return ManagerActivity.class;
            case DELIVERY_STAFF:
                return DeliverOrderActivity.class;
            case KITCHEN:
                return KitchenActivity.class;
            case INVENTORY_STAFF:
                return InventoryStarterActivity.class;
            case SERVING_STAFF:
//                return ServeDishActivity.class;
        }
        return LoginActivity.class;
    }

    @Override
    public void presentLoginResult(LoginResult result) {
        this.loginResult = result;
    }

    //TODO this method to be relocated to manager activity
    public void enrollStaff(View view) {
        Intent intent = new Intent(LoginActivity.this, EnrollUserActivity.class);
        startActivity(intent);
    }
}