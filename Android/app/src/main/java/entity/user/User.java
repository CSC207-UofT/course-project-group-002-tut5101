package entity.user;


import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Class of entities.User that contains basic properties for a single user
 *
 * @author Chan Yu & Naihe Xiao
 */
public class User implements Serializable {
    private UserAttributes attributes;

    /**
     * Constructor of entities.User without parameter
     */
    public User() {
        attributes = new UserAttributes("defaultUserId", "Default entities.User", "12345");
    }

    /**
     * Constructor of entities.User with id, name, and password provided.
     *
     * @param id       id of entities.User, should be unique
     * @param name     name of entities.User
     * @param password password of entities.User
     */
    public User(String id, String name, String password) {
        attributes = new UserAttributes(id, name, password);
    }

    /**
     * Return entities.User's basic info
     *
     * @return entities.User's basic info
     */
    @NonNull
    @Override
    public String toString() {
        return attributes.getName() + ": {" +
                "id='" + attributes.getId() + '\'' +
                '}';
    }

    /**
     * Return id of entities.User
     *
     * @return the id of entities.User
     */
    public String getId() {
        return attributes.getId();
    }

    /**
     * Set id for entities.User
     *
     * @param id id of entities.User
     */
    public void setId(String id) {
        attributes = new UserAttributes(id, attributes.getName(), attributes.getPassword());
    }

    /**
     * Get name of entities.User
     *
     * @return the name of entities.User
     */
    public String getName() {
        return attributes.getName();
    }

    /**
     * Set name of entities.User
     *
     * @param name name of entities.User
     */
    public void setName(String name) {
        attributes = new UserAttributes(attributes.getId(), name, attributes.getPassword());
    }


    /**
     * Return whether the password parameter matches this user's password.
     *
     * @param password the password guess
     * @return whether the guess matches the real password.
     */
    public boolean passwordMatches(String password) {
        return attributes.getPassword().equals(password);
    }


    /**
     * Set password of entities.User
     *
     * @param password password of entities.User
     */
    public void setPassword(String password) {
        attributes = new UserAttributes(attributes.getId(), attributes.getName(), password);
    }

    /**
     * Get password of entities.User
     *
     * @return the name of entities.User
     */
    public String getPassword(){return attributes.getPassword();}
}