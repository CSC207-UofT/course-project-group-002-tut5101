package use_case.userList;
/*
  Public class storing information for all users using a Hashmap.
  @author Chan Yu & Naihe Xiao
 */

import constant.mangerSystem.UserType;
import entity.*;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.customer.Customer;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UserList implements Serializable {

    private static Map<String, User> users = new HashMap<>();
    private static final long serialVersionUID = 1L;

    public UserList() {
        users = new HashMap<>();
    }

    public UserList(HashMap<String, User> users) {
        UserList.users = users;
    }

    /**
     * Load userList from hashMap
     * @param hashMap the hashMap given by gateway of userList
     */
    public void loadHashMap(HashMap<String, User> hashMap){
        if(users.isEmpty()){
            users.putAll(hashMap);
        }
    }



    /**
     * Add user to this user list.
     *
     * @param user the user to add
     */
    public static void addUser(User user) {
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
     * @return a UserList contains
     */
    public Map getUsers(){
        return users;
    }

    /**
     * String representation for user list.
     *
     * @return a string representation including all users.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String userId : users.keySet()){
            builder.append(UserList.getUserByUserId(userId));
        }
        return builder.toString();
    }
}