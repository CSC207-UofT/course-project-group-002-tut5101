package com.example.androidgui.ManagerActivities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidgui.R;

/**
 * Activity class for the manager to add a staff to the userList.
 *
 */
public class AddStaffActivity extends AppCompatActivity {

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
    }
}