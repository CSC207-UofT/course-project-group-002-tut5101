package use_case;


import constant.FileLocation;
import entity.Dish;
import gateway.MenuReadWriter;
import org.junit.Before;
import org.junit.Test;

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
        ingredient1 = new HashMap<>() {{
            put("Meat", 10.0);
            put("Cheese", 13.0);
        }};
        ingredient2 = new HashMap<>() {{
            put("Potato", 11.0);
        }};
        ingredient3 = new HashMap<>() {{
            put("Coke", 1.0);
        }};
        ingredient4 = new HashMap<>() {{
            put("Coffee", 1.0);
        }};
        ingredient5 = new HashMap<>() {{
            put("Milk Tea", 1.0);
        }};
        ingredient6 = new HashMap<>() {{
            put("Potato", 1.0);
            put("Cheese", 2.5);
        }};

        menu.addDish(new entity.Dish("Quarter pound with cheese", 10.0, ingredient1, 200));
        menu.addDish(new entity.Dish("Quarter pound with 2 cheese", 10.0, ingredient1, 400));
        menu.addDish(new entity.Dish("Quarter pound with 3 cheese", 10.0, ingredient1, 500));
        menu.addDish(new entity.Dish("Small fries", 10.0, ingredient2, 200));
        menu.addDish(new entity.Dish("Median fries", 10.0, ingredient2, 250));
        menu.addDish(new entity.Dish("Large fries", 10.0, ingredient2, 350));
        menu.addDish(new entity.Dish("Coke", 10.0, ingredient3, 180));
        menu.addDish(new entity.Dish("Coffee", 10.0, ingredient4, 0));
        menu.addDish(new entity.Dish("Milk Tea", 10.0, ingredient5, 300));
    }

    @Test
    public void testDishListSize() {
        assertEquals(menu.size(), 9);
    }

    @Test
    public void testDishListAddDish() {
        Dish testDish = new Dish("Poutine ", 10.0, ingredient6, 400);
        menu.addDish(testDish);
        assertEquals(menu.getDishByDishName("Poutine"), testDish);
    }

    //TODO delete this test case
    @Test
    public void testSaveToFile() {
        MenuReadWriter readWriter = new MenuReadWriter();
        readWriter.saveToFile(FileLocation.MENU_FILE_LOCATION, menu.getAllDishes());
    }

    //TODO delete this test case
    @Test
    public void testReadFromFile() {
        MenuReadWriter readWriter = new MenuReadWriter();
        DishList menu = new DishList(readWriter.readFromFile(FileLocation.MENU_FILE_LOCATION));
        System.out.println(menu);
    }

}