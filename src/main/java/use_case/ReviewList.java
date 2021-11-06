package use_case;
import entity.*;
import gateway.ReviewReadWriter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReviewList implements Serializable {
    private static HashMap<Integer, ArrayList<Review>> reviews;


    public ReviewList() {
        this.reviews = new HashMap<>();
    }

    public ReviewList(HashMap reviews) {
        this.reviews  = reviews;
    }




    public static Review creatReview(String name, boolean ifAnonymouse, int rate, String comment, boolean ifComplain, String complain){
        Review r = new Review(name, ifAnonymouse, rate, comment, ifComplain, complain);
        return r;
    }
    /**
     * Add review to this review list.
     *
     * @param r is the review to add in the list
     */
    public void addReview(Review r) {
        if(reviews.containsKey(r.addRate())){
            reviews.get(r.addRate()).add(r);
        } else {
            ArrayList<Review> review = new ArrayList<Review>();
            review.add(r);
            reviews.put(r.addRate(), review);
        }
    }


    /**
     * Return reviews by the rate
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

    public void deleteReviews(){
        reviews.put(1, new ArrayList<>());
        reviews.put(2, new ArrayList<>());
        reviews.put(3, new ArrayList<>());
        reviews.put(4, new ArrayList<>());
        reviews.put(5, new ArrayList<>());
    }





}