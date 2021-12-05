package presenter.review_system;

import android.content.Context;
import use_case.review.AddReviewInputBoundary;
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

    public void setContext(Context context){
        this.addReviewInputBoundary.setContext(context);
    }


    /**
     *
     * @param name name of the customer.
     * @param ifAnonymous whether the use_case.review is anonymous.
     * @param rate the rate of the use_case.review.
     * @param comment comments left.

     */
    public void addToReviewList(String name, boolean ifAnonymous, int rate,
                                String comment, String ID) {
        this.addReviewInputBoundary.addToReviewList(name, ifAnonymous, rate, comment, ID);
    }


    /**
     *
     * @return the length of the use_case.review list.
     */
    public int length() {
        return this.addReviewInputBoundary.length();
    }

}
