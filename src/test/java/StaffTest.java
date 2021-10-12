/**
 * Test file for Staff class
 * By Dedong Xie
 * 2021-10-11
 */
/*
The imports here imports the apis of Junit, the first gives the identifiers BeforeEach, Test, Timeout...
The second line is to import assertions to test
 */
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

    // Test means that this is a test
    // Timeout is the timeout for the test in seconds
    @Test(timeout = 50)
    public void testGetName() {
        assertEquals("", staff.getName());
        staff = new Staff("a", 1, 0);
        assertEquals("a", staff.getName());
    }

    // Test means that this is a test
    // Timeout is the timeout for the test in seconds
    @Test(timeout = 50)
    public void testGetStaffNumber() {
        assertEquals(0, staff.getStaffNumber());
        staff = new Staff("a", 1, 0);
        assertEquals(1, staff.getStaffNumber());
    }

    // Test means that this is a test
    // Timeout is the timeout for the test in seconds
    @Test(timeout = 50)
    public void testGetStaffSalary() {
        assertEquals(0, staff.getStaffSalary());
        staff = new Staff("a", 1, 10);
        assertEquals(10, staff.getStaffSalary());
    }

    // Test means that this is a test
    // Timeout is the timeout for the test in seconds
    @Test(timeout = 50)
    public void testIncreaseSalary() {
        assertEquals(0, staff.getStaffSalary());
        staff.increaseSalary(10);
        assertEquals(10, staff.getStaffSalary());
    }

    // Test means that this is a test
    // Timeout is the timeout for the test in seconds
    @Test(timeout = 50)
    public void testDecreaseSalary() {
        staff = new Staff("a", 1, 20);
        staff.decreaseSalary(10);
        assertEquals(10, staff.getStaffSalary());
    }
}