package use_case.userList;

import androidx.annotation.NonNull;
import constant.fileSystem.FileLocation;
import constant.mangerSystem.UserType;
import entity.User;
import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import gateway.ReadWriter;
import gateway.SerReadWriter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
    ReadWriter readWriter;
    private String filepath = FileLocation.USER_FILE_LOCATION;

    /**
     * First constructor: directly read from file.
     */
    public UserList() {
        readWriter = new SerReadWriter();
        users = readWriter.readFromFileUser(filepath);
    }

    /**
     *  Second constructor: construct with size of the UserList.
     * @param i: number of users in the list.
     */
    public UserList(int i) {
        users = new HashMap<>();
    }

    /**
     * Third constructor: construct with the path of the userList file.
     * @param filepath: path of the userList file.
     */
    public UserList(String filepath) {
        this.filepath = filepath;
        readWriter = new SerReadWriter();
        users = readWriter.readFromFileUser(filepath);
    }


    /**
     * Add user to this user list.
     *
     * @param user the user to add
     */
    public static void addUser(User user) {
        users.put(user.getId(), user);
    }

    public String addNewUser(String id, String name, String password) {
        User user = new Customer(id, name, password);
        if (users.containsKey(user.getId())) {
            return "Used id, please change";
        } else {
            users.put(user.getId(), user);
            return "Successfully added";
        }

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
    public Map getUsers() {
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

    public void savetoFile() {
        this.readWriter.saveToFile(this.filepath, users);
    }

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
        //Save the updated user list to file
        savetoFile();
    }
}