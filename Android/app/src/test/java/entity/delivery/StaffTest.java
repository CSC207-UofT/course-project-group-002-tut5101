package entity.delivery;

/*
The imports here imports the apis of Junit, the first gives the identifiers BeforeEach, Test, Timeout...
The second line is to import assertions to test
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class Staff
 */
public class StaffTest {
    private Staff staff;

    /**
     * setup before tests
     */
    @Before
    public void setUp() {
        staff = new Staff();
    }

    /**
     * Testing getName method.
     */
    @Test(timeout = 50)
    public void testGetName() {
        assertEquals("Default entities.User", staff.getName());
        staff = new Staff("1", "a", "1");
        assertEquals("a", staff.getName());
    }

    /**
     * Testing GetStaff method.
     */
    @Test(timeout = 50)
    public void testGetStaffNumber() {
        assertEquals("defaultUserId", staff.getId());
        staff = new Staff("1", "a", "1");
        assertEquals("1", staff.getId());
    }

}