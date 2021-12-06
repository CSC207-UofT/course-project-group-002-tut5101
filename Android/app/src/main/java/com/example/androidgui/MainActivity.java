package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.user_activities.CustomerPickActionActivity;
import com.example.androidgui.user_activities.LoginActivity;
import constant.file_system.FileName;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.HasExpiryDate;
import entity.inventory.HasFreshness;
import entity.inventory.Inventory;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import entity.review.Review;
import presenter.main_information.MainActivityPresenter;
import use_case.dish_list.DishList;
import use_case.kitchen.InventoryList;
import use_case.review.ReviewList;
import use_case.user_list.UserList;

/**
 * Main activity for this project.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Method that runs on creation of class
     * @param savedInstanceState fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
//        setInformation();

//      --------------------REVIEW-----------------------
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
        ReviewList.setContext(this);
        ReviewList.setData(FileName.REVIEW_FILE);
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



//      --------------------USERS-----------------------
        UserList userList = new UserList();
        UserList.setContext(this);
        UserList.setData(FileName.USER_FILE);
        userList.addUser(new Manager());
        userList.addUser(new Customer("1", "James", "12345"));
        userList.addUser(new DeliveryStaff("2", "Amy", "12345"));
        userList.addUser(new ServingStaff("3", "Eve", "12345"));
        userList.addUser(new KitchenStaff("4", "Bob", "12345"));
        userList.addUser(new InventoryStaff("5", "Frank", "12345"));

//      --------------------INVENTORY-----------------------
        InventoryList il = new InventoryList();
        InventoryList.setContext(this);
        InventoryList.setData(FileName.INVENTORY_FILE);
        il.addInventory(new HasFreshness("Bread", 10.0, 400, "a", 20211123));
        il.addInventory(new HasFreshness("Lettuce", 2.0, 1000, "a", 20211123));
        il.addInventory(new HasFreshness("Beef", 10.0, 60, "b", 20211123));
        il.addInventory(new HasFreshness("Cheese", 10.0, 60, "c", 20211123));
        il.addInventory(new HasFreshness("Egg", 14.0, 400, "b", 20211123));
        il.addInventory(new HasFreshness("Carrot", 7.0, 500, "a", 20211123));
        il.addInventory(new HasFreshness("Tomato", 9.0, 400, "a", 20211123));
        il.addInventory(new HasExpiryDate("Ketchup", 12.0, 1000,20211205));
        il.addInventory(new HasExpiryDate("Donut", 7.0, 70,20211205));
        il.addInventory(new HasExpiryDate("Cheetos", 7.5, 400,20211205));
        il.addInventory(new HasExpiryDate("Waffle", 9.0, 500,20211205));
        il.addInventory(new HasExpiryDate("Maple syrup", 4.0, 1000,20211205));
        il.addInventory(new HasExpiryDate("Noodle", 6.0, 300,20211205));
        il.addInventory(new HasExpiryDate("Salt", 20.0, 2000,20231205));
        il.addInventory(new HasExpiryDate("Oatmeal", 5.0, 400,20211205));
        il.addInventory(new HasExpiryDate("Beer", 3.0, 400,20211205));
        il.addInventory(new HasExpiryDate("Milk", 7.0, 450,20211205));
        il.addInventory(new HasExpiryDate("Chilli sauce", 3.0, 600,20231205));
        il.addInventory(new HasExpiryDate("Sugar", 2.0, 700,20231205));
        il.addInventory(new HasExpiryDate("Yogurt", 5.0, 400,20211205));


//      --------------------DISHLIST-----------------------
        DishList dl = new DishList();
        DishList.setContext(this);
        DishList.setData(FileName.MENU_FILE);
        dl.addDishByPara("Donut sandwich", 5.99, new String[][]{
                new String[]{"Bread", "2"},
                new String[]{"Donut", "1"},
                new String[]{"Lettuce", "4"},
                new String[]{"Ketchup", "50"},
        }, 1000.00);

        dl.addDishByPara("Cheetos sandwich", 6.99, new String[][]{
                new String[]{"Bread", "2"},
                new String[]{"Cheetos", "30"},
                new String[]{"Beef", "1"},
                new String[]{"Ketchup", "50"},
        }, 800.00);

        dl.addDishByPara("Maple waffle sandwich", 3.99, new String[][]{
                new String[]{"Waffle", "2"},
                new String[]{"Maple syrup", "10"},
                new String[]{"Bread", "2"},
        }, 500.00);

        dl.addDishByPara("Cheese donut", 6.79, new String[][]{
                new String[]{"Cheese", "25"},
                new String[]{"Donut", "1"},
        }, 700.00);

        dl.addDishByPara("Ramen burger", 10.99, new String[][]{
                new String[]{"Bread", "2"},
                new String[]{"Noodle", "20"},
                new String[]{"Ketchup", "50"},
                new String[]{"Lettuce", "2"},
                new String[]{"Egg", "2"},
                new String[]{"Beef", "1"},
                new String[]{"Salt", "30"},
        }, 1200.00);

        dl.addDishByPara("Meatatarian burger", 12.99, new String[][]{
                new String[]{"Bread", "2"},
                new String[]{"Chicken", "1"},
                new String[]{"Ketchup", "50"},
                new String[]{"Lettuce", "2"},
                new String[]{"Egg", "2"},
                new String[]{"Beef", "1"},
                new String[]{"Salt", "30"},
        }, 1300.00);

        dl.addDishByPara("Bird Nest soup", 7.99, new String[][]{
                new String[]{"Egg", "2"},
                new String[]{"Carrot", "3"},
                new String[]{"Oatmeal", "150"},
                new String[]{"Salt", "30"},
        }, 100.00);

        dl.addDishByPara("Blood soup", 6.99, new String[][]{
                new String[]{"Tomato", "4"},
                new String[]{"Salt", "30"},
        }, 300.00);

        dl.addDishByPara("Beer soup", 6.99, new String[][]{
                new String[]{"Beer", "15"},
                new String[]{"Milk", "11"},
        }, 300.00);

        dl.addDishByPara("Buffalo latte", 7.50, new String[][]{
                new String[]{"Chilli sauce", "10"},
                new String[]{"Milk", "20"},
                new String[]{"Sugar", "5"},
        }, 300.00);

        dl.addDishByPara("Beer milk", 3.50, new String[][]{
                new String[]{"Beer", "10"},
                new String[]{"Milk", "20"},
                new String[]{"Sugar", "5"},
        }, 400.00);

        dl.addDishByPara("Yogurt pepsi", 3.50, new String[][]{
                new String[]{"Yogurt", "12"},
                new String[]{"Milk", "14"},
        }, 300.00);

    }

    /**
     * Selected customer action.
     * @param v view.
     */
    public void selectCustomerPickAction(View v) {
        Intent intent = new Intent(MainActivity.this, CustomerPickActionActivity.class);
        startActivity(intent);
    }

    /**
     * Select staff login.
     * @param v view.
     */
    public void selectLogin(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * generate information.
     */
    private void setInformation(){
        MainActivityPresenter presenter = new MainActivityPresenter();
        presenter.setContext(this);
        presenter.setData();
    }


}