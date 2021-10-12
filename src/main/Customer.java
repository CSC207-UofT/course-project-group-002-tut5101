/**
 * Public class storing information of a customer.
 *
 * @author Chan Yu & Naihe Xiao
 */

public class Customer extends User{

    /**
     * Constructor of Customer without parameter
     *
     */
    public Customer() {
    }

    /**
     * Constructor of Customer with id, username and password provided
     *
     * @param id
     * @param username
     * @param password
     */
    public Customer(String id, String username, String password) {
        super(id, username, password);
    }

    /**
     * Override the toString method of Object and return a fine illustration of a Customer information
     *
     * @return a string representation of this customer
     */
    @Override
    public String toString() {
        return "Customers{" +
                "id =' " + this.getId() + '\'' + ", username = '" + this.getName() + '\'';
    }
}
