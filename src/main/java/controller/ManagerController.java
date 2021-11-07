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

/**
 * Controller class for manager.
 */


public class ManagerController {

    /**
     * The input boundary for the manage menu use case.
     */
    private final ManageMenuInputBoundary manageMenuInputBoundary;
    /**
     * The input boundary for the delete review use case.
     */
    private final DeleteReviewInputBoundary deleteReviewInputBoundary;


    /**
     * Read menu from file. The menu file location is saved in constant.FileLocation.MENU_FILE_LOCATION.
     *
     * @return the DishList type object that contains all dishes saved in menu file.
     */
    private DishList loadMenu() {
        ReadWriter readWriter = new MenuReadWriter();
        DishList d = new DishList(readWriter.readFromFile(FileLocation.MENU_FILE_LOCATION));
        return d;
    }

    /**
     * Read reviews from file. The file location is saved in constant.FileLocation.REVIEW_LIST_LOCATION.
     *
     * @return the ReviewList type object that contains all reviews saved in the review file.
     */
    private ReviewList loadReviewList(){
        ReadWriter readWriter = new ReviewReadWriter();
        ReviewList r = new ReviewList(readWriter.readFromFile(FileLocation.REVIEW_LIST_LOCATION));
        return r;
    }

    /**
     * Constructor of the ManagerController
     */
    public ManagerController() {
        ReviewList reviewList = loadReviewList();
        DishList dishList = loadMenu();
        this.manageMenuInputBoundary = new ManageMenuUseCase(dishList);
        this.deleteReviewInputBoundary = new DeleteReviewUseCase(reviewList);
    }

    /**
     * Run the manage menu use case.
     */
    public void manageMenu(){
        manageMenuInputBoundary.manageMenu();
    }

    /**
     * Run the delete review use case.
     */
    public void deleteReview(){
        deleteReviewInputBoundary.deleteReview();
    }
}
