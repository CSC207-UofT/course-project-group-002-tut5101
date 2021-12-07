package com.example.android.serving_staff_activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.R;
import presenter.delivery_system.CurrentItemPresenter;
import presenter.delivery_system.GetNextItemPresenter;
import presenter.delivery_system.view_interfaces.StaffViewInterface;

/**
 * Activity class for selecting dish.
 */
public class ServeDishActivity extends AppCompatActivity implements StaffViewInterface {
    private String id;
    private String mode;
    private CurrentItemPresenter currentDishPresenter;
    private GetNextItemPresenter getNextDishPresenter;
    private TextView dishContent;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serve_dish);
        // Setup view bonded attributes
        currentDishPresenter = new CurrentItemPresenter();
        getNextDishPresenter = new GetNextItemPresenter();
        currentDishPresenter.setStaffView(this);
        dishContent = findViewById(R.id.CurrentDish);
        // Get staff id for method calls
        Bundle b = getIntent().getExtras();
        if(b != null) {
            id = b.getString("id");
            mode = b.getString("action");
        }
        // Get next dish to be delivered if entered this screen
        if (mode != null && mode.equals("GET_NEXT")) {
            getNextDish();
        }
        // Display current dish to be delivered
        getCurrentDish();
    }

    /**
     * When select to complete the dish in hand, try to call completeCurrent
     */
    public void selectCompleteDish(View v) {
        try {
            currentDishPresenter.completeCurrent(this.id);
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
     * Put the current item(dish) information to user's view
     * @param info Dish information
     */
    @Override
    public void displayCurrentItem(String info) {
        dishContent.setText(info);
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

    /**
     * Try to get the current dish to be served
     * Catch exceptions, if needed, handle them
     */
    private void getCurrentDish() {
        try {
            currentDishPresenter.displayCurrent(this.id);
        } catch (Exception e) {
            exceptionHandler(e);
        }
    }

    /**
     * Get next dish
     */
    private void getNextDish() {
        Toast toast;
        try {
            getNextDishPresenter.getNext(this.id);
            toast = Toast.makeText(getApplicationContext(), R.string.MessageNewDishArrived, Toast.LENGTH_SHORT);
            toast.show();
        } catch (Exception e) {
            if (e.getMessage() != null && !e.getMessage().equals("Already has one dish in hands")) {
                toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
            goBackPickAction();
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
}