import java.util.ArrayList;

public class Customers extends User{

    public Customers() {
    }

    public Customers(String id, String username, int password) {
        super(id, username, password);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id =' " + this.getId() + '\'' + ", username = '" + this.getUsername() + '\'';
    }
}
