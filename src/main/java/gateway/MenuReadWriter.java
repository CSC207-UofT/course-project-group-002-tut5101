package gateway;

import use_case.DishList;
import use_case.InventoryList;

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

    public DishList readFromFile(String filePath) {

        DishList dishes = new DishList();
        try{
            File f = new File(filePath);
            f.createNewFile();
            InputStream file = new FileInputStream(f);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            dishes = (DishList) input.readObject();
            input.close();
        }
        catch(IOException|ClassNotFoundException e){e.printStackTrace();}
        return dishes;
    }
}

