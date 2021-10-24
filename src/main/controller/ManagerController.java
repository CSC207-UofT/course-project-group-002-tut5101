package controller;

import boundary.ManagerInputBoundary;
import use_case.DishList;
import use_case.InventoryList;
import use_case.ManagerUseCase;

public class ManagerController {

    private final ManagerInputBoundary managerInputBoundary;

    public ManagerController() {
        this.managerInputBoundary = new ManagerUseCase();
    }

    public void assignStaffToTable(String staffID) {
        managerInputBoundary.assignServingStaff(staffID);
    }

    public void manageMenu(DishList dishList){
        managerInputBoundary.manageMenu(dishList);
    }

    public void requestInventory(InventoryList inventoryList){
        managerInputBoundary.requestInventory(inventoryList);
    }

    public void deleteReview(){
        managerInputBoundary.deleteReview();
    }
}
