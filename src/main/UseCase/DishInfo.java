package UseCase;

import entities.Dish;

/**
 * A "tuple" that contains the information of a dine-in dish.
 * The first element is the table number of this dish, and the second element is the dish itself.
 */
public class DishInfo {
    private int tableNum;
    private Dish dish;

    public DishInfo(int tableNum, Dish dish) {
        this.tableNum = tableNum;
        this.dish = dish;
    }

    public int getTableNum() {
        return this.tableNum;
    }

    public Dish getDish() {
        return this.dish;
    }
}
