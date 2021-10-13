/**
 * Public class storing information for all users using a Hashmap.
 *
 * @author Chan Yu & Naihe Xiao
 */

import java.util.HashMap;


public class UserList {
    private HashMap<String, User> users;

    /**
     * Constructor of UserList without parameter
     */
    public UserList() {
        this.users = new HashMap<>();
    }

    /**
     * Return this UserList
     */
    public HashMap<String, User> getUsers() {
        return users;
    }

    /**
     * Generate the UserList
     *
     * @return a Hashmap mapping user ids to Users
     * //TODO To be moved to System initial
     */
    public HashMap<String, User> generateUserList() {
        HashMap<String, User> userList = new HashMap<String, User>();
        userList.put("1", new Manager("1", "Chan", "12345"));
        userList.put("2", new Customer("2", "Howard", "12345"));
        userList.put("3", new Manager("3", "Nathan", "12345"));
        userList.put("4", new Customer("4", "George", "12345"));
        userList.put("5", new Manager("5", "DeDong", "12345"));
        userList.put("6", new Customer("6", "Eve", "12345"));
        userList.put("7", new Manager("7", "Raymond", "12345"));
        return userList;
    }


}