package presenter.reviewsystem;


import entity.review.Review;
import use_case.boundary.output.ReviewOutputBoundary;
import use_case.review.ReviewList;

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
        generateReviewList();
    }


    //TODO: Delete later.
    private void generateReviewList() {
        Review r1 = new Review("1", false, 5, "nice",  "good");
        Review r2 = new Review("2", false, 4, "nice",  "good");
        Review r3 = new Review("3", false, 3, "nice",  "good");
        Review r4 = new Review("4", false, 2, "nice",  "good");
        Review r5 = new Review("5", false, 1, "nice", "good");
        Review r6 = new Review("6", false, 2, "nice", "good");
        Review r7 = new Review("7", false, 3, "nice", "good");
        Review r8 = new Review("8", false, 4, "nice", "good");
        Review r9 = new Review("9", false, 5, "nice", "good");
        Review r10 = new Review("10", false, 2, "nice", "good");
        reviewList.addReview(r1);
        reviewList.addReview(r2);
        reviewList.addReview(r3);
        reviewList.addReview(r4);
        reviewList.addReview(r5);
        reviewList.addReview(r6);
        reviewList.addReview(r7);
        reviewList.addReview(r8);
        reviewList.addReview(r9);
        reviewList.addReview(r10);

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
