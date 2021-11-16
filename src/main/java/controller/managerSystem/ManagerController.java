package controller.managerSystem;


import use_case.boundary.DeleteReviewInputBoundary;
import use_case.boundary.ManageMenuInputBoundary;
import constant.fileSystem.FileLocation;
import gateway.MenuReadWriter;
import gateway.ReadWriter;
import use_case.reviewList.DeleteReviewUseCase;
import use_case.dishList.DishList;
import use_case.menuManager.ManageMenuUseCase;
import use_case.reviewList.ReviewList;

/**
 * Controller class for manager.
 */


public class ManagerController {

    /**
     * The input use_case.boundary for the manage menu use case.
     */
    private final ManageMenuInputBoundary manageMenuInputBoundary;
    /**
     * The input use_case.boundary for the delete review use case.
     */
    private final DeleteReviewInputBoundary deleteReviewInputBoundary;


    /**
     * Read menu from file. The menu file location is saved in constant.fileSystem.FileLocation.MENU_FILE_LOCATION.
     *
     * @return the DishList type object that contains all dishes saved in menu file.
     */
    private DishList loadMenu() {
        ReadWriter readWriter = new MenuReadWriter();
        DishList d = new DishList(readWriter.readFromFile(FileLocation.MENU_FILE_LOCATION));
        return d;
    }

    /**
     * Read reviews from file. The file location is saved in constant.fileSystem.FileLocation.REVIEW_LIST_LOCATION.
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
