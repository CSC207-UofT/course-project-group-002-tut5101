package presenter.menu_system;

import use_case.dish_list.DishList;

/**
 * Presenter class for editing calories.
 */
public class EditCaloriesPresenter {
    private final DishList dishList;

    /**
     * Constructor
     */
    public EditCaloriesPresenter(){
        this.dishList = new DishList();
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void increaseCalories(String dishName, double number){
        dishList.editCalories(dishName, 1, number);
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void decreaseCalories(String dishName, double number){
        dishList.editCalories(dishName, 0, number);
    }
}
