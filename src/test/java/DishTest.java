import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DishTest {
    Dish dish1;
    Dish dish2;

    @Before
    public void setUp(){
        dish1 = new Dish("MaPoTouFu", 12.5, new String[]{"Tofu", "Spice", "Garlic"}, 200);
        dish2 = new Dish("RoYaleWithCheese", 10, new String[]{"Bread", "Ketchup", "Cheese"}, 500);
    }

    @Test(timeout = 50)
    public void testDishConstructor1(){
        assertEquals(dish1.getName(), "MaPoTouFu");
        assertTrue(dish1.getPrice() == 12.5);
        assertTrue(dish2.getIngredients().length == 3);
    }

    @Test(timeout = 300)
    public void testToString(){
        assertEquals(dish1.toString(), "Dish{name='MaPoTouFu', price=12.5, ingredients=[Tofu, Spice, Garlic], features={}, calories=200.0, allergyInformation='none', status='ordered}");
    }

}
