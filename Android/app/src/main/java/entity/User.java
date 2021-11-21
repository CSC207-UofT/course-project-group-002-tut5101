package entity;

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
    private String address;
    private String gender;
    private String phone;
    private String email;

    /**
     * Constructor of entities.User without parameter
     */
    public User() {
        this.id = "defaultuserid"; //UUID.randomUUID().toString();
        this.name = "Default entities.User";
        this.password = "12345";
        this.gender = "N/A";
        this.address = "Toronto";
        this.phone = "12306";
        this.email = "defaultemail@gmail.com";
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
        this.gender = "N/A";
        this.address = "Toronto";
        this.phone = "12306";
        this.email = "defaultemail@gmail.com";
    }

    /**
     * Return entities.User's basic info
     *
     * @return entities.User's basic info
     */
    @Override
    public String toString() {
        return this.name + ": {" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
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
     * Get address of entities.User
     *
     * @return address of entities.User
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address of entities.User
     *
     * @param address of entities.User
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get gender of entities.User
     *
     * @return gender of entities.User
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set gender of entities.User
     *
     * @param gender gender of entities.User
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get PhoneNumber of entities.User
     *
     * @return phone of entities.User
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phoneNumber of entities.User
     *
     * @param phone entities.User's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get emailAddress of entities.User
     *
     * @return email of entities.User
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set emailAddress of entities.User
     *
     * @param email of entities.User
     */
    public void setEmail(String email) {
        this.email = email;
    }
}