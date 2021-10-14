import java.util.UUID;

/**
 * Abstract class of User that contains basic properties for a single user
 *
 * @author Chan Yu & Naihe Xiao
 */
public abstract class User {
    private String id;
    private String name;
    private String password;
    private String address;
    private String gender;
    private String phone;
    private String email;

    /**
     * Constructor of User without parameter
     */
    public User() {
        this.id = "defaultuserid"; //UUID.randomUUID().toString();
        this.name = "Default User";
        this.password = "12345";
        this.gender = "N/A";
        this.address = "Toronto";
        this.phone = "12306";
        this.email = "defaultemail@gmail.com";
    }

    /**
     * Constructor of User with id, name, and password provided.
     *
     * @param id       id of User, should be unique
     * @param name     name of User
     * @param password password of User
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
     * Return User's basic info
     *
     * @return User's basic info
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
     * Return id of User
     *
     * @return the id of User
     */
    public String getId() {
        return id;
    }

    /**
     * Set id for User
     *
     * @param id id of User
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get name of User
     *
     * @return the name of User
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of User
     *
     * @param name name of User
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get password of User
     *
     * @return password of User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password of User
     *
     * @param password password of User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get address of User
     *
     * @return address of User
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address of User
     *
     * @param address of User
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get gender of User
     *
     * @return gender of User
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set gender of User
     *
     * @param gender gender of User
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get PhoneNumber of User
     *
     * @return phone of User
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phoneNumber of User
     *
     * @param phone User's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get emailAddress of User
     *
     * @return email of User
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set emailAddress of User
     *
     * @param email of User
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
