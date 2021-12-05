package presenter.main_information;

import android.content.Context;
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
    public MainActivityPresenter(Context context){
        reviewList = new ReviewList();
        dishList = new DishList("dish.ser", context);
        inventoryList = new InventoryList("inventory.ser", context);
        userList = new UserList("user.ser", context);
    }

    public void setContext(Context context){
        reviewList.setContext(context);
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
