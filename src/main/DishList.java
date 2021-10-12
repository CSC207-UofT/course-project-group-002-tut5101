
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DishList {
    private ArrayList<Dish> menu;
    /* one list may be better? */

    /**
     * This constructor is using the generateDishList method below which hardcoded the dishes in program.
     */
    public DishList() {
        this.menu = this.generateDishList();
    }


    /**
     * This method is used to generate a list of dishes that used to display to customers/managers.
     * //TODO Later, should be removed since the data should come from DB/external source.
     */
    public ArrayList<Dish> generateDishList(){
        ArrayList<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Quarter pound with cheese", 10.0, new String[]{""}, 200 ));
        menu.add(new Dish("Quarter pound with 2 cheese", 10.0, new String[]{""}, 400 ));
        menu.add(new Dish("Quarter pound with 3 cheese", 10.0, new String[]{""}, 500 ));
        menu.add(new Dish("Quarter pound with 4 cheese", 10.0, new String[]{""}, 600 ));
        menu.add(new Dish("Quarter pound with 5 cheese", 10.0, new String[]{""}, 700 ));
        menu.add(new Dish("Small fries", 10.0, new String[]{""}, 200 ));
        menu.add(new Dish("Median fries", 10.0, new String[]{""}, 250 ));
        menu.add(new Dish("Large fries", 10.0, new String[]{""}, 350 ));
        menu.add(new Dish("Coke", 10.0, new String[]{""}, 180 ));
        menu.add(new Dish("Coffee", 10.0, new String[]{""}, 0 ));
        menu.add(new Dish("Tea", 10.0, new String[]{""}, 0 ));
        menu.add(new Dish("Milk Tea", 10.0, new String[]{""}, 300 ));
        menu.add(new Dish("Wine", 10.0, new String[]{""}, 100 ));
        return menu;
    }

    /**
     * Return list of dishes
     *
     * @return
     */
    public List<Dish> getDishes(){
        return this.menu;
    }

}
