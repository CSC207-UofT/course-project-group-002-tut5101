package use_case.review;

import androidx.annotation.NonNull;
import constant.filesystem.FileLocation;
import entity.review.Review;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Objects;

public class ReviewList implements Serializable {
    private static HashMap<Integer, ArrayList<Review>> reviews;
    private String filepath = FileLocation.REVIEW_LIST_LOCATION;

    public ReviewList() {
    }

    public ReviewList(String filepath) {
        this.filepath = filepath;
    }

    public void addReview(String name, boolean ifAnonymous, int rate, String comment, boolean ifComplain, String complain){
        addReview(new Review(name, ifAnonymous, rate, comment, ifComplain, complain));
    }
    /**
     * Add review to this review list.
     *
     * @param r is the review to add in the list
     */
    public void addReview(Review r) {
        if(reviews.containsKey(r.addRate())){
            Objects.requireNonNull(reviews.get(r.addRate())).add(r);
        } else {
            ArrayList<Review> review = new ArrayList<>();
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

//    public void saveToFile() {
//        rrw.saveToFile(this.filepath, reviews);
//    }

    /**
     *
     * @return a string representation of this review list.
     */
    @NonNull
    @Override
    public String toString() {
        int reviewNumber = 1;
        StringBuilder menuString = new StringBuilder();
        HashMap<Integer, String> keySet = new HashMap<>();
        for (int review : reviews.keySet()) {
            menuString.append(reviewNumber).append(". ").append(Objects.requireNonNull(reviews.get(review)));
            reviewNumber++;
        }
        return menuString.toString();
    }

    public void deleteBelowThree() {
        reviews.put(3, new ArrayList<>());
    }

    public void deleteBelowTwo() {
        reviews.put(2, new ArrayList<>());
    }

    public void deleteBelowOne() {
        reviews.put(1, new ArrayList<>());
    }
}