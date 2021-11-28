package com.example.androidgui;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import use_case.deliverOrder.DeliveryBuffer;
import entity.orderList.Order;
import entity.orderList.Dish;
import use_case.serveDish.ServingBuffer;
import use_case.userList.UserList;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void selectCustomerPickAction(View v) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void selectLogin(View v) {
        UserList userList = new UserList(0);
        User deliveryStaff = new DeliveryStaff("1", "a", "123456", 10);
        userList.addUser(deliveryStaff);
        User servingStaff = new ServingStaff("2", "a", "123456", 10);
        userList.addUser(servingStaff);
        HashMap dishes = new HashMap<String, List<Dish>>();
        List<Dish> dishList = new ArrayList<Dish>();
        Dish dish = new Dish("testDish", 10.0, new HashMap<>(), 20);
        dishList.add(dish);
        dishes.put("a", dishList);
        DeliveryBuffer.addDeliveryOrder(new Order("123 College street", dishes));
        dish.setTableNum(10);
        ServingBuffer.addDish(dish);
        Toast toast;
        toast = Toast.makeText(MainActivity.this, "Set new order to delivery", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(MainActivity.this, ServingStaffPickActionActivity.class);
        Bundle b = new Bundle();
        b.putString("id", "2");
        intent.putExtras(b);
        startActivity(intent);
    }
}