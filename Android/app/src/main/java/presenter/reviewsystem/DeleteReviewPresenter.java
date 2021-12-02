package presenter.reviewsystem;

import constant.mangersystem.ManagerDecision;
import presenter.managersystem.DeleteReviewViewInterface;

import java.util.Objects;

/**
 * Presenter class for deleting reviews.
 */
public class DeleteReviewPresenter {
    DeleteReviewViewInterface deleteReviewViewInterface;

    /**
     * Empty constructor.
     */
    public DeleteReviewPresenter(){}

    public void setDeleteReviewViewInterface(DeleteReviewViewInterface deleteReviewViewInterface){
        this.deleteReviewViewInterface = deleteReviewViewInterface;
    }

    /**
     * Method for deciding upon manager's decision.
     * @param action decision by manager.
     */
    public void decideReview(String action){
        if (Objects.equals(action, ManagerDecision.ONE.toString())){
            deleteReviewViewInterface.decideReview(ManagerDecision.ONE.toString());
        }
        else if(Objects.equals(action,ManagerDecision.TWO.toString())) {
            deleteReviewViewInterface.decideReview(ManagerDecision.ONE.toString());
        }
        else {
            deleteReviewViewInterface.decideReview(ManagerDecision.ONE.toString());
        }
    }
}
