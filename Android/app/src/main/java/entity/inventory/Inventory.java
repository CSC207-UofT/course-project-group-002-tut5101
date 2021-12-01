package entity.inventory;


import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Inventory interface
 */
public interface Inventory extends Serializable {



    String getName();

    boolean getUsedUp();


    /**
     * Get the quantity of an Inventory
     * @return The quantity of the Inventory as a double.
     */

    int getQuantity();

    /**
     * Check whether have enough Inventory for use and change the amount of it
     * @param usage The required amount of usage of this inventory
     * Whether the inventory is enough to use.
     */

    String updateQuantity(int usage);


    @NonNull
    @Override
    String toString();

}
