import UI.CustomerUI;
import UI.KitchenUI;
import entity.*;
import use_case.DishList;
import use_case.InventoryList;
import use_case.PlaceOrder;

import java.util.Arrays;
import java.util.HashMap;

public class TempKitchenMain {
    private static Dish d1;
    private static Dish d2;
    private static Dish d3;
    private static Dish d4;
    private static Order o1;
    private static Order o2;
    private static HashMap<String, Double> ingredient1;
    private static HashMap<String, Double> ingredient2;
    private static HashMap<String, Double> ingredient3;
    private static HashMap<String, Inventory> inventoryList;

    public static void main(String[] args) {
        setup();
//        CustomerUI cu = new CustomerUI();
//        cu.runCustomerActions();

        PlaceOrder po = new PlaceOrder();
        try {
            po.placeOrder(true, new String[]{"Yu & Rou, Curry, Curry"}, "3");
            po.placeOrder(false, new String[]{"Yu & Rou, Whatever, Curry"}, "Fake street");
        } catch (Exception e) {
            System.out.println("Invalid order, not enough material");
        }

        KitchenUI ku = new KitchenUI();
        ku.loadUi("");
    }


    private static void setup() {
        ingredient1 = new HashMap<>() {{
            put("Meat", 10.0);
            put("Fish", 13.0);
        }};
        ingredient2 = new HashMap<>() {{
            put("Carrot", 4.0);
            put("Potato", 11.0);
        }};
        ingredient3 = new HashMap<>() {{
            put("Kale", 1.0);
            put("Mushroom", 9.0);
        }};

        inventoryList = new HashMap<>() {{
            put("Meat", new Meat("Meat", 10, 490, "Rotten", 100));
            put("Fish", new Seafood("Fish", 10, 30, "Fresh", 100));
            put("Carrot", new VegeFruit("Carrot", 5, 10, "With dirt", 20));
            put("Potato", new VegeFruit("Potato", 3, 40, "Fresh", 11));
            put("Kale", new VegeFruit("Kale", 7, 100, "Fresh", 100));
            put("Mushroom", new VegeFruit("Mushroom", 3, 70, "YIKES", 34));
        }};
        new InventoryList(inventoryList);

        d1 = new Dish("Yu & Rou", 14.5, ingredient1, 1000);
        d2 = new Dish("Curry", 10.5, ingredient2, 500);
        d3 = new Dish("Whatever", 9.5, ingredient3, 120);

        new DishList(Arrays.asList(d1, d2, d3));
    }
}
