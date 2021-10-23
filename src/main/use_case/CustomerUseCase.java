package use_case;

import entity.Customer;
import entity.Order;

public class CustomerUseCase {

    /**
     * Leave review for a meal.
     *
     * @param customer
     * @param serve
     * @param order
     * @return a string containing comments and suggestions.
     */
    public String LeaveReview(Customer customer, ServingStaff serve, Order order){
        String good = "good";
        return good;
    }
    //TODO: write this method.

    /**
     * Complain on serving staff if the customer is annoyed.
     *
     * @param customer
     * @param serve
     * @return true if the customer want to complain about a server. Update the server information.
     */
    public boolean Complain(Customer customer, ServingStaff serve){
        String damn = "damn";
        return true;
    }
    //TODO: write this method.

    /**
     * Ask for assistance from ServingStaff.
     *
     * @param customer
     * @param serve
     * @return true if assistance if provided.
     */
    public boolean Assistance(Customer customer, ServingStaff serve){
        String help = "help";
        return true;
    }
    //TODO: write this method.

    /**
     * Pay the bill.
     *
     * @param customer
     * @return true if the customer pays the bill and the restaurant profit is updated.
     */
    public boolean PayBill(Customer customer){
        return true;
    }
    //TODO: write this method.
}
