import controller.inventorySystem.InventoryManager;
import entity.orderList.Dish;
import ui.managerSystem.RestaurantSystem;
import use_case.dishList.DishList;

import java.util.HashMap;

/**
 * Main class for this project.
 */


public class Main {

    public static void main(String[] args) {

       // while (true) {
       //     RestaurantSystem system = new RestaurantSystem();
       //     system.run();
       // }
        DishList menu = new DishList("src/main/resources/menu.ser");
        System.out.println(menu.size());

    }
}



