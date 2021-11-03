package gateway;

import entity.Inventory;

import java.io.Serializable;


public interface ReadandWrite {
    Serializable read(String filepath);
    void addinfo(String filepath, String content);
    void changeinfo(String filepath, String nameoriginal, String modifiedinfo);
}
