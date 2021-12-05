package presenter.review_system;


import constant.file_system.FileName;
import entity.review.Review;
import use_case.review.ReviewList;
import use_case.review.ReviewOutputBoundary;

/**
 * Presenter class for reviewList.
 */
public class ReviewPresenter implements ReviewOutputBoundary {
    private final ReviewList reviewList;
    private DisplayReviewViewInterface displayReviewViewInterface;

    /**
     * Constructor for this class.
     */
    public ReviewPresenter(){
        this.reviewList = new ReviewList();
        reviewList.setReviewOutputBoundary(this);
    }


    /**
     * Setting view interface.
     * @param displayReviewViewInterface view interface for this class.
     */
    public void setDisplayReviewViewInterface(DisplayReviewViewInterface displayReviewViewInterface) {
        this.displayReviewViewInterface = displayReviewViewInterface;
    }

    /**
     * Turn reviews as string.
     */
    public void reviewsInListAsString() {
        reviewList.reviewAsString();
    }

    /**
     *
     * @param toString string representation of the reviews.
     */
    @Override
    public void updateReviewDisplay(String toString) {
        displayReviewViewInterface.setReviewsText(toString);
    }
}
