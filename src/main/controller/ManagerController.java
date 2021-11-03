package controller;

import boundary.ManagerInputBoundary;
import use_case.DishList;
import use_case.InventoryList;
import use_case.ManagerUseCase;
import use_case.ReviewList;

public class ManagerController {

    private final ManagerInputBoundary managerInputBoundary;

    public ManagerController() {
        this.managerInputBoundary = new ManagerUseCase();
    }

    public void manageMenu(){
        managerInputBoundary.manageMenu();
    }

    public void deleteReview(ReviewList reviewList){
        managerInputBoundary.deleteReview(reviewList);
    }
}
