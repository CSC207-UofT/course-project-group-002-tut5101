package UI;

import constant.KitchenUIMessage;
import controller.KitchenController;
import java.util.Scanner;

/**
 * The user interface for Kitchen.
 */

//TODO: notification system
public class KitchenUI implements UserInterface {

    private KitchenController kc = new KitchenController();

    public void loadUi(String id) {
        System.out.println(KitchenUIMessage.ACTION);
        Scanner scanner = new Scanner(System.in);
        boolean newOrder = true;
        while (true) {
            if (kc.hasOrder()) {
                if (newOrder) {
                    System.out.println(KitchenUIMessage.NEW_ORDER);
                    newOrder = true;
                }
                System.out.println(kc.showDishes());
                String action = scanner.nextLine();
                if (action.equals("0")) {
                    return;
                }
                int separator = action.indexOf(";");
                String dishName = action.substring(0, separator).strip();
                String temp = action.substring(separator + 1).toLowerCase().strip();
                boolean markComplete = temp.equals("cook") || temp.equals("cooked");
                boolean getIngredient = temp.equals("ingredient") || temp.equals("ingredients");

                if (markComplete) {
                    newOrder = kc.completeDish(dishName);
                    System.out.println(KitchenUIMessage.DISH_COMPLETE);
                } else if (getIngredient){
                    System.out.println(kc.displayIngredient(dishName));
                }
            } else {
                System.out.println("No more order for now, BYE~");
                return;
            }

        }
    }
}