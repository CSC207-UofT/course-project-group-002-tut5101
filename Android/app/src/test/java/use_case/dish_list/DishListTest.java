package use_case.dish_list;


import constant.file_system.FileName;
import entity.order_list.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


import static org.junit.Assert.*;

/**
 * Testing DishList.
 */
public class DishListTest {
    private DishList menu = new DishList();

    /**
     *
     * Setting up the test.
     */
    @Before
    public void setUp() {
        menu.addDish(new Dish("Small fries", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Median fries", 10.0, new HashMap<>(), 250));
        menu.addDish(new Dish("Large fries", 10.0, new HashMap<>(), 350));
        menu.addDish(new Dish("Coke", 10.0, new HashMap<>(), 180));
        menu.addDish(new Dish("Coffee", 10.0, new HashMap<>(), 0));
        menu.addDish(new Dish("Milk Tea", 10.0, new HashMap<>(), 300));

        TestClass testPresenter = new TestClass();
        menu.setMenuOutputBoundary(testPresenter);
    }

    /**
     * Test the getAllDishes method
     */
    @Test
    public void testGetAllDishes() {
        menu = new DishList();
        menu.addDish(new Dish("Small fries", 10.0, new HashMap<>(), 200));
        menu.addDish(new Dish("Median fries", 10.0, new HashMap<>(), 250));
        menu.addDish(new Dish("Large fries", 10.0, new HashMap<>(), 350));
        menu.addDish(new Dish("Coke", 10.0, new HashMap<>(), 180));
        menu.addDish(new Dish("Coffee", 10.0, new HashMap<>(), 0));
        menu.addDish(new Dish("Milk Tea", 10.0, new HashMap<>(), 300));

        HashMap<String, Dish> expected = new HashMap<>();
        expected.put("Small fries", new Dish("Small fries", 10.0, new HashMap<>(), 200));
        expected.put("Median fries", new Dish("Median fries", 10.0, new HashMap<>(), 250));
        expected.put("Large fries", new Dish("Large fries", 10.0, new HashMap<>(), 350));
        expected.put("Coke", new Dish("Coke", 10.0, new HashMap<>(), 180));
        expected.put("Coffee", new Dish("Coffee", 10.0, new HashMap<>(), 0));
        expected.put("Milk Tea", new Dish("Milk Tea", 10.0, new HashMap<>(), 300));

        assertEquals(expected, DishList.getAllDishes());
    }

    /**
     * Test the getDishPrice method
     */
    @Test
    public void testDishListGetDishPrice() {
        assertEquals(10.0, DishList.getDishPrice("Small fries"), 0.1);
    }

    /**
     * Test the getDishIngredients method
     */
    @Test
    public void testDishListGetDishIngredients() {
        assertEquals(new HashMap<>(), DishList.getDishIngredients("Coffee"));
    }

    /**
     * Test the getDishCalories method
     */
    @Test
    public void testDishListGetDishCalories() {
        assertEquals(300, DishList.getDishCalories("Milk Tea"), 0.1);
    }

    /**
     * Test the iterator method
     */
    @Test
    public void testIterator() {
        DishListIterator actual = menu.iterator();
        assert(actual.hasNext());
    }

    /**
     * Test the deleteDishByName method
     */
    @Test
    public void testDeleteDish() {
        menu.deleteDishByName("Milk Tea");
        assertFalse(DishList.getAllDishes().containsKey("Milk Tea"));
    }

    /**
     * Test the editDishByName method
     */
    @Test
    public void testEditDish() {
        menu.editDishByName("Coffee");
        assertEquals(11.0, DishList.getDishPrice("Coffee"), 0.1);
        assertEquals(-100, DishList.getDishCalories("Coffee"), 0.1);
    }

    /**
     *
     * Testing DishList addDishes method
     */
    @Test
    public void testDishListAddDish() {
        Dish testDish = new Dish("Pork", 10.0, new HashMap<>(), 400);
        menu.addDish(testDish);
        assertEquals(DishList.getAllDishes().get("Pork"), testDish);
    }

    /**
     * Test the toString method
     */
    @Test
    public void testToString() {
        menu.reset();
        menu.addDish(new Dish("Milk Tea", 10.0, new HashMap<>(), 300));

        String expected = "1. " + "Milk Tea" +
                "\n\t\t$$" + 10.0 +
                "\n\t\tcalories: " + "300.0" + " cal/100g" +
                "\n\t\tallergyInformation: " + "none" +
                "\n------------------------------\n";
        assertEquals(expected, menu.toString());
    }

    /**
     * Test the dishesString method
     */
    @Test
    public void testDishesString() {
        menu.dishesString();
    }

    /**
     * Fake presenter class that implements the output boundary
     */
    private static class TestClass implements MenuOutputBoundary {

        /**
         * Test if this method is called from DishInformation
         * @param menuItems the menu items to be displayed
         */
        @Override
        public void updateMenuItemsDisplay(String menuItems) {
            assertTrue(true);
        }
    }

    // Test the iterator of the dishList

    /**
     * Test the iterator next method
     */
    @Test
    public void testIteratorNext(){
        DishListIterator actual = menu.iterator();
        assert(actual.hasNext());
        try {
            for (int i = 0; i <= 9; i ++) {
                actual.next();
                assert(true);
            }
            actual.next();
            assert(true);
        }
        catch (Exception ignored) {
            assertTrue(true);
        }

    }
    /**
     * Test the iterator replace method
     */
    @Test
    public void testIteratorReplace() {
        DishListIterator actual = menu.iterator();
        Dish dish = new Dish("Tofu", 100.0, new HashMap<>(), 10.0);
        actual.replace(dish);
        assert(DishList.getAllDishes().containsValue(dish));
    }
}