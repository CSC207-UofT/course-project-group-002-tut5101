package ui.loginPrompt;

import constant.uiMessage.LoginLogoutUIMessage;
import controller.loginSystem.LoginController;

import java.util.Scanner;

public class LoginUI {

    private final LoginController controller = new LoginController();

    /**
     * Cmd UI of login.
     *
     * @return id of the user if login succeed, otherwise, return null;
     */
    public String loadUi() {
        System.out.println(LoginLogoutUIMessage.ASK_FOR_ID);
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        System.out.println(LoginLogoutUIMessage.ASK_FOR_PASSWORD);
        String password = scanner.nextLine();
        switch (controller.runLogin(id, password)) {
            case NO_SUCH_USER:
                System.out.println(LoginLogoutUIMessage.ASK_FOR_SIGNUP);
                System.out.println("Please give your id, name and password in format of id,name,password eg. 2,Ben,12345");
                if (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    System.out.println(controller.RegisterUser(str));
                }
                return null;
            case FAILURE:
                System.out.println(LoginLogoutUIMessage.LOGIN_FAILED);
                return null;
            case SUCCESS:
                return id;
            default:
                return null;
        }
    }
}
