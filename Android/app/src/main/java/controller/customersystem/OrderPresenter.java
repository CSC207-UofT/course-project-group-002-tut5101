package controller.customersystem;

import constant.ordersystem.OrderType;
import controller.viewinterface.SelectDineInTakeOutViewInterface;
import use_case.boundary.input.PlaceOrderInputBoundary;
import use_case.customersystem.PlaceOrder;

import java.util.Objects;

/**
 * This is the Order controller which takes input of list of dish names that is passed from the UI and passes it to the
 * PlaceOrder use case to create a new order.
 * by Evelyn Chou
 * 2021-11-03
 */

public class OrderPresenter {
    //Controller class that interacts with use_case.customerSystem.PlaceOrder to place an order from the customer

    private final SelectDineInTakeOutViewInterface selectDineInTakeOutViewInterface;
    /**
     * The input use_case.boundary for the place order.
     */
    private final PlaceOrderInputBoundary placeOrderInputBoundary;

    /**
     * A new OrderController for the use case defined by the PlaceOrderInputBoundary.
     */
    public OrderPresenter(SelectDineInTakeOutViewInterface selectDineInTakeOutViewInterface) {
        this.selectDineInTakeOutViewInterface = selectDineInTakeOutViewInterface;
        this.placeOrderInputBoundary = new PlaceOrder();
    }

    /**
     * runs the placeOrder method defined in the PlaceOrderInputBoundary
     * @param orderType true if the order is dine in, false otherwise
     * @param dishNames list of dish names ordered
     * @param location the table number if dine in, otherwise the address for the order to be delivered
     * @throws Exception if the place order fails
     */
    public void runPlaceOrder(OrderType orderType, String[] dishNames, String location) throws Exception {
        // Note: hands off the work to the use case class.

        placeOrderInputBoundary.placeOrder(orderType, dishNames, location);
    }

    public void retrieveOrderType(String orderTypeName) {
        if (Objects.equals(orderTypeName, OrderType.DINE_IN.toString())) {
            selectDineInTakeOutViewInterface.updateOrderType(OrderType.DINE_IN);
        }
        else {
            selectDineInTakeOutViewInterface.updateOrderType(OrderType.DELIVERY);
        }
    }

}