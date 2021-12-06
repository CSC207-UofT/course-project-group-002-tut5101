package com.example.androidgui.manager_activities;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.manager_system.DisplayUsersViewInterface;
import presenter.manager_system.UserPresenter;

public class SeeUserActivity extends AppCompatActivity implements DisplayUsersViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_user);

        UserPresenter userPresenter = new UserPresenter();
        userPresenter.setDisplayUsersViewInterface(this);
        userPresenter.displayUsersAsString();
    }

    /**
     * Setting the user list to display
     * @param userItems user items.
     */
    @Override
    public void setUserItemsText(String userItems) {
        TextView userItemsText = new TextView(this);
        userItemsText.setText(userItems);

        LinearLayout userItemLayout = findViewById(R.id.userItemLayout);
        userItemLayout.addView(userItemsText);

    }
}