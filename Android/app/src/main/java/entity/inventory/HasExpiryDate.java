package entity.inventory;



import androidx.annotation.NonNull;

import java.io.Serializable;
/**
 * Entity class for alcohol.
 */

public class HasExpiryDate implements Inventory, Serializable {
    private final String name;
    private boolean usedup;
    private final double price;
    private int quantity;
    private final int ExpiryDate;

    /**
     * Construct an instance of Product
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param ExpiryDate The ExiryDate of the Product
     */

    public HasExpiryDate(String name, double price, int quantity, int ExpiryDate){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ExpiryDate = ExpiryDate;
        this.usedup = quantity == 0;
    }

    /**
     * @return the name of the item
     */
    @Override
    public String getName(){return this.name;}

    /**
     * @return whether the item has been used up
     */
    @Override
    public boolean getUsedUp(){
        return this.usedup;
    }


    /**
     * Get the quantity of an Inventory
     * @return The quantity of the Inventory as a double.
     */
    @Override
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Check wether have enough Inventory for use and change the amount of it
     * @param usage The required amount of usage of this inventory
     * @return Whether the inventory is enough to use.
     */
    @Override
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
     * Get the ExpiryDate of a Product
     * @return The ExpiryDate of the Product as an int.
     */


    @Override
    @NonNull
    public String toString(){
        return this.name+ ","+ this.price +
                ","+ this.quantity +","+ this.ExpiryDate;

    }
}


