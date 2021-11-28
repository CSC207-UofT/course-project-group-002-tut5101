package entity.inventory;


import java.io.Serializable;

/**
 * Inventory interface
 */
public interface Inventory extends Serializable {



    String getName();

    boolean getUsedup();


    /**
     * Get the quantity of an Inventory
     * @return The quantity of the Inventory as a double.
     */

    double getQuantity();

    /**
     * Check whether have enough Inventory for use and change the amount of it
     * @param usage The required amount of usage of this inventory
     * @return Whether the inventory is enough to use.
     */

    void updateQuantity(double usage);


    String toString();

}
