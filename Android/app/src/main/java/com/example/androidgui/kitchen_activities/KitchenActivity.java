package com.example.androidgui.kitchen_activities;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidgui.R;
import entity.inventory.HasExpiryDate;
import entity.inventory.HasFreshness;
import presenter.kitchen_system.KitchenFacade;
import controller.KitchenController;
import use_case.dish_list.DishList;
import use_case.kitchen.InventoryList;

import java.util.ArrayList;

/**
 * Kitchen activity class.
 */
public class KitchenActivity extends AppCompatActivity{

    // TODO: improve the design here, try to make it not public.
    public static final KitchenFacade kf = new KitchenFacade();
    public static final KitchenController kc = kf.createKitchen();

    /**
     * Activity basic function.
     *
     * @param savedInstanceState onCreate fixed parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
//
//        ListView list = findViewById(R.id.dishToCook);
//
//        ArrayList<String[]> displayDishes = kc.exportDishes();
//
//        KitchenAdapter adapter = new KitchenAdapter(this, R.layout.cook_dish_layout,
//                displayDishes);
//        list.setAdapter(adapter);
//
////        Button button = (Button) findViewById(R.id.button);
////
////        button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                // kc.add("Pressed button");
////                adapter.notifyDataSetChanged();
////            }
////        });
//
//
//        }
//    public String getMessage(String message){
//        return message;
//    }
//    public KitchenController getKitchen() {return kc;}


        // *******Initialization code below, to be deleted later********
        InventoryList il = new InventoryList("inventory.ser", this);
        il.addInventory(new HasFreshness("Bread", 10.0, 40, "a", 20211123));
        il.addInventory(new HasFreshness("Lettuce", 2.0, 100, "a", 20211123));
        il.addInventory(new HasFreshness("Beef", 10.0, 20, "b", 20211123));
        il.addInventory(new HasFreshness("Cheese", 10.0, 16, "c", 20211123));
        il.addInventory(new HasFreshness("Egg", 14.0, 120, "b", 20211123));
        il.addInventory(new HasFreshness("Carrot", 7.0, 12, "a", 20211123));
        il.addInventory(new HasFreshness("Tomato", 9.0, 18, "a", 20211123));
        il.addInventory(new HasExpiryDate("Ketchup", 12.0, 1000, 20211205));
        il.addInventory(new HasExpiryDate("Donut", 7.0, 40, 20211205));
        il.addInventory(new HasExpiryDate("Cheetos", 7.5, 13, 20211205));
        il.addInventory(new HasExpiryDate("Waffle", 9.0, 30, 20211205));
        il.addInventory(new HasExpiryDate("Maple syrup", 4.0, 1000, 20211205));
        il.addInventory(new HasExpiryDate("Noodle", 6.0, 100, 20211205));
        il.addInventory(new HasExpiryDate("Salt", 20.0, 2000, 20231205));
        il.addInventory(new HasExpiryDate("Oatmeal", 5.0, 400, 20211205));
        il.addInventory(new HasExpiryDate("Beer", 3.0, 400, 20211205));
        il.addInventory(new HasExpiryDate("Milk", 7.0, 450, 20211205));
        il.addInventory(new HasExpiryDate("Chilli sauce", 3.0, 600, 20231205));
        il.addInventory(new HasExpiryDate("Sugar", 2.0, 700, 20231205));
        il.addInventory(new HasExpiryDate("Yogurt", 5.0, 400, 20211205));
        il.saveToFile();
        System.out.println("Did");


        DishList dl = new DishList("menu.ser", this);
        dl.addDishByPara("Donut sandwich", 5.99, new String[][]{
                new String[]{"Bread", "2.0"},
                new String[]{"Donut", "1.0"},
                new String[]{"Lettuce", "4.0"},
                new String[]{"Ketchup", "50.0"},
        }, 1000.00, "Food");

        dl.addDishByPara("Cheetos sandwich", 6.99, new String[][]{
                new String[]{"Bread", "2.0"},
                new String[]{"Cheetos", "30.0"},
                new String[]{"Beef", "1.0"},
                new String[]{"Ketchup", "50.0"},
        }, 800.00, "Food");

        dl.addDishByPara("Maple waffle sandwich", 3.99, new String[][]{
                new String[]{"Waffle", "2.0"},
                new String[]{"Maple syrup", "10.0"},
                new String[]{"Bread", "2.0"},
        }, 500.00, "Food");

        dl.addDishByPara("Cheese donut", 6.79, new String[][]{
                new String[]{"Cheese", "25.0"},
                new String[]{"Donut", "1.0"},
        }, 700.00, "Food");

        dl.addDishByPara("Ramen burger", 10.99, new String[][]{
                new String[]{"Bread", "2.0"},
                new String[]{"Noodle", "20.0"},
                new String[]{"Ketchup", "50.0"},
                new String[]{"Lettuce", "2.0"},
                new String[]{"Egg", "2.0"},
                new String[]{"Beef", "1.0"},
                new String[]{"Salt", "30.0"},
        }, 1200.00, "Food");

        dl.addDishByPara("Meatatarian burger", 12.99, new String[][]{
                new String[]{"Bread", "2.0"},
                new String[]{"Chicken", "1.0"},
                new String[]{"Ketchup", "50.0"},
                new String[]{"Lettuce", "2.0"},
                new String[]{"Egg", "2.0"},
                new String[]{"Beef", "1.0"},
                new String[]{"Salt", "30.0"},
        }, 1300.00, "Food");

        dl.addDishByPara("Bird Nest soup", 7.99, new String[][]{
                new String[]{"Egg", "2.0"},
                new String[]{"Carrot", "3.0"},
                new String[]{"Oatmeal", "150.0"},
                new String[]{"Salt", "30.0"},
        }, 100.00, "Soup");

        dl.addDishByPara("Blood soup", 6.99, new String[][]{
                new String[]{"Tomato", "4.0"},
                new String[]{"Salt", "30.0"},
        }, 300.00, "Soup");

        dl.addDishByPara("Beer soup", 6.99, new String[][]{
                new String[]{"Beer", "15.0"},
                new String[]{"Milk", "1.5"},
        }, 300.00, "Soup");

        dl.addDishByPara("Buffalo latte", 7.50, new String[][]{
                new String[]{"Chilli sauce", "10.0"},
                new String[]{"Milk", "20.0"},
                new String[]{"Sugar", "5.0"},
        }, 300.00, "Drink");

        dl.addDishByPara("Beer milk", 3.50, new String[][]{
                new String[]{"Beer", "10.0"},
                new String[]{"Milk", "20.0"},
                new String[]{"Sugar", "5.0"},
        }, 400.00, "Drink");

        dl.addDishByPara("Yogurt pepsi", 3.50, new String[][]{
                new String[]{"Yogurt", "12.0"},
                new String[]{"Milk", "14.0"},
        }, 300.00, "Drink");

        dl.saveToFile();
    }
}