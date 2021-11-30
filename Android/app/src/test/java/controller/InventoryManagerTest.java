package controller;

import controller.inventorysystem.InventoryManager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryManagerTest {

    final InventoryManager im = new InventoryManager();

    @Test
    public void testGetinfo(){
        String info = "vegefruit,potato,2.99,34.0,d,20211028";
        assertEquals(info, im.getInfo("potato"));
    }

    @Test
    public void testAdd(){
        String info = "vegefruit,onion,2.99,34.0,d,20211028";
        im.addNewInventory(info.split(","));
//        im.SavetoFile();
        assertEquals(info, im.getInfo("onion"));
    }

    @Test
    public void testSet(){
        im.newFreshness("potato","A");
//        im.newQuantity("potato","3");
//        im.SavetoFile();
        String info = "vegefruit,potato,2.99,31.0,A,20211028";
        assertEquals(info, im.getInfo("potato"));

    }




}
