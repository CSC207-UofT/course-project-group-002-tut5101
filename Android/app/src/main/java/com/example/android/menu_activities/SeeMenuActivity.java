package com.example.android.menu_activities;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.R;
import presenter.menu_system.view_interface.DisplayMenuViewInterface;
import presenter.menu_system.MenuPresenter;

/**
 * Activity class for seeing menu
 */
public class SeeMenuActivity extends AppCompatActivity implements DisplayMenuViewInterface {
    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_menu);

        MenuPresenter menuPresenter = new MenuPresenter();
        menuPresenter.setDisplayDishesViewInterface(this);

        menuPresenter.dishesInMenuAsString();

    }

    /**
     * Setting the next item
     * @param menuItems menu items.
     */
    public void setMenuItemsText(String menuItems) {
        TextView menuItemsText = new TextView(this);
        menuItemsText.setText(menuItems);

        LinearLayout menuItemsLayout = findViewById(R.id.menuItemsLayout);
        menuItemsLayout.addView(menuItemsText);
    }


}