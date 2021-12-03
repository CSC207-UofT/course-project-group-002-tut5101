package presenter.reviewsystem;

import constant.mangersystem.ManagerDecision;
import controller.ReviewController;
import use_case.dishlist.DishList;

import java.util.Objects;

/**
 * Presenter class for deleting reviews.
 */
public class DeleteReviewPresenter {
    private final ReviewController reviewController;
    private final DishList dishList;

    /**
     * Empty constructor.
     */
    public DeleteReviewPresenter(){
        this.dishList = new DishList();
        this.reviewController = new ReviewController();
    }

    /**
     * Method for deciding upon manager's decision.
     * @param action decision by manager.
     */
    public void decideReview(String action){
        if (Objects.equals(action, ManagerDecision.ONE.toString())){
            reviewController.deleteBelowOne();
        }
        else if(Objects.equals(action,ManagerDecision.TWO.toString())) {
            reviewController.deleteBelowTwo();
        }
        else {
            reviewController.deleteBelowThree();
        }
    }
}
