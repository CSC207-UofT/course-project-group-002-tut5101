package presenter.kitchen_system;

import java.util.ArrayList;

public interface KitchenView {

    /**
     * Update the current dishes to display by mutating the arraylist that holds all display info.
     * @param displayDishes the updated array list of dish infos.
     */
    void renewDishes(ArrayList<String[]> displayDishes);

    /**
     * Update the display by notifying the listener.
     */
    void updateListDisplay();
}
