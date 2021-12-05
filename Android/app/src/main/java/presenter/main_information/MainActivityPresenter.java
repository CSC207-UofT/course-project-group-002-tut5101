package presenter.main_information;

import use_case.dish_list.DishList;
import use_case.kitchen.InventoryList;
import use_case.review.ReviewList;
import use_case.user_list.UserList;

/**
 * Presenter for main activity.
 */
public class MainActivityPresenter {
    private final ReviewList reviewList;
    private final DishList dishList;
    private final InventoryList inventoryList;
    private final UserList userList;

    /**
     * Constructor
     */
    public MainActivityPresenter(){
        reviewList = new ReviewList();
        dishList = new DishList();
        inventoryList = new InventoryList();
        userList = new UserList();
    }

    /**
     * Generate data in use cases.
     */
    public void useCaseDataGenerate(){
        reviewList.generateData();
        dishList.generateData();
        inventoryList.generateData();
        userList.generateData();
    }
}
