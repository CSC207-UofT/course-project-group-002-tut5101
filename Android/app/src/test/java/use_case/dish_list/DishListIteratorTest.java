package use_case.dish_list;

import android.app.Activity;
import constant.file_system.FileName;
import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class DishListIteratorTest {
    private DishListIterator dishListIterator;
    private Dish testDish;

    @Before
    public void setUp() {
        DishList dishList = new DishList();
        DishList.setContext(new Activity());
        DishList.setData("TEST"+ FileName.MENU_FILE);
        testDish = new Dish("1", 2.0, new HashMap<>(), 1);
        dishList.addDish(testDish);
        dishListIterator = new DishListIterator();
    }

    @Test
    public void hasNext() {
        assertTrue(dishListIterator.hasNext());
    }

    @Test
    public void next() {
        dishListIterator.next();
    }

    @Test
    public void replace() {
        dishListIterator.replace(testDish);
    }
}