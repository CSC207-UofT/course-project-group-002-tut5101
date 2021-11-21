package use_case.customerSystem;

import entity.customer.Customer;
import entity.orderList.Order;
import entity.delivery.ServingStaff;

public class CustomerUseCase {

    /**
     * Leave review for a meal.
     *
     * @param customer
     * @param serve
     * @param order
     * @return a string containing comments and suggestions.
     */
    public String leaveReview(Customer customer, ServingStaff serve, Order order){
        String good = "good";
        return good;
    }

    /**
     * Complain on serving staff if the customer is annoyed.
     *
     * @param customer
     * @param serve
     * @return true if the customer want to complain about a server. Update the server information.
     */
    public boolean complain(Customer customer, ServingStaff serve){
        String damn = "damn";
        return true;
    }

    /**
     * Ask for assistance from ServingStaff.
     *
     * @param customer
     * @param serve
     * @return true if assistance if provided.
     */
    public boolean assistance(Customer customer, ServingStaff serve){
        String help = "help";
        return true;
    }

    /**
     * Pay the bill.
     *
     * @param customer
     * @return true if the customer pays the bill and the restaurant profit is updated.
     */
    public boolean payBill(Customer customer){
        return true;
    }
}
