
import constant.FileLocation;
import controller.InventoryManager;
import controller.RestaurantSystem;
import gateway.InventoryReadWriter;

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

    }

}

