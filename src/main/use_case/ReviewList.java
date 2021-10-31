package use_case;
import entity.*;

import java.io.PushbackInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

public class ReviewList implements Serializable {
    private static HashMap<Integer, ArrayList<Review>> reviews;

    public ReviewList() {
        this.reviews = new HashMap<>();
    }

    public ReviewList(HashMap reviews) {
        this.reviews = reviews;
    }

    /**
     * Add review to this review list.
     *
     * @param r is the reveiw to add in the list
     */
    public void addReview(Review r) {
        reviews.get(r.addRate()).add(r);
    }


    /**
     * Return reveiws by the rate
     *
     * @return a Hashmap with review's rate mapping with reviews
     */
    public ArrayList<Review> getReviewByRate(int rate) {
        if (rate < 0) {
            return null;
        } else if (rate <= 5) {
            return reviews.get(rate);
        } else {
            return null;
        }
    }
}