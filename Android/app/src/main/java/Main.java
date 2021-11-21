import android.graphics.RegionIterator;
import controller.inventorySystem.InventoryManager;
import controller.reviewSystem.ReviewController;
import entity.inventory.Inventory;
import entity.orderList.Dish;
import ui.managerSystem.RestaurantSystem;
import use_case.dishList.DishList;
import use_case.reviewList.ReviewList;

import java.util.HashMap;

/**
 * Main class for this project.
 */


public class Main {

    public static void main(String[] args) {

        while (true) {
            RestaurantSystem system = new RestaurantSystem();
            system.run();
        }

    }
}



