package com.example.android.delivery_staff_activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.R;
import presenter.delivery_system.view_interfaces.GeoDestination;
import presenter.delivery_system.CurrentItemPresenter;
import presenter.delivery_system.GetNextItemPresenter;
import presenter.delivery_system.view_interfaces.StaffViewInterface;

import java.util.Objects;

/**
 * Activity class for delivering order.
 */
public class DeliverOrderActivity extends AppCompatActivity implements StaffViewInterface, GeoDestination {
    private String id;
    private String mode;
    private CurrentItemPresenter getCurrentOrderPresenter;
    private GetNextItemPresenter getNextOrderPresenter;
    private TextView currentOrder;
    private String destination;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_order);
        // Setup view bonded attributes
        getCurrentOrderPresenter = new CurrentItemPresenter();
        getNextOrderPresenter = new GetNextItemPresenter();
        getCurrentOrderPresenter.setStaffView(this);
        currentOrder = findViewById(R.id.CurrentOrder);
        // Get id for method calls
        Bundle b = getIntent().getExtras();
        if(b != null) {
            id = b.getString("id");
            mode = b.getString("action");
        }
        // Get next order to be delivered
        if (mode != null && mode.equals("GET_NEXT")) {
            getNextOrder();
        }
        // Display current order to be delivered
        currentOrder = findViewById(R.id.CurrentOrder);
        getCurrentOrder();
    }

    /**
     * Private procedure, get The next order
     */
    private void getNextOrder() {
        Toast toast;
        try {
            getNextOrderPresenter.getNext(this.id);
        } catch (Exception e) {
            if (e.getMessage() != null && !e.getMessage().equals("Already has one order in hands")) {
                toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
            goBackPickAction();
        }
    }

    /**
     * Get the current order to be delivered
     */
    private void getCurrentOrder() {
        try {
            getCurrentOrderPresenter.displayCurrent(this.id);
        } catch (Exception e) {
            exceptionHandler(e);
        }
    }

    /**
     * Launch Google Maps to show directions
     */
    @SuppressWarnings("unused")
    public void selectShowMap(View v) {
        getCurrentOrder();
        Uri gmmIntentUri;
        if (Objects.equals(destination, "")) {
            gmmIntentUri = Uri.parse("geo:43.749371,-79.475563?q=University of Toronto, Toronto, ON, Canada");
        } else {
            gmmIntentUri = Uri.parse("geo:43.749371,-79.475563?q=" + destination);
        }
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    /**
     * When select to finish the order in hand, try to call completeCurrent
     */
    @SuppressWarnings("unused")
    public void selectFinishOrder(View v) {
        try {
            getCurrentOrderPresenter.completeCurrent(this.id);
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
    @SuppressWarnings("unused")
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

    /**
     * Display the information of the current order on view
     * @param info The content of the order
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void displayCurrentItem(String info) {
        currentOrder.setText("Address: " + destination + "\n" + info);
    }

    /**
     * Set destination of the order
     * @param destination Destination of the order, real address
     */
    @Override
    public void setItemDestination(String destination) {
        this.destination = destination;
    }
}