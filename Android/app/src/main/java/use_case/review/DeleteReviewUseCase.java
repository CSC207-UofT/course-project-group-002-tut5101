package use_case.review;

import entity.review.Review;
import gateway.ReadWriter;
import gateway.SerReadWriter;

import java.util.Iterator;

/**
 *
 * Use case class for deleting use_case.review functionality.
 */
@SuppressWarnings("FieldMayBeFinal")
public class DeleteReviewUseCase implements DeleteReviewInputBoundary {
    private final ReviewList reviewList;
    private ReadWriter readWriter = new SerReadWriter();

    /**
     * Constructor
     */
    public DeleteReviewUseCase() {
        this.reviewList = new ReviewList();
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
                readWriter.saveToFile(reviewList);
            }
        }
    }

}
