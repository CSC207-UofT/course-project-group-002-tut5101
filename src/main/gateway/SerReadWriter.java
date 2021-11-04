package gateway;

import java.io.*;

public class SerReadWriter implements ReadWriter {
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param objects  stores the list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filePath, Object objects) {
        try{
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            // serialize the Map
            output.writeObject(objects);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     * @throws IOException
     */
    @Override
    public Object readFromFile(String filePath) {
        Object users = null;

        try {
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            users = input.readObject();
            input.close();
            return users;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;

    }

}
