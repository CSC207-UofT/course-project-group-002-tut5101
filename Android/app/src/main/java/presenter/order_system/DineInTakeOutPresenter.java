package presenter.order_system;

import constant.order_system.OrderType;
import presenter.order_system.view_interfaces.SelectDineInTakeOutViewInterface;

import java.util.Objects;

/**
 * Presenter class corresponding with the SelectDineInTakeOutActivity
 */
public class DineInTakeOutPresenter {
    private SelectDineInTakeOutViewInterface selectDineInTakeOutViewInterface;

    /**
     * Set the dineInTakeOutViewInterface of this class
     * @param selectDineInTakeOutViewInterface the class that implements this interface
     */
    public void setSelectDineInTakeOutViewInterface(SelectDineInTakeOutViewInterface selectDineInTakeOutViewInterface) {
        this.selectDineInTakeOutViewInterface = selectDineInTakeOutViewInterface;
    }

    /**
     * Convert string input to order type and pass this to the view
     * @param orderTypeName the string value of the order type
     */
    public void retrieveOrderType(String orderTypeName) {
        if (Objects.equals(orderTypeName, OrderType.DINE_IN.toString())) {
            selectDineInTakeOutViewInterface.updateOrderType(OrderType.DINE_IN);
        }
        else {
            selectDineInTakeOutViewInterface.updateOrderType(OrderType.DELIVERY);
        }
    }


}
