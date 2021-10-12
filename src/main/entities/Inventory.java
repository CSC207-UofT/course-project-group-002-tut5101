package entities;

public abstract class Inventory{

    public String name;
    public boolean usedup;
    public double price;
    public double quantity;

    /**
     * Construct an instance of Inventory
     * @param name The name of the Inventory
     * @param usedup The status of wether the Inventory used up or not
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     */

    public Inventory(String name, boolean usedup, double price, double quantity){
        this.name = name;
        this.usedup = usedup;
        this.price = price;
        this.quantity = quantity;
    }


    /**
     * Get the quantity of an Inventory
     * @return The quantity of the Inventory as a double.
     */

    public double getQuantity(){
        return this.quantity;
    }

    /**
     * Check wether have enough Inventory for use and change the amount of it
     * @param usage The required amount of usage of this inventory
     * @return Wether the inventory is enough to use.
     */

    public boolean updateQuantity(double usage){
        boolean enough = true;
        if(this.quantity >= usage){
            this.quantity -= usage;
        } else {
            enough = false;
        }
        return enough;
    }
}
