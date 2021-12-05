package entity.customer;

import androidx.annotation.NonNull;
import entity.user.User;

/**
 * Public class storing information of a customer.
 *
 * @author Chan Yu & Naihe Xiao
 */

public class Customer extends User {

    /**
     * Constructor of UseCase.Customer with default info
     */
    public Customer() {
    }

    /**
     * Constructor of UseCase.Customer with id, name and password provided
     *
     * @param id       id of the UseCase.Customer
     * @param name     name of the UseCase.Customer
     * @param password password fo the UseCase.Customer
     */
    public Customer(String id, String name, String password) {
        super(id, name, password);
    }

    /**
     * Override the toString method of Object and return a fine illustration of a UseCase.Customer information
     *
     * @return a string representation of this customer
     */
    @Override
    @NonNull
    public String toString() {
        return "(UseCase.Customer) " + super.toString();
    }

}
