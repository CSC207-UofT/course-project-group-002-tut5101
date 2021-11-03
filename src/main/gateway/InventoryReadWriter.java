package gateway;

import entity.Inventory;
import use_case.InventoryFactory;
import use_case.InventoryList;
import use_case.UserList;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class InventoryReadWriter extends SuperReadWriter implements ReadFromCSV{
    @Override
    public HashMap readFromCSV(String filePath){
        HashMap hashMap = new HashMap();
        InventoryFactory factory = new InventoryFactory();
        try{
            Scanner scanner = new Scanner(new FileInputStream(filePath));
            String[] record;
            Inventory inventory;

            while(scanner.hasNextLine()) {
                record = scanner.nextLine().split(",");
                inventory = factory.getInventory(record);
                hashMap.put(inventory.getName(),inventory);
            }
            scanner.close();
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        return hashMap;
    }

    @Override
    public InventoryList readFromFile(String filePath){
        InventoryList inventorys = new InventoryList();
        try{
            File f = new File(filePath);
            f.createNewFile();
            InputStream file = new FileInputStream(f);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            // serialize the Map
            inventorys = (InventoryList) input.readObject();
            input.close();
        }
        catch(IOException|ClassNotFoundException e){e.printStackTrace();}
        return inventorys;
    }
}
