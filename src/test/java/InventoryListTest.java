import entities.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class InventoryListTest {
    Inventory alcohol;
    Inventory semi;
    Inventory soft;
    Inventory meat;
    Inventory seafood;
    Inventory seasoner;
    Inventory vegefruit;
    Inventory grain;
    Inventory dairysoy;

    @Before
    public void setUp(){
        alcohol = new Alcohol("a",6.66,7.0,20211213);
        semi = new SemiFinished("b",7.77,8.5,20211211);
        soft = new SoftDrink("c",8.88,9.0,20211022);
        meat = new Meat("a",6.66,7.0,"A",20211008);
        seafood = new Seafood("b",5.55,6.0,"A",20211008);
        seasoner = new Seasoner("c",4.44,5.0,"A",20211008);
        vegefruit = new VegeFruit("d",3.33,4.0,"A",20211008);
        grain = new Grain("e",2.22,3.0,"A",20211008);
        dairysoy = new DairySoy("f",1.11,2.0,"A",20211008);
        InventoryList.addInventory(alcohol);
        InventoryList.addInventory(semi);
        InventoryList.addInventory(soft);
        InventoryList.addInventory(meat);
        InventoryList.addInventory(seafood);
        InventoryList.addInventory(seasoner);
        InventoryList.addInventory(vegefruit);
        InventoryList.addInventory(grain);
        InventoryList.addInventory(dairysoy);
    }



    @Test(timeout = 50)
    public void testFreshness(){
        assertNull(InventoryList.getFreshness("g"));
        assertEquals("A", InventoryList.getFreshness("f"));
        assertNull(InventoryList.getFreshness("a"));
        InventoryList.updateFreshness("f","B");
        assertEquals("B", InventoryList.getFreshness("f"));
    }


    @Test(timeout = 50)
    public void testQuantity(){
        assertTrue(0 == InventoryList.getTotalQuantity("g"));
        assertTrue(2.0 == InventoryList.getTotalQuantity("f"));
        assertTrue(7.0 == InventoryList.getTotalQuantity("a"));
        InventoryList.setQuantity("f",2.0);
        assertTrue(0.0 == InventoryList.getTotalQuantity("f"));
        assertTrue(InventoryList.getItem("f").getUsedup());
    }





}
