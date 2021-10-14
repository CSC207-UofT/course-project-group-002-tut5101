package entities;

import java.util.Objects;

public class Review{
    public String review;
    public String user_id;

    public Review(String review, String user_id){
        this.review = review;
        this.user_id = user_id;
    }

    public String showReview(boolean anonymous){
        if (anonymous){
            return "anonymous" + review;
        }else{
            return user_id + review;
        }
    }

}
