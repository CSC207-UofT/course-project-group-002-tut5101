package use_case;

import boundary.ManageMenuInputBoundary;
import constant.FileLocation;
import entity.Dish;
import gateway.MenuReadWriter;
import gateway.ReadWriter;
import java.util.*;

public class ManageMenuUseCase implements ManageMenuInputBoundary {

    private DishList loadMenu() {
        ReadWriter readWriter = new MenuReadWriter();
        return (DishList) readWriter.readFromFile(FileLocation.DISH_LIST_LOCATION);
    }


    /**
     * Manager adjust the menu(dish list).
     *
     * @return true     iff the adjustment is made successfully
     */
    public void manageMenu() {
        DishList dishList = loadMenu();
//        HashMap<String, Dish> dishMap = DishList.getAllDishes();
//        Set<String> keySet = dishMap.keySet();
//        List<String> list = new ArrayList<String>(keySet);
//        for (int i = 0; i < dishMap.size(); i++) {
//            Dish dish = dishMap.get(list.get(i));
//            if (dish.getPrice() < 10 && dish.getPrice() > 5) {
//                manageMenuHelper(dish);
//                dishMap.put(dish.getName(), dish);
//            } else if (dish.getPrice() <= 5) {
//                dishMap.remove(dish.getName());
//            }
//        }
        Iterator<Dish> dishListIterator1 = dishList.iterator();
        while (dishListIterator1.hasNext()) {

            Dish dish = dishListIterator1.next();
            if (dish.getPrice() < 10 && dish.getCalories() > 100) {
                dishListIterator1.remove();
            }

        }
    }

//    /**
//     * Helper function of manageMenu method.
//     *
//     * @param dish
//     */
//    private Dish manageMenuHelper(Dish dish) {
//        dish.updatePrice();
//        return dish;
//    }

}
