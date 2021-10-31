package use_case;

import entity.Inventory;


public interface ReadandWrite<T> {
    T read(String filepath);
    void addinfo(String filepath, String content);
    void changeinfo(String filepath, String nameoriginal, String modifiedinfo);
}
