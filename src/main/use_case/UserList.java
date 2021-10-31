package use_case; /*
  Public class storing information for all users using a Hashmap.

  @author Chan Yu & Naihe Xiao
 */

import constant.UserType;
import entity.Customer;
import entity.Manager;
import entity.Staff;
import entity.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UserList implements Serializable {


    private final Map<String, User> users;

    public UserList(){this.users = new HashMap<>();}

    public UserList(HashMap users){ this.users = users;}

    /**
     * Add user to this user list.
     *
     * @param user the user to add
     */
    public void add(User user) {
        users.put(user.getId(), user);
    }

    /**
     * Return user by its id
     *
     * @return a Hashmap with users' id mapping with users
     */
    public User getUserByUserId(String id) {
        return users.get(id);
    }

    public UserType getUserTypeById(String id){
        User currentUser = this.getUserByUserId(id);
        if (currentUser instanceof Customer)
            return UserType.CUSTOMER;
        else if (currentUser instanceof Manager)
            return UserType.MANAGER;
        else
            return UserType.STAFF;



    }

//    private HashMap<String, User> users;
//
//    /**
//     * Constructor of UseCase.UserList without parameter
//     */
//    public UserList() {
//        this.users = new HashMap<>();
//    }

}