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


    /**
     * Constructor
     */
    public MainActivityPresenter(){
    }

    /**
     * Setting context
     * @param context context
     */
    public void setContext(Context context){
        ReviewList.setContext(context);
        DishList.setContext(context);
        InventoryList.setContext(context);
        UserList.setContext(context);
    }

}
