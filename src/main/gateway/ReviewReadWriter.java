package gateway;

import java.io.*;
import java.util.ArrayList;

public class ReviewReadWriter implements ReadWriter{
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param reviews    stores the list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filePath, Object reviews) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        // serialize the Map
        output.writeObject(reviews);
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
    public Serializable readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        Serializable reviews = (Serializable) input.readObject();
        input.close();
        return reviews;
    }
}
