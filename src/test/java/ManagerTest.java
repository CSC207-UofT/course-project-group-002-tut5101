/**
 * Tests for Manager Class
 *
 * @author Chan Yu & Naihe Xiao
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager manager;
    Manager manager2;

    @Before
    public void setUp(){
        manager = new Manager();
        manager2 = new Manager("1", "Chan", "12346");
    }

    @Test(timeout = 50)
    public void testManagerConstructor1(){
        assertEquals(manager.getId(), "you");
        assertEquals(manager.getName(), "123");
        assertEquals(manager.getPassword(), "12345");

    }

    @Test(timeout = 50)
    public void testManagerConstructor2() {
        assertEquals(manager2.getId(), "1");
        assertEquals(manager2.getName(), "Chan");
        assertEquals(manager2.getPassword(), "12346");
    }

}
