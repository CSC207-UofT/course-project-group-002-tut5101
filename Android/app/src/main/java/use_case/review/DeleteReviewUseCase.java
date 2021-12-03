package use_case.review;

import entity.review.Review;

import java.util.Iterator;

/**
 *
 * Use case class for deleting use_case.review functionality.
 */
@SuppressWarnings("FieldMayBeFinal")
public class DeleteReviewUseCase implements DeleteReviewInputBoundary {
    private final ReviewList reviewList;

    /**
     * Constructor
     * @param reviewList The list of use_case.review
     */
    public DeleteReviewUseCase(ReviewList reviewList) {
        this.reviewList = reviewList;
    }


    /**
     *
     * Delete all reviews with rate below or equal to 3.
     */
    @Override
    public void delete(int i) {
        Iterator<Review> reviewIterator = reviewList.iterator();
        while (reviewIterator.hasNext()){
            Review review = reviewIterator.next();
            if (review != null && review.getRate() < i + 1) {
                reviewIterator.remove();
            }
        }
    }

}
