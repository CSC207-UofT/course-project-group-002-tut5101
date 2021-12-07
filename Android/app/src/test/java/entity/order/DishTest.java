package entity.order;

import constant.order_system.ItemStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Test the Dish class
 */
public class DishTest {
    private Dish dish1;
    private Dish dish2;

    /**
     * before running tests
     */
    @Before
    public void setUp() {
        HashMap<String, Integer> ingredient1 = new HashMap<>();
        ingredient1.put("Tofu", 10);
        ingredient1.put("Spice", 1);
        ingredient1.put("Garlic", 15);
        HashMap<String, Integer> ingredient2 = new HashMap<>();
        ingredient2.put("Bread", 30);
        ingredient2.put("Ketchup", 2);
        ingredient2.put("Cheese", 2);

        dish1 = new Dish("MaPoTouFu", 12.5, ingredient1, 200);
        dish2 = new Dish("RoYaleWithCheese", 10, ingredient2, 500);
    }

    /**
     * test the Dish class constructor
     */
    @Test(timeout = 50)
    public void testDishConstructor1() {
        assertEquals(dish1.getName(), "MaPoTouFu");
        assertEquals(12.5, dish1.getPrice(), 0.0);
        assertEquals(3, dish2.getIngredients().size());
    }

    /**
     * test Dish class getter and setter method for table number
     */
    @Test(timeout = 50)
    public void testGetSetTableNum() {
        dish1.setTableNum(4);
        int tableNum = dish1.getTableNum();
        assertEquals(4, tableNum);

    }

    /**
     * test Dish class getter and setter method for dish status
     */
    @Test(timeout = 50)
    public void testGetSetItemStatus() {
        dish1.setStatus(ItemStatus.DISH_COOKED);
        ItemStatus status = dish1.getStatus();
        assertEquals(ItemStatus.DISH_COOKED, status);
    }

    /**
     * test Dish class getter and setter method for dish name
     */
    @Test(timeout = 50)
    public void testGetSetName() {
        dish1.setName("BLAH");
        String name = dish1.getName();
        assertEquals("BLAH", name);
    }

    /**
     * test Dish class getter and setter method for dish price
     */
    @Test(timeout = 50)
    public void testGetSetPrice() {
        dish1.setPrice(2000);
        double price = dish1.getPrice();
        assert(2000 == price);

        dish2.setPrice(5.50);
        double price2 = dish2.getPrice();
        assert(5.50 == price2);
    }

    /**
     * test Dish class getter and setter method for ingredients
     */
    @Test(timeout = 50)
    public void testGetSetIngredients() {
        HashMap<String, Integer> ingredients = new HashMap<>();
        ingredients.put("ingredient1", 10);
        ingredients.put("ingredient2", 20);
        dish1.setIngredients(ingredients);

        HashMap<String, Integer> actual = dish1.getIngredients();
        assertEquals(ingredients, actual);
    }

    /**
     * test Dish class getter and setter method for dish features
     */
    @Test(timeout = 50)
    public void testGetSetFeatures() {
        HashMap<String, Boolean> features = new HashMap<>();
        features.put("Spicy", true);
        features.put("Sweet", false);
        dish1.setFeatures(features);

        HashMap<String, Boolean> actual = dish1.getFeatures();
        assertEquals(features, actual);
    }

    /**
     * test Dish class getter and setter method for dish calories
     */
    @Test(timeout = 50)
    public void testGetSetCalories() {
        dish1.setCalories(20.0);
        double actual = dish1.getCalories();
        assert(20.0 == actual);
    }

    /**
     * test Dish class getter and setter method for dish allergy information
     */
    @Test(timeout = 50)
    public void testGetSetAllergyInformation() {
        dish1.setAllergyInformation("May Contain Peanuts");
        String actual = dish1.getAllergyInformation();
        assertEquals("May Contain Peanuts", actual);
    }

    /**
     * test Dish class toString method
     */
    @Test(timeout = 50)
    public void testToString() {
        setUp();
        HashMap<String, Integer> ingredients = new HashMap<>();
        ingredients.put("ingredient1", 10);
        dish1.setIngredients(ingredients);
        String actual = dish1.toString();
        String expected = "MaPoTouFu" + "\n\t\t$$" + 12.5 + "\n\t\tcalories: " + 200.0 + " cal/100g" +
                "\n\t\tallergyInformation: " + "none" + "\n------------------------------\n";
        assertEquals(expected, actual);
    }

    /**
     * test Dish class increase price method
     */
    @Test(timeout = 50)
    public void testIncreasePrice() {
        setUp();
        double expected = dish1.getPrice() + 1;
        dish1.increasePrice(1);
        double actual = dish1.getPrice();
        assert(expected == actual);
    }

    /**
     * Test Dish class decrease price method
     */
    @Test
    public void testDecreasePrice() {
        setUp();
        double expected = dish1.getPrice() - 1;
        dish1.decreasePrice(1);
        double actual = dish1.getPrice();
        assert(expected == actual);
    }

    /**
     * test Dish class decrease calorie method
     */
    @Test(timeout = 50)
    public void testDecreaseCalories() {
        double expected = dish1.getCalories() - 100;
        dish1.decreaseCalories(100);
        double actual = dish1.getCalories();
        assert(expected == actual);
    }

    /**
     * test Dish class increase calorie method
     */
    @Test
    public void testIncreaseCalories() {
        double expected = dish1.getCalories() + 100;
        dish1.increaseCalories(100);
        double actual = dish1.getCalories();
        assert(expected == actual);
    }

    /**
     * test Dish class equals method
     */
    @Test(timeout = 50)
    public void testEquals() {
        setUp();

        HashMap<String, Integer> ingredient1 = new HashMap<>();
        ingredient1.put("Tofu", 10);
        ingredient1.put("Spice", 1);
        ingredient1.put("Garlic", 15);

        Dish newDish = new Dish("MaPoTouFu", 12.5, ingredient1, 200);
        assert(newDish.equals(dish1));
    }



}
