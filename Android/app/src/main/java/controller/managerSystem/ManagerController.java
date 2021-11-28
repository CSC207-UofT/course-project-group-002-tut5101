package controller.managerSystem;


import entity.customer.Customer;
import entity.delivery.DeliveryStaff;
import entity.delivery.ServingStaff;
import entity.inventory.InventoryStaff;
import entity.kitchen.KitchenStaff;
import entity.manager.Manager;
import use_case.boundary.input.DeleteReviewInputBoundary;
import use_case.boundary.input.EnrollUserInputBoundary;
import use_case.boundary.input.ManageMenuInputBoundary;
import use_case.boundary.output.EnrollUserOutputBoundary;
import use_case.reviewList.DeleteReviewUseCase;
import use_case.dishList.DishList;
import use_case.menuManager.ManageMenuUseCase;
import use_case.reviewList.ReviewList;
import use_case.userList.EnrollStaffUseCase;
import use_case.userList.UserList;

/**
 * Controller class for manager.
 */


public class ManagerController {

    /**
     * The input use_case.boundary for the manage menu use case.
     */
    private final ManageMenuInputBoundary manageMenuInputBoundary;
    /**
     * The input use_case.boundary for delete review use case.
     */
    private final DeleteReviewInputBoundary deleteReviewInputBoundary;
    /**
     * The input and output user_case.boundary for enrolling new staff use case.
     */
    private final EnrollUserInputBoundary enrollUserInputBoundary;


    /**
     * Read menu from file. The menu file location is saved in constant.fileSystem.FileLocation.MENU_FILE_LOCATION.
     *
     * @return the DishList type object that contains all dishes saved in menu file.
     */
    private DishList loadMenu() {
        return new DishList();
    }

    /**
     * Read reviews from file. The file location is saved in constant.fileSystem.FileLocation.REVIEW_LIST_LOCATION.
     *
     * @return the ReviewList type object that contains all reviews saved in the review file.
     */
    private ReviewList loadReviewList(){
        return new ReviewList();
    }

    //todo add doc
    private UserList loadUserList(){
//        return new UserList();
        //TODO hardcode since File I/O issue, need delete later
        UserList users = new UserList();
        users.addUser(new Manager());
        users.addUser(new Customer("1", "James", "12345"));
        users.addUser(new DeliveryStaff("2", "Amy", "12345", 3500));
        users.addUser(new ServingStaff("3", "Eve", "12345", 3665));
        users.addUser(new KitchenStaff("4", "Bob", "12345", 5000));
        users.addUser(new InventoryStaff("5", "Frank", "12345", 3600));
        return users;
    }

    /**
     * Constructor of the ManagerController
     */
    public ManagerController() {
        ReviewList reviewList = loadReviewList();
        DishList dishList = loadMenu();
        this.manageMenuInputBoundary = new ManageMenuUseCase(dishList);
        this.deleteReviewInputBoundary = new DeleteReviewUseCase(reviewList);
        this.enrollUserInputBoundary = new EnrollStaffUseCase(loadUserList());
    }

    /**
     * Run the manage menu use case.
     */
    public void manageMenu(){
        manageMenuInputBoundary.manageMenu();
    }

    /**
     * Run delete review use case.
     */
    public void deleteReview(){
        deleteReviewInputBoundary.deleteReview();
    }

    //todo add doc
    public void enrollNewUser(String newUserId, String newUserName, String newUserPassword,
                              String userType, String salary){
        enrollUserInputBoundary.enrollNewStaff(newUserId, newUserName, newUserPassword, userType, Integer.parseInt(salary));
    }

    //todo add doc
    public void getNewUserId(){
        enrollUserInputBoundary.getNewUserId();
    }
    //todo add doc
    public void setEnrollUserOutputBoundary(EnrollUserOutputBoundary outputBoundary){
        enrollUserInputBoundary.setOutputBoundary(outputBoundary);
    }
    //todo add doc
    public void getStaffTypes(){
        enrollUserInputBoundary.getStaffTypes();
    }
}
