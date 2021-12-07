package presenter.user_system;

import entity.order.Dish;
import org.junit.Before;
import org.junit.Test;
import presenter.menu_system.EditPricePresenter;
import use_case.dish_list.DishList;

import java.util.HashMap;

/**
 * Testing edit price presenter.
 */
public class EditPriceTest {
    private EditPricePresenter edit;
    private DishList dishList;

    /**
     * Setup before tests
     */
    @Before
    public void setUp() {
        edit = new EditPricePresenter();
        dishList = new DishList();
        generateDishList();
    }

    /**
     * Test the decreaseCalories
     */
    @Test
    public void decreaseCalories(){
        edit.decreasePrice("dish2", 2);
    }

    /**
     * Test the increaseCalories
     */
    @Test
    public void increaseCalories(){
        edit.increasePrice("dish3", 2);
    }

    /**
     * Generate dishes for the test
     */
    private void generateDishList() {
        Dish d1 = new Dish("dish1", 10, new HashMap<>(), 20);
        Dish d2 = new Dish("dish2", 30, new HashMap<>(), 200);
        Dish d3 = new Dish("dish3", 100, new HashMap<>(), 10);
        Dish d4 = new Dish("dish4", 10, new HashMap<>(), 20);
        Dish d5 = new Dish("dish5", 10, new HashMap<>(), 20);
        Dish d6 = new Dish("dish6", 10, new HashMap<>(), 20);
        Dish d7 = new Dish("dish7", 10, new HashMap<>(), 20);
        dishList.addDish(d1);
        dishList.addDish(d2);
        dishList.addDish(d3);
        dishList.addDish(d4);
        dishList.addDish(d5);
        dishList.addDish(d6);
        dishList.addDish(d7);
    }
}
