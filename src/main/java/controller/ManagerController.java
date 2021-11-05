package controller;


import boundary.DeleteReviewInputBoundary;
import boundary.ManageMenuInputBoundary;
import use_case.DeleteReviewUseCase;
import use_case.ManageMenuUseCase;

public class ManagerController {

    private final ManageMenuInputBoundary manageMenuInputBoundary;
    private final DeleteReviewInputBoundary deleteReviewInputBoundary;

    public ManagerController() {
        this.manageMenuInputBoundary = new ManageMenuUseCase();
        this.deleteReviewInputBoundary = new DeleteReviewUseCase();
    }

    public void manageMenu(){
        manageMenuInputBoundary.manageMenu();
    }

    public void deleteReview(){
        deleteReviewInputBoundary.deleteReview();
    }
}
