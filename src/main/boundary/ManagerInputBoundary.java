package boundary;

import use_case.DishList;
import use_case.InventoryList;
import use_case.ReviewList;

public interface ManagerInputBoundary {
    void manageMenu();
    void deleteReview(ReviewList reviewList);
}
