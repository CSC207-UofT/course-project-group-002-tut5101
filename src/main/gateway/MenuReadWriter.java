package gateway;

import use_case.DishList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuReadWriter implements ReadWriter{
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param dishes    stores the list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filePath, Object dishes) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(dishes);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     * @throws IOException
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

