import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DishListTest {
    DishList dishList;

    @Before
    public void setUp(){
        dishList = new DishList();

    }

    @Test
    public void testDishList(){
        assertEquals(dishList.getDishes().size(), 13);
        Dish testDish = new Dish("Small fries", 10.0, new String[]{""}, 200 );
        dishList.getDishes().add(testDish);
        assertTrue(dishList.getDishes().contains(testDish));
    }

}