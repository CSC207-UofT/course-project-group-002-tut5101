package controller;


import boundary.DeleteReviewInputBoundary;
import boundary.ManageMenuInputBoundary;
import constant.FileLocation;
import gateway.MenuReadWriter;
import gateway.ReadWriter;
import gateway.ReviewReadWriter;
import use_case.DeleteReviewUseCase;
import use_case.DishList;
import use_case.ManageMenuUseCase;
import use_case.ReviewList;

public class ManagerController {

    private final ManageMenuInputBoundary manageMenuInputBoundary;
    private final DeleteReviewInputBoundary deleteReviewInputBoundary;

    private DishList loadMenu() {
        ReadWriter readWriter = new MenuReadWriter();
        DishList d = new DishList(readWriter.readFromFile(FileLocation.MENU_FILE_LOCATION));
        return d;
    }

    private ReviewList loadReviewList(){
        ReadWriter readWriter = new ReviewReadWriter();
        ReviewList r = new ReviewList(readWriter.readFromFile(FileLocation.REVIEW_LIST_LOCATION));
        return r;
    }

    public ManagerController() {
        ReviewList reviewList = loadReviewList();
        DishList dishList = loadMenu();
        this.manageMenuInputBoundary = new ManageMenuUseCase(dishList);
        this.deleteReviewInputBoundary = new DeleteReviewUseCase(reviewList);
    }

    public void manageMenu(){
        manageMenuInputBoundary.manageMenu();
    }

    public void deleteReview(){
        deleteReviewInputBoundary.deleteReview();
    }
}
