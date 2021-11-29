package gateway;
/**
 * Gateway interface for reading and writing.
 */


import entity.User;
import entity.review.Review;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReadWriter {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o);


    /**
     * @param filepath location of ser file
     */
    HashMap<String, User> readFromFileUser(String filepath);


    /**
     * @param filepath location of ser file
     */
    HashMap<Integer, ArrayList<Review>> readFromFileReview(String filepath);


    /**
     * @param filepath location of ser file
     */
    HashMap readFromFile(String filepath);
}
