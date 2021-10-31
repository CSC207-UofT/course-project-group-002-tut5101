package UI;

import constant.CustomerUIMessage;

import java.util.Scanner;

public class KitchenUI implements UserInterface{
    public void loadUi(String id) {
        while (true) {
            System.out.println(CustomerUIMessage.CUSTOMER_ACTIONS);
            System.out.println(CustomerUIMessage.SELECT_ACTION);
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    break;

            }
        }
    }
}
