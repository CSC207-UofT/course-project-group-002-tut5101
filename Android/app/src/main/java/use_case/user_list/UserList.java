package use_case.user_list;

import androidx.annotation.NonNull;
import constant.manger_system.UserType;
import entity.User;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import gateway.ReadWriter;
import gateway.SerReadWriter;
import presenter.main_information.DataGeneratingInterface;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Public class storing information for all users using a Hashmap.
 *
 */

public class UserList implements Serializable, DataGeneratingInterface {

    /**
     * Private instances used in the class.
     */
    private static HashMap<String, User> users;
    private static final long serialVersionUID = 1L;
    private final ReadWriter readWriter = new SerReadWriter();

    /**
     *  Second constructor: construct with size of the UserList.
     */
    public UserList() {
        users = new HashMap<>();
    }

    /**
     *
     * @return the length of the user list.
     */
    public int length(){
        return users.size();
    }


    /**
     * Add user to this user list.
     *
     * @param user the user to add
     */
    public void addUser(User user) {
        users.put(user.getId(), user);
        readWriter.saveToFile(users);
    }


    /**
     * Return user by its id
     *
     * @return a Hashmap with users' id mapping with users
     */
    public static User getUserByUserId(String id) {
        return users.get(id);
    }

    /**
     * Return user type by its id
     *
     * @return a Hashmap with users' id mapping with users
     */
    public static UserType getUserTypeById(String id) {
        User currentUser = getUserByUserId(id);
        if (currentUser instanceof Customer)
            return UserType.CUSTOMER;
        else if (currentUser instanceof Manager)
            return UserType.MANAGER;
        else if (currentUser instanceof ServingStaff)
            return UserType.SERVING_STAFF;
        else if (currentUser instanceof DeliveryStaff)
            return UserType.DELIVERY_STAFF;
        else if (currentUser instanceof InventoryStaff)
            return UserType.INVENTORY_STAFF;
        else if (currentUser instanceof KitchenStaff)
            return UserType.KITCHEN;
        return null;
    }

    /**
     * Return all users as a map.
     *
     * @return a UserList contains
     */
    public HashMap<String, User> getUsers() {
        return users;
    }

    /**
     * String representation for user list.
     *
     * @return a string representation including all users.
     */
    @Override
    @NonNull
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String userId : users.keySet()) {
            builder.append(UserList.getUserByUserId(userId));
        }
        return builder.toString();
    }


    /**
     *  method to add staffs.
     *
     * @param id id of the new staff.
     * @param name name  of the new staff.
     * @param password password of the new staff.
     * @param userType type of the new staff.
     */
    public void addStaff(String id, String name, String password, UserType userType) {
        switch (userType){
            case KITCHEN:
                users.put(id, new KitchenStaff(id, name, password));
                break;
            case SERVING_STAFF:
                users.put(id, new ServingStaff(id, name, password));
                break;
            case DELIVERY_STAFF:
                users.put(id, new DeliveryStaff(id, name, password));
                break;
            case INVENTORY_STAFF:
                users.put(id, new InventoryStaff(id, name, password));
                break;
        }
        readWriter.saveToFile(users);
    }

    /**
     * Generate data for userList.
     */
    @Override
    public void generateData() {
        readWriter.readFromFile();
    }
}