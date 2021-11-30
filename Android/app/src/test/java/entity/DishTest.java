package entity;

import constant.ordersystem.ItemStatus;
import entity.orderList.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

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

        dish1 = new Dish("MaPoTouFu", 12.5, ingredient1, 200);
        dish2 = new Dish("RoYaleWithCheese", 10, ingredient2, 500);
    }

    @Test(timeout = 50)
    public void testDishConstructor1() {
        assertEquals(dish1.getName(), "MaPoTouFu");
        assertEquals(12.5, dish1.getPrice(), 0.0);
        assertEquals(3, dish2.getIngredients().size());
    }

    @Test(timeout = 50)
    public void testGetSetTableNum() {
        dish1.setTableNum(4);
        int tableNum = dish1.getTableNum();
        assertEquals(4, tableNum);

    }

    @Test(timeout = 50)
    public void testGetSetItemStatus() {
        dish1.setStatus(ItemStatus.DISH_COOKED);
        ItemStatus status = dish1.getStatus();
        assertEquals(ItemStatus.DISH_COOKED, status);
    }

    @Test(timeout = 50)
    public void testGetSetName() {
        dish1.setName("BLAAAAH");
        String name = dish1.getName();
        assertEquals("BLAAAAH", name);
    }

    @Test(timeout = 50)
    public void testGetSetPrice() {
        dish1.setPrice(2000);
        double price = dish1.getPrice();
        assert(2000 == price);

        dish2.setPrice(5.50);
        double price2 = dish2.getPrice();
        assert(5.50 == price2);
    }

    @Test(timeout = 50)
    public void testGetSetIngredients() {
        HashMap<String, Double> ingredients = new HashMap<>();
        ingredients.put("ingredient1", 10.0);
        ingredients.put("ingredien2", 20.0);
        dish1.setIngredients(ingredients);

        HashMap<String, Double> actual = dish1.getIngredients();
        assertEquals(ingredients, actual);
    }

    @Test(timeout = 50)
    public void testGetSetFeatures() {
        HashMap<String, Boolean> features = new HashMap<>();
        features.put("Spicy", true);
        features.put("Sweet", false);
        dish1.setFeatures(features);

        HashMap<String, Boolean> actual = dish1.getFeatures();
        assertEquals(features, actual);
    }

    @Test(timeout = 50)
    public void testGetSetCalories() {
        dish1.setCalories(20.0);
        double actual = dish1.getCalories();
        assert(20.0 == actual);
    }

    @Test(timeout = 50)
    public void testGetSetAllergyInformation() {
        dish1.setAllergyInformation("May Contain Peanuts");
        String actual = dish1.getAllergyInformation();
        assertEquals("May Contain Peanuts", actual);
    }

    @Test(timeout = 50)
    public void testToString() {
        setUp();
        HashMap<String, Double> ingredients = new HashMap<>();
        ingredients.put("ingredient1", 10.0);
        dish1.setIngredients(ingredients);
        String actual = dish1.toString();
        String expected = "MaPoTouFu" + "\n\t\t$$" + 12.5 + "\n\t\tcalories: " + 200.0 + " cal/100g" +
                "\n\t\tallergyInformation: " + "none" + "\n------------------------------\n";
        assertEquals(expected, actual);
    }

    @Test(timeout = 50)
    public void testIncreasePrice() {
        setUp();
        double expected = dish1.getPrice() + 1;
        dish1.increasePrice();
        double actual = dish1.getPrice();
        assert(expected == actual);
    }

    @Test(timeout = 50)
    public void testDecreaseCalories() {
        double expected = dish1.getCalories() - 100;
        dish1.decreaseCalories();
        double actual = dish1.getCalories();
        assert(expected == actual);
    }

    @Test(timeout = 50)
    public void testEquals() {
        setUp();

        HashMap<String, Double> ingredient1 = new HashMap<>();
        ingredient1.put("Tofu", 10.0);
        ingredient1.put("Spice", 1.0);
        ingredient1.put("Garlic", 15.0);

        Dish newDish = new Dish("MaPoTouFu", 12.5, ingredient1, 200);
        assert(newDish.equals(dish1));
    }



}
