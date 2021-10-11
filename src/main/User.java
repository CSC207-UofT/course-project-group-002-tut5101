public abstract class User {
    private String id;
    private String name;
    private String password;
    private String address;
    private String gender;
    private String phone;
    private String email;

    public User(){
        this.id = "you";
        this.name = "123";
        this.password = "12345";
        this.gender = "female";
        this.address = "Toronto";
        this.phone = "12306";
        this.email = "good.mail.ca";
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = "female";
        this.address = "Toronto";
        this.phone = "12306";
        this.email = "good.mail.ca";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

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
