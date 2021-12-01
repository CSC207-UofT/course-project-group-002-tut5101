package entity.inventory;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Entity class for dairy soy.
 */


public class HasFreshness implements Inventory, Serializable {
    private final String name;
    private boolean usedup;
    private final double price;
    private int quantity;
    private String freshness;
    private final int ImportDate;


    /**
     * Construct an instance of Material
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param freshness The freshness of the Material
     * @param ImportDate The ImportDate of the Material
     */

    public HasFreshness(String name, double price, int quantity, String freshness,
                        int ImportDate){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.freshness = freshness;
        this.ImportDate = ImportDate;
        this.usedup = quantity == 0;
    }

    /**
     * @return the name of the item
     */
    @Override
    public String getName(){return this.name;}

    /**
     * @return if the item is used up
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
     * Check whether have enough Inventory for use and change the amount of it
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
     * Get the freshness of a Material
     * @return The freshness of the Material as a string.
     */


    public String getFreshness(){
        return this.freshness;
    }



    /**
     * Change the freshness status of a Material
     * @param NewFreshness The new freshness status of this Material
     */

    public void setFreshness(String NewFreshness){
        this.freshness = NewFreshness;
    }

    /**
     *
     * @return the string representation of the inventory item
     */
    @NonNull
    @Override
    public String toString(){
        return this.name+ ","+ this.price +
                ","+ this.quantity +","+ this.freshness+","+ this.ImportDate;

    }

    /**
     * @param o object to compare to
     * @return true if contents of inventory item (name, quantity, price, etc.) are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HasFreshness)) return false;
        HasFreshness that = (HasFreshness) o;
        return usedup == that.usedup && Double.compare(that.price, price) == 0 && quantity == that.quantity && ImportDate == that.ImportDate && Objects.equals(name, that.name) && Objects.equals(freshness, that.freshness);
    }

}

