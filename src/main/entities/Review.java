package entities;

public class Review{
    /**
     * @param review The the comment that user want to input
     * @param user_id The user id
     */
    public String user_id;
    public String review;
    public boolean YorN;


    public Review(String review, String user_id, boolean YorN){
        this.review = review;
        this.user_id = user_id;
        this.YorN = YorN;
    }

    public String showReview(){
        if (this.YorN){
            return user_id + ":" + review + ".";
        }else{
            return "anonymous" + ":" + review + ".";
        }
    }

}
