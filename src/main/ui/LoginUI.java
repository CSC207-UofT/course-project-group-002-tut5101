package ui;

import constant.UIMessage;
import controller.LoginController;

import java.util.Scanner;

public class LoginUI {
    /**
     * Cmd UI of login.
     *
     * @param controller
     * @return id of the user if login succeed, otherwise, return null;
     */
    public String runLogin(LoginController controller) {
        System.out.println(UIMessage.ASK_FOR_ID);
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        System.out.println(UIMessage.ASK_FOR_PASSWORD);
        String password = scanner.nextLine();
        switch (controller.runLogin(id, password)) {
            case NO_SUCH_USER:
                System.out.println(UIMessage.ASK_FOR_SIGNUP);
                return null;
            case FAILURE:
                System.out.println(UIMessage.LOGIN_FAILED);
                return null;
            case SUCCESS:
                return id;
            default:
                return null;
        }
    }
}
