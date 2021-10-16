/**
 * Tests for entities.Dish Class
 *
 * @author Chan Yu & Naihe Xiao
 */

import entity.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DishTest {
    Dish dish1;
    Dish dish2;

    @Before
    public void setUp() {
        HashMap<String, Double> ingredient1 = new HashMap<>();
        ingredient1.put("Tofu", 10.0);
        ingredient1.put("Spice", 1.0);
        ingredient1.put("Garlic", 15.0);
        HashMap<String, Double> ingredient2 = new HashMap<>();
        ingredient2.put("Bread", 30.4);
        ingredient2.put("Ketchup", 2.1);
        ingredient2.put("Cheese", 2.4);

        dish1 = new Dish("MaPoTouFu", 12.5, ingredient1, 200,"Food");
        dish2 = new Dish("RoYaleWithCheese", 10, ingredient2, 500,"Food");
    }

    @Test(timeout = 50)
    public void testDishConstructor1() {
        assertEquals(dish1.getName(), "MaPoTouFu");
        assertEquals(12.5, dish1.getPrice(), 0.0);
        assertEquals(3, dish2.getIngredients().size());
    }

    @Test
    public void testToString() {
        assertEquals(dish1.toString(), "MaPoTouFu\n" +
                "\t$$12.5\n" +
                "\tIngredients: {Spice=1.0, Garlic=15.0, Tofu=10.0}\n" +
                "\tfeatures: {}\n" +
                "\tcalories: 200.0 cal/100g\n" +
                "\tallergyInformation: none\n" +
                "------------------------------\n");
    }

}
