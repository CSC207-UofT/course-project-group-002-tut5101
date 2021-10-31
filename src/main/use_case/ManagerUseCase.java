package use_case;

import boundary.ManagerInputBoundary;
import entity.Dish;
import entity.Review;

import java.util.*;

public class ManagerUseCase implements ManagerInputBoundary {

//    /**
//     * Manager issue payment to a specific staff.
//     *
//     * @param manager the current manager in system
//     * @param staff   the staff who are getting payment
//     * @return true iff the payment issue succeed
//     */
//    public boolean payStaffSalary(Manager managerId, Staff staffId) {
//
//        return false;
//    }


//    /**
//     * Manager process enrollment of new staff.
//     *
//     * @param manager the current manager in system
//     * @param staff   the new staff who will be enrolled
//     * @return true iff the enrollment process success
//     */
//    public boolean enrollStaff(Manager managerId, Staff staffId) {
//        //TODO
//        return false;
//    }

    /**
     * Manager adjust the menu(dish list).
     *
     * @param menu      the current menu in system
     * @return true     iff the adjustment is made successfully
     */
    public void manageMenu(DishList menu) {
        HashMap<String, Dish> dishMap = menu.getDishes();
        Set keySet = dishMap.keySet();
        List<String> list = new ArrayList<String>(keySet);
        for (int i = 0; i < menu.size(); i++){
            Dish dish = dishMap.get(list.get(i));
            if (dish.getPrice() < 10 && dish.getPrice() > 5){
                manageMenuHelper(dish);
                dishMap.put(dish.getName(), dish);
            } else if (dish.getPrice() <= 5){
                dishMap.remove(dish.getName());
            }
        }
    }

    /**
     * Helper function of manageMenu method.
     *
     * @param dish
     */
    public void manageMenuHelper(Dish dish){
        dish.updatePrice();
    }

    /**
     * Manager request out of stock status.
     *
     * @param inventoryList the current inventory status in system
     * @return true iff the request is made successfully
     */
    public String requestInventory(InventoryList inventoryList) {
       return inventoryList.toString();
    }

    /**
     *
     * @return true iff the adjustment is made successfully
     */
    public void deleteReview(ReviewList reviewList) {

        Set keySet = reviewList.getReviews().keySet();
        List<String> list = new ArrayList<String>(keySet);
        for (int i = 0; i < reviewList.size(); i++){
            Review review = reviewList.getReviews().get(list.get(i));
            if (review.getScore() < 10) {
                reviewList.remove();
            }
        }
    }


}
