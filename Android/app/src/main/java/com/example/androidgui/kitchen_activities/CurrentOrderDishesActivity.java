package com.example.androidgui.kitchen_activities;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import constant.file_system.FileName;
import entity.review.Review;
import presenter.kitchen_system.KitchenFacade;
import presenter.kitchen_system.KitchenPresenter;
import presenter.kitchen_system.KitchenView;
import use_case.review.ReviewList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class CurrentOrderDishesActivity extends AppCompatActivity implements KitchenView, PropertyChangeListener {

    private KitchenPresenter kp;
    private CurrentOrderDishesAdapter adapter;
    private ArrayList<String[]> dishesToDisplay;

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
//        ListView list = findViewById(R.id.dishToCook);
//
//
////        //----------Initialization below, to be deleted when everything works---------------
////        PlaceOrder po = new PlaceOrder();
////        new DishList("menu.ser");
////        new InventoryList("inventory.ser");
////        try {
////            po.placeOrder(OrderType.DINE_IN, new String[]{"Donut sandwich", "Cheetos sandwich"}, "3");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        //----------------------------------------------------------------------------------
//
//        kp = new KitchenPresenter(this);
//        kp.checkOrderAvailable();
//
//        dishesToDisplay = kp.exportDishes();
//        adapter = new CurrentOrderDishesAdapter(this, R.layout.cook_dish_layout, dishesToDisplay, kp);
//        list.setAdapter(adapter);

        Review r1 = new Review("name1", false, 5, "excellent food",  "1");
        Review r2 = new Review("name2", false, 4, "good service",  "2");
        Review r3 = new Review("name3", false, 3, "average, not recommended",  "3");
        Review r4 = new Review("name4", true, 2, "this place is trash",  "4");
        Review r5 = new Review("name5", false, 1, "never come back again", "5");
        Review r6 = new Review("name6", false, 2, "this place is trash", "6");
        Review r7 = new Review("name7", true, 3, "nice", "7");
        Review r8 = new Review("name8", false, 4, "great food", "8");
        Review r9 = new Review("name9", true, 5, "best food I ever had", "9");
        Review r10 = new Review("name10", false, 2, "this place is trash", "10");
        ReviewList reviewList = new ReviewList();
        reviewList.addReview(r1);
        reviewList.addReview(r2);
        reviewList.addReview(r3);
        reviewList.addReview(r4);
        reviewList.addReview(r5);
        reviewList.addReview(r6);
        reviewList.addReview(r7);
        reviewList.addReview(r8);
        reviewList.addReview(r9);
        reviewList.addReview(r10);

        ReviewList.setContext(this);
        ReviewList.setData(FileName.REVIEW_FILE);

        reviewList.saveToFile();

    }

    /**
     * Listen to the change in Order and update the display if needed.
     * @param propertyChangeEvent
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        kp.checkOrderAvailable();
    }

    /**
     * Update the current dishes to display by mutating the arraylist that holds all display info.
     * @param displayDishes the updated array list of dish infos.
     */
    @Override
    public void renewDishes(ArrayList<String[]> displayDishes) {
       this.dishesToDisplay.clear();
       this.dishesToDisplay.addAll(displayDishes);
    }

    /**
     * Update the display by notifying the adapter changes have been made.
     */
    @Override
    public void updateListDisplay() {
        this.adapter.notifyDataSetChanged();
    }
}