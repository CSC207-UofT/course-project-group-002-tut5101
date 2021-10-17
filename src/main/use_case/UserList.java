package use_case; /*
  Public class storing information for all users using a Hashmap.

  @author Chan Yu & Naihe Xiao
 */

import entity.User;

import java.util.HashMap;


public class UserList {
    private HashMap<String, User> users;

    /**
     * Constructor of UseCase.UserList without parameter
     */
    public UserList() {
        this.users = new HashMap<>();
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