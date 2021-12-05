package presenter.review_system;


import android.content.Context;
import constant.file_system.FileLocation;
import entity.review.Review;
import use_case.review.ReviewOutputBoundary;
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
        this.reviewList = new ReviewList(FileLocation.REVIEW_FILE);
        reviewList.setReviewOutputBoundary(this);
        generateReviewList();
    }

    /**
     * Setting context
     * @param c context
     */
    public void setContext(Context c){
        this.reviewList.setContext(c);
    }



    //TODO: Delete later.
    private void generateReviewList() {
        Review r1 = new Review("name1", false, 5, "nice",  "1");
        Review r2 = new Review("name2", false, 4, "nice",  "2");
        Review r3 = new Review("name3", false, 3, "nice",  "3");
        Review r4 = new Review("name4", false, 2, "nice",  "4");
        Review r5 = new Review("name5", false, 1, "nice", "5");
        Review r6 = new Review("name6", false, 2, "nice", "6");
        Review r7 = new Review("name7", false, 3, "nice", "7");
        Review r8 = new Review("name8", false, 4, "nice", "8");
        Review r9 = new Review("name9", false, 5, "nice", "9");
        Review r10 = new Review("name10", false, 2, "nice", "10");
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
