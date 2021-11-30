package entity;

/*
The imports here imports the apis of Junit, the first gives the identifiers BeforeEach, Test, Timeout...
The second line is to import assertions to test
 */
import entity.delivery.Staff;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StaffTest {
    Staff staff;

    // BeforeEach means the method will be run everytime you activate each of the test
    @Before
    public void setUp() {
        staff = new Staff();
    }

    /**
     *
     * Testing getName method.
     */
    @Test(timeout = 50)
    public void testGetName() {
        assertEquals("Default entities.User", staff.getName());
        staff = new Staff("1", "a", "1", 0);
        assertEquals("a", staff.getName());
    }

    /**
     *
     * Testing GetStaff method.
     */
    @Test(timeout = 50)
    public void testGetStaffNumber() {
        assertEquals("defaultUserId", staff.getId());
        staff = new Staff("1", "a", "1", 0);
        assertEquals("1", staff.getId());
    }

    /**
     *
     * Testing getStaffSalary method.
     */
    @Test(timeout = 50)
    public void testGetStaffSalary() {
        assertEquals(0, staff.getStaffSalary());
        staff = new Staff("1", "a", "1", 10);
        assertEquals(10, staff.getStaffSalary());
    }

    /**
     *
     * Testing increaseSalary method.
     */
    @Test(timeout = 50)
    public void testIncreaseSalary() {
        assertEquals(0, staff.getStaffSalary());
        staff.increaseSalary(10);
        assertEquals(10, staff.getStaffSalary());
    }

    /**
     *
     * Testing decreaseSalary method.
     */
    @Test(timeout = 50)
    public void testDecreaseSalary() {
        staff = new Staff("1", "a", "1", 20);
        staff.decreaseSalary(10);
        assertEquals(10, staff.getStaffSalary());
    }
}