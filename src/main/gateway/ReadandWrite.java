package gateway;

import entity.Inventory;
import use_case.InventoryList;

import java.io.Serializable;

public interface ReadandWrite {
    InventoryList read(String filepath);
    void addinfo(String filepath, String content);
    void changeinfo(String filepath, String nameoriginal, String modifiedinfo);
}
