/**
 * Tests for UseCase.Manager Class
 *
 * @author Chan Yu & Naihe Xiao
 */

import entity.Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager manager;
    Manager manager2;

    @Before
    public void setUp() {
        manager = new Manager();
        manager2 = new Manager("1", "Chan", "12346");
    }

    @Test(timeout = 50)
    public void testManagerConstructorWOParam() {
        assertEquals(manager.getId(), "defaultuserid");
        assertEquals(manager.getName(), "Default entities.User");
        assert(manager.passwordMatches("12345"));
    }

    @Test(timeout = 200)
    public void testManagerConstructorWParam() {
        assertEquals(manager2.getId(), "1");
        assertEquals(manager2.getName(), "Chan");
        assert(manager2.passwordMatches("12346"));
    }

}
