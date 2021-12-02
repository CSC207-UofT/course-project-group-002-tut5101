package com.example.androidgui.servingstaffactivities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.staffsystem.StaffPresenter;
import presenter.staffsystem.StaffViewInterface;

public class ServeDishActivity extends AppCompatActivity implements StaffViewInterface {
    private String id;
    private String mode;
    private StaffPresenter controller;
    private final TextView dishContent = findViewById(R.id.CurrentDish);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controller = new StaffPresenter();
        controller.setStaffView(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serve_dish);
        Bundle b = getIntent().getExtras();
        if(b != null) {
            id = b.getString("id");
            mode = b.getString("action");
        }
        // Get next dish to be delivered
        if (mode != null && mode.equals("GET_NEXT")) {
            Toast toast;
            try {
                controller.getNext(this.id);
            } catch (Exception e) {
                if (e.getMessage() != null && !e.getMessage().equals("Already has one dish in hands")) {
                    toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }
                goBackPickAction();
            }
        }
        // Display current dish to be delivered
        getCurrentDish();
    }
    /**
     * When select to complete the dish in hand, try to call completeCurrent
     */
    public void selectCompleteDish(View v) {
        try {
            controller.completeCurrent(this.id);
        } catch (Exception e) {
            exceptionHandler(e);
        }
        // After finishing the current order, first send a message saying that, then return to select action page
        Toast toast = Toast.makeText(getApplicationContext(), R.string.serve_dish_complete, Toast.LENGTH_SHORT);
        toast.show();
        goBackPickAction();
    }

    /**
     * When select to return to previous screen, send user back to pick action screen
     */
    public void selectReturn(View v) {
        goBackPickAction();
    }

    /**
     * Handle exceptions by displaying error message and return to previous page.
     * @param e Exception caught
     */
    private void exceptionHandler(Exception e) {
        // When exception, throw exception as toast then back to menu
        Toast toast;
        if (e.getMessage() != null && e.getMessage().equals("Already has one dish in hands")) {
            toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        } else if (e.getMessage() != null && e.getMessage().equals("No current dish to be displayed")) {
            toast = Toast.makeText(getApplicationContext(), R.string.no_current_dish, Toast.LENGTH_SHORT);
            toast.show();
            // Jump back to pick action page
            goBackPickAction();
        } else {
            toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
            // Jump back to pick action page
            goBackPickAction();
        }
    }

    private void getCurrentDish() {
        try {
            controller.displayCurrent(this.id);
        } catch (Exception e) {
            exceptionHandler(e);
        }
    }

    /**
     * Helper method for go back to pick action screen
     */
    private void goBackPickAction() {
        Intent intent = new Intent(ServeDishActivity.this, ServingStaffPickActionActivity.class);
        Bundle b;
        b = new Bundle();
        b.putString("id", this.id); //Your id
        intent.putExtras(b); //Put your id to next activity
        startActivity(intent);
    }

    @Override
    public void displayCurrentItem(String info) {
        dishContent.setText(info);
    }

    @Override
    public void setItemDestination(String destination) {
    }
}