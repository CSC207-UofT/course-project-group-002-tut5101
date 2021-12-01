package com.example.androidgui.useractivities;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import presenter.menusystem.DisplayMenuViewInterface;
import presenter.menusystem.MenuPresenter;


public class SeeMenuActivity extends AppCompatActivity implements DisplayMenuViewInterface {
    private LinearLayout menuItemsLayout;
    private MenuPresenter menuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_menu);

        menuPresenter = new MenuPresenter();
        menuPresenter.setDisplayDishesViewInterface(this);

        menuPresenter.dishesInMenuAsString();

    }

    public void setMenuItemsText(String menuItems) {
        TextView menuItemsText = new TextView(this);
        menuItemsText.setText(menuItems);

        menuItemsLayout = findViewById(R.id.menuItemsLayout);
        menuItemsLayout.addView(menuItemsText);
    }


}