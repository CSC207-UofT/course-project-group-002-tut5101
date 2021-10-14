import entities.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class MaterialTest {
    Material meat;
    Material seafood;
    Material seasoner;
    Material vegefruit;
    Material grain;
    Material dairysoy;

    @Before
    public void setUp(){
        meat = new Meat("a",6.66,7.0,"A",20211008);
        seafood = new Seafood("b",5.55,6.0,"A",20211008);
        seasoner = new Seasoner("c",4.44,5.0,"A",20211008);
        vegefruit = new VegeFruit("d",3.33,4.0,"A",20211008);
        grain = new Grain("e",2.22,3.0,"A",20211008);
        dairysoy = new DairySoy("f",1.11,2.0,"A",20211008);

    }

    @SuppressWarnings("deprecation")
    @Test(timeout = 50)
    public void testgetQuantity(){
        assertEquals(7.0, meat.getQuantity());
        assertEquals(6.0, seafood.getQuantity());
        assertEquals(5.0, seasoner.getQuantity());
        assertEquals(4.0, vegefruit.getQuantity());
        assertEquals(3.0, grain.getQuantity());
        assertEquals(2.0, dairysoy.getQuantity());

    }

    @Test(timeout = 50)
    public void testgetUsedup(){
        assertFalse(meat.getUsedup());
        assertFalse(seafood.getUsedup());
        assertFalse(seasoner.getUsedup());
        assertFalse(vegefruit.getUsedup());
        assertFalse(grain.getUsedup());
        assertFalse(dairysoy.getUsedup());
    }

    @SuppressWarnings("deprecation")
    @Test(timeout = 50)
    public void testupdateQuantity(){
        assertTrue(meat.updateQuantity(3.0));
        assertFalse(seafood.updateQuantity(9.0));
        assertFalse(seasoner.updateQuantity(9.0));
        assertTrue(vegefruit.updateQuantity(4.0));
        assertTrue(grain.updateQuantity(3.0));
        assertFalse(dairysoy.updateQuantity(3.0));
        assertFalse(meat.getUsedup());
        assertFalse(seafood.getUsedup());
        assertFalse(seasoner.getUsedup());
        assertTrue(vegefruit.getUsedup());
        assertTrue(grain.getUsedup());
        assertFalse(dairysoy.getUsedup());
        assertEquals(4.0, meat.getQuantity());
        assertEquals(6.0, seafood.getQuantity());
        assertEquals(5.0, seasoner.getQuantity());
        assertEquals(0.0, vegefruit.getQuantity());
        assertEquals(0.0, grain.getQuantity());
        assertEquals(1.0, dairysoy.getQuantity());

    }

    @Test(timeout = 50)
    public void testFreshness(){
        assertEquals("A", meat.getFreshness());
        assertEquals("A", seafood.getFreshness());
        assertEquals("A", seasoner.getFreshness());
        assertEquals("A", vegefruit.getFreshness());
        assertEquals("A", grain.getFreshness());
        assertEquals("A", dairysoy.getFreshness());
        meat.setFreshness("B");
        seafood.setFreshness("B");
        seasoner.setFreshness("B");
        vegefruit.setFreshness("B");
        grain.setFreshness("B");
        dairysoy.setFreshness("B");
        assertEquals("B", meat.getFreshness());
        assertEquals("B", seafood.getFreshness());
        assertEquals("B", seasoner.getFreshness());
        assertEquals("B", vegefruit.getFreshness());
        assertEquals("B", grain.getFreshness());
        assertEquals("B", dairysoy.getFreshness());

    }

}
