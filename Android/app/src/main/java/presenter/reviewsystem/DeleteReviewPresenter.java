package presenter.reviewsystem;

import constant.mangersystem.ManagerDecision;
import java.util.Objects;

/**
 * Presenter class for deleting reviews.
 */
public class DeleteReviewPresenter {
    private final ReviewController reviewController;

    /**
     * Empty constructor.
     */
    public DeleteReviewPresenter(){
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
