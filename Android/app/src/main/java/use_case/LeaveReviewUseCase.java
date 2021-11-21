package use_case;

import entity.Customer;
import entity.Order;
import entity.ServingStaff;

public class LeaveReviewUseCase {

    /**
     * Leave review for a meal.
     *
     * @param customer: a Customer.
     * @param serve: the ServingStaff.
     * @param order: the order.
     * @return a string containing comments and suggestions.
     */
    public String leaveReview(Customer customer, ServingStaff serve, Order order){
        return "good";
    }
}
