package entity.inventory;

/**
 * Entity class for alcohol.
 */

import java.io.Serializable;

public class Alcohol implements Inventory, Serializable {
    public String name;
    protected boolean usedup;
    protected double price;
    protected double quantity;
    public final int ExpiryDate;

    /**
     * Construct an instance of Product
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param ExpiryDate The ExiryDate of the Product
     */

    public Alcohol(String name, double price, double quantity, int ExpiryDate){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ExpiryDate = ExpiryDate;
        this.usedup = quantity == 0;
    }
    @Override
    public String getName(){return this.name;}

    @Override
    public boolean getUsedup(){
        return this.usedup;
    }


    /**
     * Get the quantity of an Inventory
     * @return The quantity of the Inventory as a double.
     */
    @Override
    public double getQuantity(){
        return this.quantity;
    }

    /**
     * Check wether have enough Inventory for use and change the amount of it
     * @param usage The required amount of usage of this inventory
     * @return Wether the inventory is enough to use.
     */
    @Override
    public void updateQuantity(double usage){
        if(this.quantity >= usage){
            this.quantity -= usage;
            if(this.quantity == 0){
                this.usedup = true;
            }
        }
        else{System.out.println("Not enough");}
    }


    /**
     * Get the ExpiryDate of a Product
     * @return The ExpiryDate of the Product as an int.
     */


    @Override
    public String toString(){
        String s = "alcohol,"+this.name+ ","+ this.price +
                ","+ this.quantity +","+ this.ExpiryDate;
        return s;

    }
}

