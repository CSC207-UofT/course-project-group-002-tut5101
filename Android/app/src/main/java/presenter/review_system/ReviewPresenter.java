package presenter.review_system;


import constant.file_system.FileName;
import use_case.review.ReviewList;
import use_case.review.ReviewOutputBoundary;

/**
 * Presenter class for reviewList.
 */
public class ReviewPresenter implements ReviewOutputBoundary {
    private ReviewList reviewList;
    private DisplayReviewViewInterface displayReviewViewInterface;

    /**
     * Constructor for this class.
     */
    public ReviewPresenter(){
    }

    private void generateReviewList() {
        reviewList = new ReviewList(FileName.REVIEW_FILE);
        reviewList.setReviewOutputBoundary(this);
    }

    /**
     * Setting view interface.
     * @param displayReviewViewInterface view interface for this class.
     */
    public void setDisplayReviewViewInterface(DisplayReviewViewInterface displayReviewViewInterface) {
        this.displayReviewViewInterface = displayReviewViewInterface;
        generateReviewList();
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
