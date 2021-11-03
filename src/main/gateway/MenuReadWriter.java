package gateway;

import use_case.DishList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuReadWriter extends SuperReadWriter{

    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     */
    @Override

    public DishList readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map

        DishList dishes = (DishList) input.readObject();
        input.close();
        return dishes;
    }
}

