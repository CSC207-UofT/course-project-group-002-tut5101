package entity;


import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Abstract class of entities.User that contains basic properties for a single user
 *
 * @author Chan Yu & Naihe Xiao
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String password;

    /**
     * Constructor of entities.User without parameter
     */
    public User() {
        this.id = "defaultUserId"; //UUID.randomUUID().toString();
        this.name = "Default entities.User";
        this.password = "12345";
    }

    /**
     * Constructor of entities.User with id, name, and password provided.
     *
     * @param id       id of entities.User, should be unique
     * @param name     name of entities.User
     * @param password password of entities.User
     */
    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * Return entities.User's basic info
     *
     * @return entities.User's basic info
     */
    @NonNull
    @Override
    public String toString() {
        return this.name + ": {" +
                "id='" + id + '\'' +
                '}';
    }

    /**
     * Return id of entities.User
     *
     * @return the id of entities.User
     */
    public String getId() {
        return id;
    }

    /**
     * Set id for entities.User
     *
     * @param id id of entities.User
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get name of entities.User
     *
     * @return the name of entities.User
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of entities.User
     *
     * @param name name of entities.User
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Return whether the password parameter matches this user's password.
     *
     * @param password the password guess
     * @return whether the guess matches the real password.
     */
    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }


    /**
     * Set password of entities.User
     *
     * @param password password of entities.User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get password of entities.User
     *
     * @return the name of entities.User
     */
    public String getPassword(){return this.password;}
}