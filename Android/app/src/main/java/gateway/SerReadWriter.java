package gateway;

import java.io.*;
import java.util.HashMap;

/**
 * Gateway class for user reading and writing.
 */


public class SerReadWriter implements ReadWriter {
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


    @Override
    public HashMap readFromFile(String filePath) {
        HashMap users = new HashMap();
        try {
            File f = new File(filePath);
            f.createNewFile();
            InputStream file = new FileInputStream(f);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            users = (HashMap) input.readObject();
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
