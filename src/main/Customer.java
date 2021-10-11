public class Customer extends User{

    public Customer() {
    }

    public Customer(String id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id =' " + this.getId() + '\'' + ", username = '" + this.getName() + '\'';
    }
}
