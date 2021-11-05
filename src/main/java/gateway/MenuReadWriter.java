package gateway;

import java.io.*;
import java.util.HashMap;

public class MenuReadWriter implements ReadWriter {

    @Override
    public void saveToFile(String filePath, Object objects) {

        try {
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
     */
    @Override

    public HashMap readFromFile(String filePath) {

        HashMap dishes = new HashMap();
        try {
            File f = new File(filePath);
            f.createNewFile();
            InputStream file = new FileInputStream(f);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            dishes = (HashMap) input.readObject();
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dishes;
    }
}

