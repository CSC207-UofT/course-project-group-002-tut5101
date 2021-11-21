package use_case.reviewList;
import constant.fileSystem.FileLocation;
import entity.review.Review;
import gateway.ReadWriter;
import gateway.SerReadWriter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

public class ReviewList implements Serializable {
    private static HashMap<Integer, ArrayList<Review>> reviews;
    private static ReadWriter rrw;
    private String filepath = FileLocation.REVIEW_LIST_LOCATION;

    public ReviewList() {
        this.reviews = new HashMap<>();
    }

    public ReviewList(String filepath) {
        this.filepath = filepath;
        rrw = new SerReadWriter();
        this.reviews  = rrw.readFromFile(filepath);
    }

    public void addReview(String name, boolean ifAnonymouse, int rate, String comment, boolean ifComplain, String complain){
        addReview(new Review(name, ifAnonymouse, rate, comment, ifComplain, complain));
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

    /**
     * Delete the reviews
     */
    public void deleteReviews(){
        reviews.put(1, new ArrayList<>());
        reviews.put(2, new ArrayList<>());
        reviews.put(3, new ArrayList<>());
        reviews.put(4, new ArrayList<>());
        reviews.put(5, new ArrayList<>());
    }

    public int sizeofList(){
        return reviews.size();
    }

    public void saveToFile() {
        rrw.saveToFile(this.filepath, this.reviews);
    }




}