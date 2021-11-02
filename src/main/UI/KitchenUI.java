package UI;

import constant.KitchenUIMessage;
import controller.KitchenController;

import java.util.Scanner;

/**
 * The user interface for Kitchen.
 */

public class KitchenUI implements UserInterface {

    private KitchenController kc = new KitchenController();

    public void loadUi(String id) {
        while (true) {
            System.out.println(KitchenUIMessage.SELECT_ACTION);
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    // Case 1: display order if there is order to be cooked.
                    System.out.println(kc.showOrder());
                    break;
                case "2":
                    System.out.println(KitchenUIMessage.COMPLETE_DISH);
                    System.out.println(kc.showDishesToCook());
                    kc.completeDish(scanner.nextLine());
                    break;
                case "0":
                    return;

            }
        }
    }
}
