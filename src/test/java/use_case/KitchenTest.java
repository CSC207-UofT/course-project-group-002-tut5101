package use_case;

import entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class KitchenTest {
    private Dish d1;
    private Dish d2;
    private Dish d3;
    private Dish d4;
    private Order o1;
    private Order o2;
    private HashMap<String, Double> ingredient1;
    private HashMap<String, Double> ingredient2;
    private HashMap<String, Double> ingredient3;
    private HashMap<String, Inventory> inventoryList;
    private PlaceOrder po;

    @Before
    public void setUp() throws Exception {
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
        new InventoryList();

        d1 = new Dish("Yu & Rou", 14.5, ingredient1, 1000);
        d2 = new Dish("Curry", 10.5, ingredient2, 500);
        d3 = new Dish("Whatever", 9.5, ingredient3, 120);

        new DishList(Arrays.asList(d1, d2, d3));

        po = new PlaceOrder();
        po.placeOrder(true, new String[]{"Yu & Rou", "Curry", "Yu & Rou"}, "1");
        po.placeOrder(false, new String[]{"Yu & Rou", "Curry", "Whatever"}, "false");
        po.placeOrder(true, new String[]{"Curry", "Curry", "Curry"}, "4");

    }

    @Test
    public void cookedDish() {
    }

    @Test
    public void showDishesChoice() {
    }
}