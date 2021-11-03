package UI;

import constant.KitchenUIMessage;
import controller.KitchenController;

import java.util.Scanner;

/**
 * The user interface for Kitchen.
 */

//TODO: notification system
//TODO: allow multiple orders to be processed at the same time
public class KitchenUI implements UserInterface {

    private KitchenController kc = new KitchenController();

    public void loadUi(String id) {
        System.out.println(KitchenUIMessage.SELECT_ACTION);
        System.out.println(kc.showOrder());
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(kc.showDishesToCook());

            String action = scanner.nextLine();
            if (action.equals("0")) {
                return;
            }
            kc.completeDish(action);
        }
    }
}
