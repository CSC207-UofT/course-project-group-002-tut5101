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
        this.users = generateUserList();
    }

    /**
     * Return users
     *
     * @return a Hashmap with users' id mapping with users
     */
    public HashMap<String, User> getUsers() {
        return users;
    }


}