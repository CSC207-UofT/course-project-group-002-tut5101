/**
 * Tests for DishList Class
 *
 * @author Chan Yu & Naihe Xiao
 */

import use_case.DishList;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DishListTest {
    DishList menu = new DishList();

    @Before
    public void setUp() {
        menu.getAllDishes().put("Quarter pound with cheese", new entity.Dish("Quarter pound with cheese", 10.0, new HashMap<String, Double>(), 200));
        menu.getAllDishes().put("Quarter pound with 2 cheese", new entity.Dish("Quarter pound with 2 cheese", 10.0, new HashMap<String, Double>(), 400));
        menu.getAllDishes().put("Quarter pound with 3 cheese", new entity.Dish("Quarter pound with 3 cheese", 10.0, new HashMap<String, Double>(), 500));
        menu.getAllDishes().put("Quarter pound with 4 cheese", new entity.Dish("Quarter pound with 4 cheese", 10.0, new HashMap<String, Double>(), 600));
        menu.getAllDishes().put("Quarter pound with 5 cheese", new entity.Dish("Quarter pound with 5 cheese", 10.0, new HashMap<String, Double>(), 700));
        menu.getAllDishes().put("Small fries", new entity.Dish("Small fries", 10.0, new HashMap<String, Double>(), 200));
        menu.getAllDishes().put("Median fries", new entity.Dish("Median fries", 10.0, new HashMap<String, Double>(), 250));
        menu.getAllDishes().put("Large fries", new entity.Dish("Large fries", 10.0, new HashMap<String, Double>(), 350));
        menu.getAllDishes().put("Coke", new entity.Dish("Coke", 10.0, new HashMap<String, Double>(), 180));
        menu.getAllDishes().put("Coffee", new entity.Dish("Coffee", 10.0, new HashMap<String, Double>(), 0));
        menu.getAllDishes().put("Tea", new entity.Dish("Tea", 10.0, new HashMap<String, Double>(), 0));
        menu.getAllDishes().put("Milk Tea", new entity.Dish("Milk Tea", 10.0, new HashMap<String, Double>(), 300));
        menu.getAllDishes().put("Wine", new entity.Dish("Wine", 10.0, new HashMap<String, Double>(), 100));
    }

    @Test
    public void testDishList() {
        assertEquals(menu.getAllDishes().size(), 13);
        entity.Dish testDish = new entity.Dish("Poutine ", 10.0, new HashMap<String, Double>(), 400);
        menu.getAllDishes().put("Poutine", testDish);
        assertEquals(menu.getAllDishes().get("Poutine"), testDish);
    }

}