package use_case;


import constant.fileSystem.FileLocation;
import entity.orderList.Dish;
import org.junit.Before;
import org.junit.Test;
import use_case.dishList.DishList;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DishListTest {
    DishList menu = new DishList();
    private static HashMap<String, Double> ingredient1;
    private static HashMap<String, Double> ingredient2;
    private static HashMap<String, Double> ingredient3;
    private static HashMap<String, Double> ingredient4;
    private static HashMap<String, Double> ingredient5;
    private static HashMap<String, Double> ingredient6;

    @Before
    public void setUp() {
        ingredient1 = new HashMap<String, Double>() {{
            put("Meat", 10.0);
            put("Cheese", 13.0);
        }};
        ingredient2 = new HashMap<String, Double>() {{
            put("Potato", 11.0);
        }};
        ingredient3 = new HashMap<String, Double>() {{
            put("Coke", 1.0);
        }};
        ingredient4 = new HashMap<String, Double>() {{
            put("Coffee", 1.0);
        }};
        ingredient5 = new HashMap<String, Double>() {{
            put("Milk Tea", 1.0);
        }};
        ingredient6 = new HashMap<String, Double>() {{
            put("Potato", 1.0);
            put("Cheese", 2.5);
        }};

        menu.addDish(new Dish("Quarter pound with cheese", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Quarter pound with 2 cheese", 10.0, new HashMap<>(), 400));
        menu.addDish(new Dish("Quarter pound with 3 cheese", 10.0, new HashMap<>(), 500));
        menu.addDish(new Dish("Small fries", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Median fries", 10.0, new HashMap<>(), 250));
        menu.addDish(new Dish("Large fries", 10.0, new HashMap<>(), 350));
        menu.addDish(new Dish("Coke", 10.0, new HashMap<>(), 180));
        menu.addDish(new Dish("Coffee", 10.0, new HashMap<>(), 0));
        menu.addDish(new Dish("Milk Tea", 10.0, new HashMap<>(), 300));
    }

    @Test
    public void testDishListSize() {
        assertEquals(menu.size(), 9);
    }

    @Test
    public void testDishListAddDish() {
        Dish testDish = new Dish("Poutine", 10.0, new HashMap<>(), 400);
        menu.addDish(testDish);
        assertEquals(menu.getDishByDishName("Poutine"), testDish);
    }



}