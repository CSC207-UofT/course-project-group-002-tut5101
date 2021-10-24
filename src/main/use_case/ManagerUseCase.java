package use_case;

import boundary.ManagerInputBoundary;

public class ManagerUseCase implements ManagerInputBoundary {

//    /**
//     * Manager issue payment to a specific staff.
//     *
//     * @param manager the current manager in system
//     * @param staff   the staff who are getting payment
//     * @return true iff the payment issue succeed
//     */
//    public boolean payStaffSalary(Manager managerId, Staff staffId) {
//
//        return false;
//    }

    /**
     * // TODO not clear what the staff be assigned for?
     * Manager assign
     *
     * @param staffId   the new staff id who will be assigned
     * @return true iff the assignment succeed
     */
    public boolean assignServingStaff(String staffId) {
        //TODO
        return false;
    }

//    /**
//     * Manager process enrollment of new staff.
//     *
//     * @param manager the current manager in system
//     * @param staff   the new staff who will be enrolled
//     * @return true iff the enrollment process success
//     */
//    public boolean enrollStaff(Manager managerId, Staff staffId) {
//        //TODO
//        return false;
//    }

    /**
     * Manager adjust the menu(dish list).
     *
     * @param menu      the current menu in system
     * @return true     iff the adjustment is made successfully
     */
    public boolean manageMenu(DishList menu) {
        //TODO
        return false;
    }


    /**
     * Manager request out of stock status.
     *
     * @param inventoryList the current inventory status in system
     * @return true iff the request is made successfully
     */
    public boolean requestInventory(InventoryList inventoryList) {
        //TODO
        return false;
    }

    /**
     *
     * @param review    the review that will be updated
     * @return true iff the adjustment is made successfully
     */
    public boolean deleteReview() {
        //TODO
        return false;
    }


}
