package use_case.userlist;

import androidx.annotation.NonNull;
import constant.mangersystem.UserType;
import entity.User;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Public class storing information for all users using a Hashmap.
 *
 */

public class UserList implements Serializable {

    /**
     * Private instances used in the class.
     */
    private static HashMap<String, User> users;
    private static final long serialVersionUID = 1L;

    /**
     *  Second constructor: construct with size of the UserList.
     * @param i: number of users in the list.
     */
    public UserList(int i) {
        users = new HashMap<>(i);
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
     * @param salary salary of the new staff.
     */
    public void addStaff(String id, String name, String password, String userType, int salary) {
        switch (UserType.valueOf(userType)){
            case KITCHEN:
                users.put(id, new KitchenStaff(id, name, password, salary));
                break;
            case SERVING_STAFF:
                users.put(id, new ServingStaff(id, name, password, salary));
                break;
            case DELIVERY_STAFF:
                users.put(id, new DeliveryStaff(id, name, password, salary));
                break;
            case INVENTORY_STAFF:
                users.put(id, new InventoryStaff(id, name, password, salary));
                break;
        }
    }
}