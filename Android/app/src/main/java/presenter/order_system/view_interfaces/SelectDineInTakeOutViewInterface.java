package presenter.order_system.view_interfaces;

import constant.order_system.OrderType;
/**
 * ViewInterface of selecting dine in or take out
 */
public interface SelectDineInTakeOutViewInterface {
    /**
     * Presenter passes type of order back to activity, then activity runs next view to be displayed
     * @param orderType type of order
     */
    void updateOrderType(OrderType orderType);

}
