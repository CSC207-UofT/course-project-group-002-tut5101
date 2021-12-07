package presenter.review_system;

import constant.manager_system.ManagerDecision;
import use_case.review.boundaries.DeleteReviewInputBoundary;
import use_case.review.DeleteReviewUseCase;

import java.util.Objects;

/**
 * Presenter class for deleting reviews.
 */
public class DeleteReviewPresenter {
    private final DeleteReviewInputBoundary deleteReviewInputBoundary;

    /**
     * Empty constructor.
     */
    public DeleteReviewPresenter(){
        this.deleteReviewInputBoundary = new DeleteReviewUseCase();
    }

    /**
     * Method for deciding upon manager's decision.
     * @param action decision by manager.
     */
    public void decideReview(String action){
        if (Objects.equals(action, ManagerDecision.ONE.toString())){
            deleteReviewInputBoundary.delete(1);
        }
        else if(Objects.equals(action,ManagerDecision.TWO.toString())) {
            deleteReviewInputBoundary.delete(2);
        }
        else {
            deleteReviewInputBoundary.delete(3);
        }
    }

}
