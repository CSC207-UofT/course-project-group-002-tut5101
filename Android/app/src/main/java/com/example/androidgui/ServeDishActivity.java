package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import controller.staffSystem.StaffController;

public class ServeDishActivity extends AppCompatActivity {
    private String id;
    private StaffController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controller = new StaffController();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serve_dish);
        // Get id for method calls
        Bundle b = getIntent().getExtras();
        if (b != null)
            id = b.getString("id");
        // Get next dish to be served
        try {
            controller.getNext(this.id);
        } catch (Exception e) {
            exceptionHandler(e);
            return;
        }
        // Display current dish to be served
        TextView currentOrder = findViewById(R.id.CurrentDish);
        try {
            currentOrder.setText(controller.displayCurrent(this.id));
        } catch (Exception e) {
            exceptionHandler(e);
        }
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
        Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
        toast.show();
        // Jump back to pick action page
        goBackPickAction();
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
}