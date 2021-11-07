
import constant.FileLocation;
import controller.InventoryManager;
import controller.MenuController;
import controller.RestaurantSystem;
import gateway.InventoryReadWriter;
import gateway.MenuReadWriter;
import use_case.DishList;

import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
    //    InventoryReadWriter irw = new InventoryReadWriter();
    //    HashMap map = irw.readFromCSV("src/main/resources/inventorydata.csv");
    //    InventoryManager im = new InventoryManager(FileLocation.INVENTORY_FILE_LOCATION, map);
    //    im.SavetoFile();

        while (true) {
           RestaurantSystem system = new RestaurantSystem();
            system.run();
        }
     //   MenuReadWriter mrw = new MenuReadWriter();
     //   HashMap map = mrw.readFromFile("src/main/resources/menu.ser");
     //   MenuController mc = new MenuController(map);
    //    mrw.saveToFile("src/main/resources/menu.ser",map);
    //    MenuController mc = new MenuController(map);
     //   System.out.println(mc.dishesInMenuAsString());
     //   mc.SavetoFile();
    }
    }



