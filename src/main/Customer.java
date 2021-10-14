/**
 * Public class storing information of a customer.
 *
 * @author Chan Yu & Naihe Xiao
 */

public class Customer extends User {

    /**
     * Constructor of Customer with default info
     */
    public Customer() {
    }

    /**
     * Constructor of Customer with id, name and password provided
     *
     * @param id       id of the Customer
     * @param name     name of the Customer
     * @param password password fo the Customer
     */
    public Customer(String id, String name, String password) {
        super(id, name, password);
    }

    /**
     * Override the toString method of Object and return a fine illustration of a Customer information
     *
     * @return a string representation of this customer
     */
    @Override
    public String toString() {
        return "(Customer) " + super.toString();
    }
}
