/**
 * Tests for DishList Class
 *
 * @author Chan Yu & Naihe Xiao
 */

import constant.FileLocation;
import gateway.SerReadWriter;
import use_case.DishList;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DishListTest {
    DishList menu = new DishList();

    @Before
    public void setUp() {
        menu.addDish(new entity.Dish("Quarter pound with cheese", 10.0, new HashMap<String, Double>(), 200));
        menu.addDish(new entity.Dish("Quarter pound with 2 cheese", 10.0, new HashMap<String, Double>(), 400));
        menu.addDish(new entity.Dish("Quarter pound with 3 cheese", 10.0, new HashMap<String, Double>(), 500));
        menu.addDish(new entity.Dish("Quarter pound with 4 cheese", 10.0, new HashMap<String, Double>(), 600));
        menu.addDish(new entity.Dish("Quarter pound with 5 cheese", 10.0, new HashMap<String, Double>(), 700));
        menu.addDish(new entity.Dish("Small fries", 10.0, new HashMap<String, Double>(), 200));
        menu.addDish(new entity.Dish("Median fries", 10.0, new HashMap<String, Double>(), 250));
        menu.addDish(new entity.Dish("Large fries", 10.0, new HashMap<String, Double>(), 350));
        menu.addDish(new entity.Dish("Coke", 10.0, new HashMap<String, Double>(), 180));
        menu.addDish(new entity.Dish("Coffee", 10.0, new HashMap<String, Double>(), 0));
        menu.addDish(new entity.Dish("Tea", 10.0, new HashMap<String, Double>(), 0));
        menu.addDish(new entity.Dish("Milk Tea", 10.0, new HashMap<String, Double>(), 300));
        menu.addDish(new entity.Dish("Wine", 10.0, new HashMap<String, Double>(), 100));
    }

    @Test
    public void testDishList() {
        assertEquals(menu.getAllDishes().size(), 13);
        entity.Dish testDish = new entity.Dish("Poutine ", 10.0, new HashMap<String, Double>(), 400);
        menu.getAllDishes().put("Poutine", testDish);
        assertEquals(menu.getAllDishes().get("Poutine"), testDish);
    }

    @Test
    public void testSaveToFile() throws IOException {
        SerReadWriter readWriter = new SerReadWriter();
        readWriter.saveToFile(FileLocation.MENU_FILE_LOCATION, menu);
    }
    @Test
    public void testReadFromFile() throws IOException, ClassNotFoundException {
        SerReadWriter readWriter = new SerReadWriter();
        DishList menu = (DishList) readWriter.readFromFile(FileLocation.MENU_FILE_LOCATION);
        System.out.println(menu);
    }

}