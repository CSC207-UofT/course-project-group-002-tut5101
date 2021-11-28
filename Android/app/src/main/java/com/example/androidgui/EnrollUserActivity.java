package com.example.androidgui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import constant.uiMessage.EnrollUserMessage;
import constant.uiMessage.LoginLogoutUIMessage;
import controller.managerSystem.ManagerController;
import use_case.boundary.output.EnrollUserOutputBoundary;

public class EnrollUserActivity extends AppCompatActivity implements EnrollUserOutputBoundary {

    private EditText editTextUserId;
    private EditText editTextUserName;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private EditText editNumSalary;
    private NumberPicker numPickerUserType;

    ManagerController managerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_user);

        managerController = new ManagerController();
        managerController.setEnrollUserOutputBoundary(this);

        editTextUserId = findViewById(R.id.editTextNewUserId);
        editTextUserName = findViewById(R.id.editTextNewUserName);
        editTextPassword = findViewById(R.id.editTextNewUserPassword);
        editTextConfirmPassword = findViewById(R.id.editTextNewUserConfirmPassword);
        numPickerUserType = findViewById(R.id.numPickerUserType);
        editNumSalary = findViewById(R.id.editNumSalary);

        generateRequiredInfo();

    }

    private void generateRequiredInfo() {
        managerController.getNewUserId();
        managerController.getStaffTypes();
    }

    @Override
    public void setNewUserId(String id) {
        editTextUserId.setText(id);
    }

    @Override
    public void setNumPickerUserType(String[] staffTypes, int maxValue) {
        numPickerUserType.setDisplayedValues(staffTypes);
        numPickerUserType.setMinValue(0);
        numPickerUserType.setMaxValue(maxValue);
        numPickerUserType.setWrapSelectorWheel(false);
    }

    public void enrollNewUser(View view) {
        //Info are not all filled
        if (!isAllInfoFilled()) {
            setEmptyErrorMessage(editTextUserName);
            setEmptyErrorMessage(editTextPassword);
            setEmptyErrorMessage(editTextConfirmPassword);
            setEmptyErrorMessage(editNumSalary);
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

    private void enroll() {
        managerController.enrollNewUser(editTextUserId.getText().toString(),
                editTextUserName.getText().toString(),
                editTextPassword.getText().toString(),
                numPickerUserType.getDisplayedValues()[numPickerUserType.getValue()],
                editNumSalary.getText().toString());

        AlertDialog alertDlg = new AlertDialog.Builder(this)
                .setTitle(EnrollUserMessage.SUCCEED)
                .setMessage(EnrollUserMessage.ENROLL_SUCCEED_MESSAGE)
                .setPositiveButton(LoginLogoutUIMessage.OK, (dialog, which) -> {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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

    private void setEmptyErrorMessage(EditText editText) {
        if (TextUtils.isEmpty(editText.getText()))
            editText.setError(EnrollUserMessage.INFO_REQUIRED);
    }

    private boolean isConfirmPasswordMatch() {
        return editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString());
    }

    private boolean isAllInfoFilled() {
        return editTextUserName.getText().toString().trim().length() > 0 &&
                editTextPassword.getText().toString().trim().length() > 0 &&
                editTextConfirmPassword.getText().toString().trim().length() > 0 &&
                editNumSalary.getText().toString().trim().length() > 0;
    }

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