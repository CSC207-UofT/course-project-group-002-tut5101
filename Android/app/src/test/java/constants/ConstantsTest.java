package constants;

import constant.customer_system.CustomerUIMessage;
import constant.file_system.FileName;
import constant.manger_system.DishMessage;
import constant.manger_system.ManagerDecision;
import constant.manger_system.ReviewMessage;
import constant.manger_system.UserType;
import constant.order_system.BuildOrderInfo;
import constant.order_system.ItemStatus;
import constant.order_system.OrderType;
import constant.ui_message.EnrollUserMessage;
import constant.ui_message.LoginLogoutUIMessage;
import constant.ui_message.LoginResult;
import constant.ui_message.ManagerUIMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing constants
 */
public class ConstantsTest {

    /**
     * Test Customer UI message
     */
    @Test
    public void CustomerUI() {
        assertEquals(CustomerUIMessage.RETURN_TO_MAIN_MENU, "Return to main menu");
        assertEquals(CustomerUIMessage.ORDER_PLACED_MESSAGE,"Your order was successfully placed!");
        assertEquals(CustomerUIMessage.SUCCEED, "Succeed");
    }

    /**
     * Test FileName
     */
    @Test
    public void FileName() {
        assertEquals(FileName.MENU_FILE, "menu.ser");
        assertEquals(FileName.USER_FILE, "users.ser");
        assertEquals(FileName.INVENTORY_FILE, "inventory.ser");
        assertEquals(FileName.REVIEW_FILE, "review.ser");
    }

    /**
     * Tests for review message constants
     */
    @Test
    public void ReviewMessage() {
        assertEquals(ReviewMessage.CONFIRM, "Are you sure you want to delete reviews?");
        assertEquals(ReviewMessage.DELETE_REVIEW, "Review under this score will be deleted.");
        assertEquals(ReviewMessage.YES, "Yes");
        assertEquals(ReviewMessage.NO, "No");
    }

    /**
     * Test user types
     */
    @Test
    public void UserType() {
        assertEquals(UserType.CUSTOMER, UserType.CUSTOMER);
    }

    /**
     * Test build order info
     */
    @Test
    public void BuildOrderInfo() {
        assertEquals(BuildOrderInfo.ORDER_TYPE, BuildOrderInfo.ORDER_TYPE);
        assertEquals(BuildOrderInfo.LOCATION, BuildOrderInfo.LOCATION);
        assertEquals(BuildOrderInfo.DISHES, BuildOrderInfo.DISHES);
        assertEquals(BuildOrderInfo.PRICES, BuildOrderInfo.PRICES);
    }

    /**
     * Test item status
     */
    @Test
    public void ItemStatus() {
        assertEquals(ItemStatus.DISH_COMPLETED, ItemStatus.DISH_COMPLETED);
    }

    /**
     * Test order type
     */
    @Test
    public void OrderType() {
        assertEquals(OrderType.DINE_IN, OrderType.DINE_IN);
        assertEquals(OrderType.DELIVERY, OrderType.DELIVERY);
    }

    /**
     * Test enroll user message
     */
    @Test
    public void EnrollUserMessage() {
        assertEquals(EnrollUserMessage.INFO_REQUIRED, "Info required!");
        assertEquals(EnrollUserMessage.PASSWORD_NOT_MATCH, "Password not match");
        assertEquals(EnrollUserMessage.PASSWORD_NOT_MATCH_MESSAGE, "The password is not matching, please re-enter.");
        assertEquals(EnrollUserMessage.SUCCEED, "Succeed");
        assertEquals(EnrollUserMessage.ENROLL_SUCCEED_MESSAGE, "Succeed! Please remember the new staff's user id: ");
        assertEquals(EnrollUserMessage.ARE_YOU_SURE, "Are you sure?");
        assertEquals(EnrollUserMessage.CANCEL_ENROLLMENT, "The enrollment will be canceled, and the information that you have entered will be lost.");
        assertEquals(EnrollUserMessage.YES, "Yes");
        assertEquals(EnrollUserMessage.NO, "No");
    }

    /**
     * Test for dish message
     */
    @Test
    public void DishMessage() {
        assertEquals(DishMessage.CONFIRM, "Are you sure you want to delete this dish?");
        assertEquals(DishMessage.NO, "No");
        assertEquals(DishMessage.DELETE_MENU, "This dish will be deleted.");
        assertEquals(DishMessage.YES, "Yes");
        assertEquals(DishMessage.EDIT_MENU, "This dish will be edited as you specified");
        assertEquals(DishMessage.CONFIRMING, "Are you sure you want to edit this dish in this way?");
    }

    @Test
    public void ManagerDecision() {
        assertEquals(ManagerDecision.DELETE, ManagerDecision.DELETE);
        assertEquals(ManagerDecision.DECREASE_CALORIES, ManagerDecision.DECREASE_CALORIES);
        assertEquals(ManagerDecision.DECREASE_PRICE, ManagerDecision.DECREASE_PRICE);
        assertEquals(ManagerDecision.INCREASE_CALORIES, ManagerDecision.INCREASE_CALORIES);
        assertEquals(ManagerDecision.INCREASE_PRICE, ManagerDecision.INCREASE_PRICE);
    }


    /**
     * Test the ManagerUIMessage
     */
    @Test
    public void ManagerUI() {
        assertEquals(ManagerUIMessage.MANAGE_DISH, "What dish do you want to manage?");
        assertEquals(ManagerUIMessage.EDIT_DELETE, "Ao you want to edit or delete this dish?");
        assertEquals(ManagerUIMessage.DELETE_REVIEW, "What is the criteria for deletion?");
    }

    /**
     * Test LoginLogoutUI.
     */
    @Test
    public void LoginLogoutUI(){
        assertEquals(LoginLogoutUIMessage.LOGIN_FAILED_MESSAGE, "Please enter the correct password.");
        assertEquals(LoginLogoutUIMessage.LOGIN_FAILED, "Login Failed");
        assertEquals(LoginLogoutUIMessage.LOGIN_SUCCEED, "Login Succeed!");
        assertEquals(LoginLogoutUIMessage.OK, "OK");
        assertEquals(LoginLogoutUIMessage.SIGN_UP, "Sign Up?");
        assertEquals(LoginLogoutUIMessage.STAFF_SIGNUP, "Your ID is not in the system yet, please ask Manager for help.");
    }

    /**
     * Test login result
     */
    @Test
    public void LoginResult() {
        assertEquals(LoginResult.FAILURE, LoginResult.FAILURE);
        assertEquals(LoginResult.SUCCESS, LoginResult.SUCCESS);
        assertEquals(LoginResult.NO_SUCH_USER, LoginResult.NO_SUCH_USER);
    }

}
