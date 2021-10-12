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
     *
     */
    public User(){
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
     * @param id        id of User, should be unique
     * @param name      name of User
     * @param password  password of User
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
     * Return id of User
     *
     * @return  the id of User
     */
    public String getId() {
        return id;
    }

    /**
     * Set id for User
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get name of User
     *
     * @return  the name of User
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of User
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Get password of User
     *
     * @return password of User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password of User
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
