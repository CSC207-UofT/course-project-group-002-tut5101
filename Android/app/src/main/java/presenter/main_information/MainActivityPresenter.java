package presenter.main_information;

import android.content.Context;
import constant.file_system.FileName;
import use_case.dish_list.DishList;
import use_case.inventory.InventoryList;
import use_case.review.ReviewList;
import use_case.user_list.UserList;

/**
 * Presenter for main activity.
 */
public class MainActivityPresenter {


    /**
     * Constructor for the presenter
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
    /**
     * Setting Data for data structure
     */
    public void setData() {
        ReviewList.setData(FileName.REVIEW_FILE);
        DishList.setData(FileName.MENU_FILE);
        InventoryList.setData(FileName.INVENTORY_FILE);
        UserList.setData(FileName.USER_FILE);
    }

}
