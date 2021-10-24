package UI;

import constant.UIMessage;

import java.util.Scanner;

public class ManagerUI {
    public static void main(String[] args) {
        System.out.println(UIMessage.GREETING_ASK_FOR_ACTION + UIMessage.MANAGER_ACTIONS);
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
    }
}
