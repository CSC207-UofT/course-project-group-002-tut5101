package gateway;

import entity.Review;
import use_case.DishList;
import use_case.ReviewList;

import java.io.*;
import java.util.ArrayList;

public class ReviewReadWriter extends SuperReadWriter{



    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     * @throws IOException
     */
    @Override
    public ReviewList readFromFile(String filePath){
        ReviewList reviews = new ReviewList();
        try{
            File f = new File(filePath);
            f.createNewFile();
            InputStream file = new FileInputStream(f);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            reviews = (ReviewList) input.readObject();
            input.close();}
        catch(EOFException e){
            reviews = new ReviewList();
        }
        catch(IOException|ClassNotFoundException e){e.printStackTrace();}
        return reviews;
    }
}
