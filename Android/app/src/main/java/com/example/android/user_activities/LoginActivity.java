package com.example.android.user_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import com.example.android.customer_activities.CustomerPickActionActivity;
import com.example.android.delivery_staff_activities.DeliveryStaffPickActionActivity;
import com.example.android.inventory_activities.InventoryStarterActivity;
import com.example.android.kitchen_activities.CurrentOrderDishesActivity;
import com.example.android.manager_activities.ManagerPickActionActivity;
import com.example.android.serving_staff_activities.ServingStaffPickActionActivity;
import constant.manager_system.UserType;
import constant.manager_system.EnrollUserMessage;
import constant.login_system.LoginLogoutUIMessage;
import constant.login_system.LoginResult;
import presenter.login_system.LoginPresenter;
import presenter.login_system.LoginViewInterface;

import java.lang.reflect.GenericDeclaration;

/**
 * Android Activity implementing login function
 */
public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    private LoginPresenter loginPresenter;
    private EditText editTextUserId;
    private EditText editTextPassword;
    private LoginResult loginResult;
    private UserType loginUserType;

    /**
     * On create method
     *
     * @param savedInstanceState android state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginPresenter = new LoginPresenter();
        this.loginPresenter.setViewInterface(LoginActivity.this);

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
            this.loginPresenter.runLogin(id, editTextPassword.getText().toString());
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
     * @param editText that are required to be filled.
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
        //Pass id to next activity after login
        Bundle b = new Bundle();
        b.putString("id", id);
        intent.putExtras(b);
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
     * Helper method that returns proper Activity. class based on user type.
     *
     * @param id the user id
     * @return Activity.class of the login user to jump to
     */
    private GenericDeclaration factoryMethod(String id) {
        this.loginPresenter.getUserTypeById(id);
        switch (loginUserType) {
            case CUSTOMER:
                return CustomerPickActionActivity.class;
            case MANAGER:
              return ManagerPickActionActivity.class;
            case DELIVERY_STAFF:
                return DeliveryStaffPickActionActivity.class;
            case KITCHEN:
                return CurrentOrderDishesActivity.class;
            case INVENTORY_STAFF:
                return InventoryStarterActivity.class;
            case SERVING_STAFF:
                return ServingStaffPickActionActivity.class;
        }
        return LoginActivity.class;
    }

    /**
     * ViewInterface method implementation
     *
     * @param userType user type
     */
    @Override
    public void setUserType(UserType userType) {
        this.loginUserType = userType;
    }

    /**
     * ViewInterface method implementation
     *
     * @param result login result
     */
    @Override
    public void presentLoginResult(LoginResult result) {
        this.loginResult = result;
    }


}