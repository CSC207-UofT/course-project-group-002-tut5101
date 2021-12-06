package use_case.review;

import entity.review.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Use case class for deleting use_case.review functionality.
 */
@SuppressWarnings("FieldMayBeFinal")
public class DeleteReviewUseCase implements DeleteReviewInputBoundary {
    private static HashMap<String, Review> reviewList;

    /**
     * Constructor
     */
    public DeleteReviewUseCase() {
        reviewList = ReviewList.getAllReviews();
    }

    /**
     *
     * Delete all reviews with rate below or equal to 3.
     */
    @Override
    public void delete(int standard) {
//        Iterator<Review> reviewIterator = reviewList.iterator();
        int i = 0;
        int length = reviewList.size();
        List<String> lstReviews = new ArrayList<>(ReviewList.getAllReviews().keySet());
        while (i < length){
            String reviewName = lstReviews.get(i);
            Review review = reviewList.get(reviewName);
            if (review != null && review.getRate() <= standard){
                ReviewList.delete(review);
            } else {
                i ++;
            }
        }
//        while (reviewIterator.hasNext()){
//            Review review = reviewIterator.next();
//            if (review != null && review.getRate() <= standard) {
//                reviewList.delete(review);
//            }
//        }
    }

}
