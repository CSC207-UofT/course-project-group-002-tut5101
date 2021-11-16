package entity.inventory;
/**
 * Entity class for semi-finished products.
 */


import java.io.Serializable;

public class SemiFinished implements Inventory, Serializable {
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

    public SemiFinished(String name, double price, double quantity, int ExpiryDate){
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



    @Override
    public String toString(){
        String s = "semifinished,"+this.name+ ","+ this.price +
                ","+ this.quantity +","+ this.ExpiryDate;
        return s;

    }
}
