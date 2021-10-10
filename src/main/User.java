public abstract class User {
    private String id;
    private String username;
    private int password;
    private String address;
    private String gender;
    private String phone;
    private String email;

    public User(){
        this.id = "you";
        this.username = "123";
        this.password = 123;
        this.gender = "female";
        this.address = "Toronto";
        this.phone = "12306";
        this.email = "good.mail.ca";
    }

    public User(String id, String username, int password) {
        this.id = id;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
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
