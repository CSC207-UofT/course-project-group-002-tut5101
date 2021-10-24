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
    }

    @Test(timeout = 50)
    public void testManagerConstructorWOParam() {
        assertEquals(manager.getId(), "100");
        assertEquals(manager.getName(), "Professor");
        assert(manager.passwordMatches("999"));
    }


}
