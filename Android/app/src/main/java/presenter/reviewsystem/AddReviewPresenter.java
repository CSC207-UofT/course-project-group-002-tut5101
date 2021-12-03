package presenter.reviewsystem;

import use_case.review.ReviewList;

/**
 * Controller class for use_case.review.
 */


public class AddReviewPresenter {
    private static ReviewList reviews;

    /**
     * Reading from file constructor.
     */
    public AddReviewPresenter() {
        reviews = new ReviewList();

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
        reviews.addReview(name, ifAnonymous, rate, comment, ID);
    }


    /**
     *
     * @return the length of the use_case.review list.
     */
    public int length() {
        return reviews.sizeofList();
    }

}
