package use_case;

import org.junit.Before;
import org.junit.Test;
import use_case.kitchen.InventoryList;

import static org.junit.Assert.assertEquals;

/**
 * Tests for InventoryList Class
 */
public class InventoryListTest {
    final InventoryList invList = new InventoryList();

    @Before
    public void setUp() {

    }

    @Test
    public void testCheckExist1() {assertEquals(invList.checkExist("corn"), true);}

    @Test
    public void testCheckExist2() {assertEquals(invList.checkExist("wine"), true);}


    @Test
    public void testCheckExist3() {assertEquals(invList.checkExist("a"), false);}


}
