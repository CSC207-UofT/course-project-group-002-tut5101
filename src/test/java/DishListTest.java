/**
 * Tests for DishList Class
 *
 * @author Chan Yu & Naihe Xiao
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DishListTest {
    DishList menu = new DishList();

    @Before
    public void setUp() {
        menu.getDishes().add(new Dish("Quarter pound with cheese", 10.0, new String[]{""}, 200));
        menu.getDishes().add(new Dish("Quarter pound with 2 cheese", 10.0, new String[]{""}, 400));
        menu.getDishes().add(new Dish("Quarter pound with 3 cheese", 10.0, new String[]{""}, 500));
        menu.getDishes().add(new Dish("Quarter pound with 4 cheese", 10.0, new String[]{""}, 600));
        menu.getDishes().add(new Dish("Quarter pound with 5 cheese", 10.0, new String[]{""}, 700));
        menu.getDishes().add(new Dish("Small fries", 10.0, new String[]{""}, 200));
        menu.getDishes().add(new Dish("Median fries", 10.0, new String[]{""}, 250));
        menu.getDishes().add(new Dish("Large fries", 10.0, new String[]{""}, 350));
        menu.getDishes().add(new Dish("Coke", 10.0, new String[]{""}, 180));
        menu.getDishes().add(new Dish("Coffee", 10.0, new String[]{""}, 0));
        menu.getDishes().add(new Dish("Tea", 10.0, new String[]{""}, 0));
        menu.getDishes().add(new Dish("Milk Tea", 10.0, new String[]{""}, 300));
        menu.getDishes().add(new Dish("Wine", 10.0, new String[]{""}, 100));
    }

    @Test
    public void testDishList() {
        assertEquals(menu.getDishes().size(), 13);
        Dish testDish = new Dish("Small fries", 10.0, new String[]{""}, 200);
        menu.getDishes().add(testDish);
        assertTrue(menu.getDishes().contains(testDish));
    }

}