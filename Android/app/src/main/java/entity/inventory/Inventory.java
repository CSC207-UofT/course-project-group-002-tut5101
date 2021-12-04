package entity.inventory;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Entity class for dairy soy.
 */


public abstract class Inventory implements Serializable {
    protected int id;
    protected String name;
    protected boolean usedup;
    protected double price;
    protected int quantity;



    /**
     * Construct an instance of Material
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     */

    public Inventory(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.usedup = quantity == 0;
    }

    /**
     * set the id of the item
     */
    public void setId(int id){this.id = id;}

    /**
     * @return the name of the item
     */

    public String getName(){return this.name;}

    /**
     * @return if the item is used up
     */

    public boolean getUsedUp(){
        return this.usedup;
    }


    /**
     * Get the quantity of an Inventory
     * @return The quantity of the Inventory as a double.
     */

    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Check whether have enough Inventory for use and change the amount of it
     * @param usage The required amount of usage of this inventory
     * @return Whether the inventory is enough to use.
     */

    public String updateQuantity(int usage){
        String message;
        if(this.quantity >= usage){
            this.quantity -= usage;
            if(this.quantity == 0){
                this.usedup = true;
            }
            message = "Successfully updated";
        }
        else{message = "Not enough";}
        return message;
    }







    /**
     *
     * @return the string representation of the inventory item
     */
    @NonNull
    @Override
    public abstract String toString();

    /**
     * @param o object to compare to
     * @return true if contents of inventory item (name, quantity, price, etc.) are the same
     */
    @Override
    public abstract boolean equals(Object o);
}

