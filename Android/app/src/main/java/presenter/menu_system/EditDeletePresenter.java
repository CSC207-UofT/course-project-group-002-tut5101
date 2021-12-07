package presenter.menu_system;

import use_case.dish_list.DishList;

/**
 * Presenter class for editing or deleting dish.
 */
public class EditDeletePresenter {
    private final DishList dishList;

    /**
     * Constructor
     */
    public EditDeletePresenter(){
        this.dishList = new DishList();
    }

    /**
     * delete a dish by the dish name
     * @param dishName name of dish
     */
    public void deleteDishByName(String dishName) {
        dishList.deleteDishByName(dishName);
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void increasePrice(String dishName){
        dishList.editPrice(dishName, 1, 1);
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void decreasePrice(String dishName){
        dishList.editPrice(dishName, 0, 1);
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void increaseCalories(String dishName){
        dishList.editCalories(dishName, 1, 100);
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void decreaseCalories(String dishName){
        dishList.editCalories(dishName, 0, 100);
    }
}
