package use_case;

import boundary.DeleteReviewInputBoundary;
import constant.FileLocation;
import gateway.ReadWriter;
import gateway.ReviewReadWriter;


public class DeleteReviewUseCase implements DeleteReviewInputBoundary {

    private ReviewList loadReviewList(){
        ReadWriter readWriter = new ReviewReadWriter();
        return (ReviewList) readWriter.readFromFile(FileLocation.REVIEW_LIST_LOCATION);
    }
    public void deleteReview() {
        ReviewList reviewList = loadReviewList();
        reviewList.deleteReviews();

    }
}
