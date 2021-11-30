package use_case;


import entity.customer.Customer;
import entity.delivery.ServingStaff;
import entity.orderList.Order;

public class LeaveReviewUseCase {

    /**
     * Leave review for a meal.
     *
     * @param customer: a Customer.
     * @param serve: the com.example.androidgui.ServingStaff.
     * @param order: the order.
     * @return a string containing comments and suggestions.
     */
    public String leaveReview(Customer customer, ServingStaff serve, Order order){
        return "good";
    }
}
