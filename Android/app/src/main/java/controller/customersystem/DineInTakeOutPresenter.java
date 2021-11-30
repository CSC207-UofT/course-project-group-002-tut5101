package controller.customersystem;

import constant.ordersystem.OrderType;

import java.util.Objects;

public class DineInTakeOutPresenter {
    SelectDineInTakeOutViewInterface selectDineInTakeOutViewInterface;

    public DineInTakeOutPresenter() {
    }

    public void setSelectDineInTakeOutViewInterface(SelectDineInTakeOutViewInterface selectDineInTakeOutViewInterface) {
        this.selectDineInTakeOutViewInterface = selectDineInTakeOutViewInterface;
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
