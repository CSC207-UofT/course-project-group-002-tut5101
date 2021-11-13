package controller;

import gateway.InventoryReadWriter;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InventoryManagerTest {
    InventoryReadWriter irw = new InventoryReadWriter();
    HashMap map = irw.readFromFile("src/main/resources/inventory.ser");
    InventoryManager im = new InventoryManager("src/file.ser",map);

    @Test
    public void testGetinfo(){
        String info = "vegefruit,potato,2.99,34.0,d,20211028";
        assertEquals(info, im.getInfo("potato"));
    }

    @Test
    public void testAdd(){
        String info = "vegefruit,onion,2.99,34.0,d,20211028";
        im.addNewInventory(info.split(","));
        im.SavetoFile();
        assertEquals(info, im.getInfo("onion"));
    }

    @Test
    public void testSet(){
        im.newFreshness("potato","A");
        im.newQuantity("potato","3");
        im.SavetoFile();
        String info = "vegefruit,potato,2.99,31.0,A,20211028";
        System.out.println(map.containsKey("potato"));
        assertEquals(info, im.getInfo("potato"));

    }




}
