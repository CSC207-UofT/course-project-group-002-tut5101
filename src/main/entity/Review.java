package entity;
import java.time.LocalDateTime;

public class Review implements Comment,ComplainStuff,Rate,DayTime,IsAnonymous{
    public String user_name;

    public Review(String name){
        this.user_name = name;
    }

    @Override
    public String isAnonymouse(boolean ifAnonymous) {
        if(ifAnonymous){
            return "Anonymous";
        } else {
            return this.user_name;
        }
    }

    @Override
    public int addRate(int number) {
        if (number <= 0){
            return 0;
        } else return Math.min(number, 5);
    }

    @Override
    public String addComment(String newComment) {
        return newComment;
    }

    @Override
    public String complainStuff(String newComplain) {
        return newComplain;
    }

    @Override
    public LocalDateTime reviewDate() {
        return LocalDateTime.now();
    }
}
