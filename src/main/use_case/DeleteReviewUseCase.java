package use_case;

import boundary.DeleteReviewInputBoundary;
import constant.FileLocation;
import gateway.ReadWriter;
import gateway.ReviewReadWriter;

import java.io.IOException;

public class DeleteReviewUseCase implements DeleteReviewInputBoundary {

    public ReviewList loadReviewList(){
        ReadWriter readWriter = new ReviewReadWriter();
        try {
            return (ReviewList) readWriter.readFromFile(FileLocation.ReviewListLocation);
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public void deleteReview() {
        ReviewList reviewList = loadReviewList();
        reviewList.deleteReviews();
    }
}
