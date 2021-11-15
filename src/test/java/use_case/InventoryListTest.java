package use_case;
/**
 * Tests for InventoryList Class
 */

import entity.*;
import org.junit.Before;
import org.junit.Test;
import use_case.kitchen.InventoryList;

import static org.junit.Assert.assertEquals;

public class InventoryListTest {
    InventoryList invList = new InventoryList();

    @Before
    public void setUp() {
        invList.addInventory(new Grain("corn", 0.99, 699, "a",20221122));
        invList.addInventory(new Meat("pork",5.00,100,"b",20211030));
        invList.addInventory(new Seafood("samon fish",10.99,23,"c",20211029));
        invList.addInventory(new Alcohol("wine",69.99,4,20221006));
    }

    @Test
    public void testCheckExist1() {assertEquals(invList.checkExist("corn"), true);}

    @Test
    public void testCheckExist2() {assertEquals(invList.checkExist("wine"), true);}


    @Test
    public void testCheckExist3() {assertEquals(invList.checkExist("a"), false);}


}
