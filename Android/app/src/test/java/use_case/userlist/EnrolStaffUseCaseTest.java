package use_case.userlist;

import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import org.junit.Before;
import use_case.enrollstaff.EnrollStaffUseCase;

public class EnrolStaffUseCaseTest {
    final UserList userList = new UserList(20);
    EnrollStaffUseCase useCase = new EnrollStaffUseCase(userList);

    /**
     * Setting up the test.
     */
    @Before
    public void setUp() {
        userList.addUser(new Customer("2", "James", "12345"));
        userList.addUser(new Customer("3", "Steve", "12345"));
        userList.addUser(new Customer("4", "David", "12345"));
        userList.addUser(new DeliveryStaff("5", "Amy", "12345"));
        userList.addUser(new ServingStaff("6", "Eve", "12345"));
        userList.addUser(new ServingStaff("7", "Alice", "12345"));
        userList.addUser(new KitchenStaff("8", "Bob", "12345"));
        userList.addUser(new InventoryStaff("9", "Frank", "12345"));
    }
}
