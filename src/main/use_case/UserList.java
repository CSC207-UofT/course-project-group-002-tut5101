package use_case; /*
  Public class storing information for all users using a Hashmap.

  @author Chan Yu & Naihe Xiao
 */

import entity.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UserList implements Serializable {

    //private HashMap<String, User> users;
    private final Map<String, User> users = new HashMap<>();
//
//    /**
//     * Constructor of UseCase.UserList without parameter
//     */
//    public UserList() {
//        this.users = new HashMap<>();
//    }

    /**
     * Add user to this user list.
     * @param user the user to add
     */
    public void add(User user) {
        users.put(user.getName(), user);
    }

    /**
     * Return users
     *
     * @return a Hashmap with users' id mapping with users
     */
    public User getUsers(String username) {
        return users.get(username);
    }

}