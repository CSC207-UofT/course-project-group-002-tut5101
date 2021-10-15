///**
// * Tests for DishList Class
// *
// * @author Chan Yu & Naihe Xiao
// */
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.HashMap;
//
//import static org.junit.Assert.assertEquals;
//
//public class DishListTest {
//    DishList menu = new DishList();
//
//    @Before
//    public void setUp() {
//        menu.getDishes().put("Quarter pound with cheese", new entities.Dish("Quarter pound with cheese", 10.0, new HashMap<String, Double>(), 200));
//        menu.getDishes().put("Quarter pound with 2 cheese", new entities.Dish("Quarter pound with 2 cheese", 10.0, new HashMap<String, Double>(), 400));
//        menu.getDishes().put("Quarter pound with 3 cheese", new entities.Dish("Quarter pound with 3 cheese", 10.0, new HashMap<String, Double>(), 500));
//        menu.getDishes().put("Quarter pound with 4 cheese", new entities.Dish("Quarter pound with 4 cheese", 10.0, new HashMap<String, Double>(), 600));
//        menu.getDishes().put("Quarter pound with 5 cheese", new entities.Dish("Quarter pound with 5 cheese", 10.0, new HashMap<String, Double>(), 700));
//        menu.getDishes().put("Small fries", new entities.Dish("Small fries", 10.0, new HashMap<String, Double>(), 200));
//        menu.getDishes().put("Median fries", new entities.Dish("Median fries", 10.0, new HashMap<String, Double>(), 250));
//        menu.getDishes().put("Large fries", new entities.Dish("Large fries", 10.0, new HashMap<String, Double>(), 350));
//        menu.getDishes().put("Coke", new entities.Dish("Coke", 10.0, new HashMap<String, Double>(), 180));
//        menu.getDishes().put("Coffee", new entities.Dish("Coffee", 10.0, new HashMap<String, Double>(), 0));
//        menu.getDishes().put("Tea", new entities.Dish("Tea", 10.0, new HashMap<String, Double>(), 0));
//        menu.getDishes().put("Milk Tea", new entities.Dish("Milk Tea", 10.0, new HashMap<String, Double>(), 300));
//        menu.getDishes().put("Wine", new entities.Dish("Wine", 10.0, new HashMap<String, Double>(), 100));
//    }
//
//    @Test
//    public void testDishList() {
//        assertEquals(menu.getDishes().size(), 13);
//        entities.Dish testDish = new entities.Dish("Poutine ", 10.0, new HashMap<String, Double>(), 400);
//        menu.getDishes().put("Poutine", testDish);
//        assertEquals(menu.getDishes().get("Poutine"), testDish);
//    }
//
//}