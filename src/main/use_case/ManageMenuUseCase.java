package use_case;

import boundary.ManageMenuInputBoundary;
import constant.FileLocation;
import entity.Dish;
import gateway.MenuReadWriter;
import gateway.ReadWriter;

import java.io.IOException;
import java.util.*;

public class ManageMenuUseCase implements ManageMenuInputBoundary {

    public DishList loadMenu() {
        ReadWriter readWriter = new MenuReadWriter();
        try {
            return (DishList) readWriter.readFromFile(FileLocation.MenuLocation);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Manager adjust the menu(dish list).
     *
     * @return true     iff the adjustment is made successfully
     */
    public void manageMenu() {
        DishList menu = loadMenu();
        HashMap<String, Dish> dishMap = menu.getAllDishes();
        Set keySet = dishMap.keySet();
        List<String> list = new ArrayList<String>(keySet);
        for (int i = 0; i < menu.size(); i++) {
            Dish dish = dishMap.get(list.get(i));
            if (dish.getPrice() < 10 && dish.getPrice() > 5) {
                manageMenuHelper(dish);
                dishMap.put(dish.getName(), dish);
            } else if (dish.getPrice() <= 5) {
                dishMap.remove(dish.getName());
            }
        }
    }

    /**
     * Helper function of manageMenu method.
     *
     * @param dish
     */
    public void manageMenuHelper(Dish dish) {
        dish.updatePrice();
    }

}
