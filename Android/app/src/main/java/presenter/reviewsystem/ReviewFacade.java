package presenter.reviewsystem;

import gateway.SerReadWriter;
import use_case.review.DeleteReviewUseCase;
import use_case.review.ReviewList;

import java.util.HashMap;

public class ReviewFacade {
    private ReviewList rl;
    private HashMap map;
    private SerReadWriter srw = new SerReadWriter();
    public ReviewFacade(){
        map = srw.readFromFile("Android/app/src/main/file/review.ser");
        this.rl = new ReviewList(map);
    }

    public ReviewController createReviewController(){
        return new ReviewController(this.rl);
    }

}
