package com.example.android.serving_staff_activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.MainActivity;
import com.example.android.R;

/**
 * Activity class for the serving staff to pick action.
 */
public class ServingStaffPickActionActivity extends AppCompatActivity {
    private String id;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servingstaff_pick_action);
        TextView header = findViewById(R.id.header);
        header.setText(R.string.serve_dish_header);
        // Get id for further use
        Bundle b = getIntent().getExtras();
        if(b != null) {
            id = b.getString("id");
        }
    }
    /**
     * When the user selects to get the next dish, try to get a dish to be delivered.
    */
    public void selectGetNextDish(View v) {
        Intent intent = new Intent(ServingStaffPickActionActivity.this, ServeDishActivity.class);
        Bundle b = new Bundle();
        b.putString("id", this.id); //Your id
        b.putString("action", "GET_NEXT");
        intent.putExtras(b); //Put your id to next activity
        startActivity(intent);
    }
    /**
     * When the user selects to check the current dish, show the current dish to be served.
     */
    public void seeCurrentDish(View v) {
        Intent intent = new Intent(ServingStaffPickActionActivity.this, ServeDishActivity.class);
        Bundle b = new Bundle();
        b.putString("id", this.id); //Your id
        b.putString("action", "VIEW_CURRENT");
        intent.putExtras(b); //Put your id to next activity
        startActivity(intent);
    }
    /**
     * When selected Exit, return to log in activity.
     */
    public void selectExit(View v) {
        Intent intent = new Intent(ServingStaffPickActionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
