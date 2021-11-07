package gateway;

import use_case.InventoryFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Gateway class for inventory reading and writing.
 */


public class InventoryReadWriter implements ReadWriter, ReadFromCSV {
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
    public HashMap readFromCSV(String filePath) {
        HashMap hashMap = new HashMap();
        InventoryFactory factory = new InventoryFactory();
        try {
            Scanner scanner = new Scanner(new FileInputStream(filePath));
            String[] record;


            while (scanner.hasNextLine()) {
                record = scanner.nextLine().split(",");

                hashMap.put(record[1], factory.getInventory(record));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hashMap;
    }


    @Override
    public HashMap readFromFile(String filePath) {
        HashMap il = new HashMap();
        try {
            File f = new File(filePath);
            f.createNewFile();
            InputStream file = new FileInputStream(f);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            il = (HashMap) input.readObject();
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return il;
    }
}
