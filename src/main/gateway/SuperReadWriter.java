package gateway;

import java.io.*;

public abstract class SuperReadWriter implements ReadWriter{
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param objects    stores the list of users to be serialized
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
            output.close();}
        catch(IOException e){e.printStackTrace();}
    }



    public abstract Serializable readFromFile(String filePath);
}
