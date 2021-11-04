package use_case;
import entity.*;

public class ReviewCreater {
    public Review getReview(String[] paras){
        Review r;
        boolean ifAnonymous;
        boolean ifComplain;
        ifAnonymous = paras[0].equals("Anonymous");
        ifComplain = !paras[3].equals("no complain");
        String userName = paras[0];
        int rate = Integer.parseInt(paras[1]);
        String newComment = paras[2];
        String newComplain = paras[3];
        r = new Review(userName, ifAnonymous, rate, newComment, ifComplain, newComplain);
        return r;
    }
}
