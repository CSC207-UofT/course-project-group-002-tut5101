import controller.InventoryManager;
import controller.RestaurantSystem;
import entity.*;
import gateway.InventoryReadWriter;
import gateway.MenuReadWriter;
import gateway.UserReadWriter;
import use_case.DishList;
import use_case.InventoryFactory;
import use_case.InventoryList;
import use_case.UserList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        while (true) {
            RestaurantSystem system = new RestaurantSystem();
            system.run();
        }

    }

}

