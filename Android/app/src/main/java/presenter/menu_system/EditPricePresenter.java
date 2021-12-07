package presenter.menu_system;

import use_case.dish_list.DishList;

/**
 * Presenter class for editing price.
 */
public class EditPricePresenter {
    private final DishList dishList;

    /**
     * Constructor
     */
    public EditPricePresenter(){
        this.dishList = new DishList();
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void increasePrice(String dishName, double number){
        dishList.editPrice(dishName, 1, number);
    }

    /**
     * Edit the dish by passing in the dish name.
     *
     * @param dishName the name of the dish
     */
    public void decreasePrice(String dishName, double number){
        dishList.editPrice(dishName, 0, number);
    }

}

