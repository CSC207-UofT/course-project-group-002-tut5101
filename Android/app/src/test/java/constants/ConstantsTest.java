package constants;

import constant.ui_message.EnrollUserMessage;
import constant.ui_message.LoginLogoutUIMessage;
import constant.ui_message.ManagerUIMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing constants
 */
public class ConstantsTest {


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
     * Test EnrollUser.
     */
    @Test
    public void EnrollUser(){
        assertEquals(EnrollUserMessage.ENROLL_SUCCEED_MESSAGE, "Succeed! Please remember the new staff's user id: ");
        assertEquals(EnrollUserMessage.PASSWORD_NOT_MATCH_MESSAGE, "The password is not matching, please re-enter.");
        assertEquals(EnrollUserMessage.CANCEL_ENROLLMENT, "The enrollment will be canceled, and the information that you have entered will be lost.");
        assertEquals(EnrollUserMessage.PASSWORD_NOT_MATCH, "Password not match");
        assertEquals(EnrollUserMessage.NO, "No");
        assertEquals(EnrollUserMessage.ARE_YOU_SURE, "Are you sure?");
        assertEquals(EnrollUserMessage.INFO_REQUIRED, "Info required!");
        assertEquals(EnrollUserMessage.SUCCEED, "Succeed");
        assertEquals(EnrollUserMessage.YES, "Yes");
    }


}
