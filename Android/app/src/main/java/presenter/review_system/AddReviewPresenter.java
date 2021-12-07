package presenter.review_system;

import use_case.review.boundaries.AddReviewInputBoundary;
import use_case.review.AddReviewUseCase;

/**
 * Controller class for use_case.review.
 */


public class AddReviewPresenter {
    private final AddReviewInputBoundary addReviewInputBoundary;

    /**
     * Reading from file constructor.
     */
    public AddReviewPresenter() {
        this.addReviewInputBoundary = new AddReviewUseCase();
    }


    /**
     *
     * @param name name of the customer.
     * @param ifAnonymous whether the use_case.review is anonymous.
     * @param rate the rate of the use_case.review.
     * @param comment comments left.

     */
    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment) {
        this.addReviewInputBoundary.addToReviewList(name, ifAnonymous, rate, comment);
    }


    /**
     *
     * @return the length of the use_case.review list.
     */
    public int length() {
        return this.addReviewInputBoundary.length();
    }

}
