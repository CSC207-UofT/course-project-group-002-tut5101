package com.example.android.user_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import com.example.android.manager_activities.ManagerPickActionActivity;
import constant.manager_system.EnrollUserMessage;
import constant.login_system.LoginLogoutUIMessage;
import presenter.user_system.EnrollStaffPresenter;
import presenter.user_system.view_interfaces.EnrollStaffViewInterface;

/**
 * Activity class for enrolling new staff.
 */
@SuppressWarnings("SameParameterValue")
public class EnrollStaffActivity extends AppCompatActivity implements EnrollStaffViewInterface {

    private EditText editTextUserId;
    private EditText editTextUserName;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private NumberPicker numPickerUserType;

    private EnrollStaffPresenter enrollStaffPresenter;
    private String newUserId;

    /**
     * On create method.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_staff);

        enrollStaffPresenter = new EnrollStaffPresenter();
        enrollStaffPresenter.setViewInterface(this);

        editTextUserId = findViewById(R.id.editTextNewUserId);
        editTextUserName = findViewById(R.id.editTextNewUserName);
        editTextPassword = findViewById(R.id.editTextNewUserPassword);
        editTextConfirmPassword = findViewById(R.id.editTextNewUserConfirmPassword);
        numPickerUserType = findViewById(R.id.numPickerUserType);


        generateRequiredInfo();

    }

    /**
     * Get required information for new user, including user id and options of user type.
     */
    private void generateRequiredInfo() {
        enrollStaffPresenter.getNewUserId();
        enrollStaffPresenter.getStaffTypes();
    }

    /**
     * ViewInterface method implementation
     *
     * @param id id of new user.
     */
    @Override
    public void setNewUserId(String id) {
        editTextUserId.setText(id);
        newUserId = id;
    }

    /**
     * ViewInterface method implementation
     *
     * @param staffTypes string array of staff types
     */
    @Override
    public void setAvailStaffTypeOptions(String[] staffTypes) {
        numPickerUserType.setDisplayedValues(staffTypes);
        numPickerUserType.setMinValue(0);
        numPickerUserType.setMaxValue(staffTypes.length - 1);
        numPickerUserType.setWrapSelectorWheel(false);
    }

    /**
     * Enroll Button onClick listener
     *
     * @param view android view
     */
    public void enrollNewUser(View view) {
        //Info are not all filled
        if (!isAllInfoFilled()) {
            setEmptyErrorMessage(editTextUserName);
            setEmptyErrorMessage(editTextPassword);
            setEmptyErrorMessage(editTextConfirmPassword);
        }
        //Password does not match
        else if (!isConfirmPasswordMatch()) {
            showAlertDialogOneBtn(EnrollUserMessage.PASSWORD_NOT_MATCH, EnrollUserMessage.PASSWORD_NOT_MATCH_MESSAGE);
            editTextPassword.setText("");
            editTextConfirmPassword.setText("");
            editTextPassword.setFocusable(true);
        } else {
            enroll();
        }
    }

    /**
     * Enroll new staff information and pop-up succeed dialog.
     */
    private void enroll() {
        enrollStaffPresenter.enrollNewUser(editTextUserId.getText().toString(),
                editTextUserName.getText().toString(),
                editTextPassword.getText().toString(),
                numPickerUserType.getDisplayedValues()[numPickerUserType.getValue()]);

        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(EnrollUserMessage.SUCCEED)
                .setMessage(EnrollUserMessage.ENROLL_SUCCEED_MESSAGE + this.newUserId)
                .setPositiveButton(LoginLogoutUIMessage.OK, (dialog, which) -> {
                    Intent intent = new Intent(getApplicationContext(), ManagerPickActionActivity.class);
                    startActivity(intent);
                })
                .create();
        alertDlg.show();
    }

    /**
     * Pop-up alert dialog with one OK button for title problem and display detail message
     *
     * @param title   alert dialog title
     * @param message detail message for alert dialog
     */
    private void showAlertDialogOneBtn(String title, String message) {
        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(LoginLogoutUIMessage.OK, (dialog, which) -> dialog.dismiss())
                .create();
        alertDlg.show();
    }

    /**
     * Set error message for EditText that required to be filled.
     *
     * @param editText that required to be filled.
     */
    private void setEmptyErrorMessage(EditText editText) {
        if (editText.getText().toString().trim().length() == 0)
            editText.setError(EnrollUserMessage.INFO_REQUIRED);
    }

    /**
     * Return true iff user entered passwords matches with each other.
     *
     * @return true iff password matches
     */
    private boolean isConfirmPasswordMatch() {
        return editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString());
    }

    /**
     * Return true iff all EditText are filled as required.
     *
     * @return true iff all EditText are filled.
     */
    private boolean isAllInfoFilled() {
        return editTextUserName.getText().toString().trim().length() > 0 &&
                editTextPassword.getText().toString().trim().length() > 0 &&
                editTextConfirmPassword.getText().toString().trim().length() > 0;
    }

    /**
     * Display AlertDialog to ask user confirm enrollment cancelling.
     *
     * @param view android view
     */
    public void cancelUserEnroll(View view) {
        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(EnrollUserMessage.ARE_YOU_SURE)
                .setMessage(EnrollUserMessage.CANCEL_ENROLLMENT)
                .setPositiveButton(EnrollUserMessage.YES, (dialog, which) -> finish())
                .setNegativeButton(EnrollUserMessage.NO, (dialog, which) -> dialog.dismiss())
                .create();
        alertDlg.show();
    }
}