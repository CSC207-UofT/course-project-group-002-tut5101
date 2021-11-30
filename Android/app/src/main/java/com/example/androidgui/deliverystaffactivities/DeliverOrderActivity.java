package com.example.androidgui.deliverystaffactivities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import controller.staffsystem.StaffController;

public class DeliverOrderActivity extends AppCompatActivity {
    private String id;
    private String mode;
    private StaffController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controller = new StaffController();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_order);
        // Get id for method calls
        Bundle b = getIntent().getExtras();
        if(b != null) {
            id = b.getString("id");
            mode = b.getString("action");
        }
        // Get next order to be delivered
        if (mode.equals("GET_NEXT")) {
            Toast toast;
            try {
                controller.getNext(this.id);
            } catch (Exception e) {
                if (e.getMessage() != null && !e.getMessage().equals("Already has one order in hands")) {
                    toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }
                goBackPickAction();
            }
        }
        // Display current order to be delivered
        TextView currentOrder = findViewById(R.id.CurrentOrder);
        try {
            currentOrder.setText(controller.displayCurrent(this.id));
        } catch (Exception e) {
            exceptionHandler(e);
        }
    }

    /**
     * Launch Google maps to show directions
     */
    public void selectShowMap(View v) {
        Uri gmmIntentUri = Uri.parse("geo:43.749371,-79.475563?q=University College, Toronto, ON, Canada");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    /**
     * When select to finish the order in hand, try to call completeCurrent
     */
    public void selectFinishOrder(View v) {
        try {
            controller.completeCurrent(this.id);
        } catch (Exception e) {
            exceptionHandler(e);
        }
        // After finishing the current order, first send a message saying that, then return to select action page
        Toast toast = Toast.makeText(getApplicationContext(), R.string.deliver_order_complete, Toast.LENGTH_SHORT);
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
        if (e.getMessage() != null && e.getMessage().equals("Already has one order in hands")) {
            toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        } else if (e.getMessage() != null && e.getMessage().equals("No current order to be displayed")) {
            toast = Toast.makeText(getApplicationContext(), R.string.no_current_order, Toast.LENGTH_SHORT);
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

    /**
     * Helper method for go back to pick action screen
     */
    private void goBackPickAction() {
        Intent intent = new Intent(DeliverOrderActivity.this, DeliveryStaffPickActionActivity.class);
        Bundle b;
        b = new Bundle();
        b.putString("id", this.id); //Your id
        intent.putExtras(b); //Put your id to next activity
        startActivity(intent);
    }

}