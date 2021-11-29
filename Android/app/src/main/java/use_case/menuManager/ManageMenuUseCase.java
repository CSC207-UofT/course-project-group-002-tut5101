package use_case.menuManager;

import use_case.boundary.input.ManageMenuInputBoundary;
import entity.orderList.Dish;
import use_case.dishList.DishList;
import use_case.dishList.DishListIterator;

public class ManageMenuUseCase implements ManageMenuInputBoundary {

    private final DishList dishList;


    public ManageMenuUseCase(DishList dishList) {
        this.dishList = dishList;
    }


    /**
     * Manager adjust the menu(dish list).
     *
     */
    public void manageMenu() {
        DishListIterator dishListIterator1 = dishList.iterator();
        while (dishListIterator1.hasNext()) {
            Dish dish = dishListIterator1.next();
            if (dish.getPrice() < 10 && dish.getCalories() > 100) {
                dishListIterator1.replace(dish);
            }

        }
    }


}
