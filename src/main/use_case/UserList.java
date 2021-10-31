package use_case; /*
  Public class storing information for all users using a Hashmap.
  @author Chan Yu & Naihe Xiao
 */

import constant.UserType;
import entity.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UserList implements Serializable {


    private static Map<String, User> users = new HashMap<>();

    /**
     * Add user to this user list.
     *
     * @param user the user to add
     */
    public static void add(User user) {
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

    public static UserType getUserTypeById(String id){
        User currentUser = getUserByUserId(id);
        if (currentUser instanceof Customer)
            return UserType.CUSTOMER;
        else if (currentUser instanceof Manager)
            return UserType.MANAGER;
        else if (currentUser instanceof ServingStaff)
            return UserType.SERVING_STAFF;
        else if (currentUser instanceof DeliveryStaff)
            return UserType.DELIVERY_STAFF;
        else
            return UserType.KITCHEN;


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