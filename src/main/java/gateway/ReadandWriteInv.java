package gateway;

import entity.Inventory;
import gateway.ReadandWrite;
import use_case.InventoryFactory;
import use_case.InventoryList;

import java.io.*;

public class ReadandWriteInv implements ReadandWrite {
    @Override
    public InventoryList read(String filepath){
        String line;
        InventoryList l = new InventoryList();
        InventoryFactory factory = new InventoryFactory();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while((line = br.readLine()) != null){
               String[] paras = line.split(",");
                Inventory item = factory.getInventory(paras);
                l.addInventory(item);
            }
            br.close();
        } catch (IOException e){ e.printStackTrace();}
        return l;
    }
    @Override
    public void addinfo(String filepath, String content){
        try {
            FileWriter writer = new FileWriter(filepath, true);
            writer.write(content+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void changeinfo(String filepath, String nameoriginal, String modifiedinfo){
        String line;
        String templine;
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            File temp = File.createTempFile("temp",".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            while((line = br.readLine()) != null){
                if(line.contains(nameoriginal)){
                    bw.write(modifiedinfo+"\n");
                }
                else{bw.write(line);}
            br.close();
            bw.close();
            FileWriter writer = new FileWriter(filepath, false);
            BufferedReader reader = new BufferedReader(new FileReader(temp));
            while((templine = reader.readLine()) != null){
                writer.write(templine);
            }
            temp.deleteOnExit();
            reader.close();
            writer.close();
            }
            } catch(IOException e){e.printStackTrace();}

    }
}
