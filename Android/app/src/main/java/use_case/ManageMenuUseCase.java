package use_case;

import use_case.boundary.ManageMenuInputBoundary;
import entity.Dish;

import java.util.*;

public class ManageMenuUseCase implements ManageMenuInputBoundary {

    private DishList dishList;
    public ManageMenuUseCase(DishList dishList) {
        this.dishList = dishList;
    }

    /**
     * Manager adjust the menu(dish list).
     *
     * @return true     iff the adjustment is made successfully
     */
    public void manageMenu() {
        Iterator<Dish> dishListIterator1 = dishList.iterator();
        while (dishListIterator1.hasNext()) {
            Dish dish = dishListIterator1.next();
            if (dish.getPrice() < 10 && dish.getCalories() > 100) {
                ((DishList.DishListIterator) dishListIterator1).replace(dish);
            }

        }
    }


}
