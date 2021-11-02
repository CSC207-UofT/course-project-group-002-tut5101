package entity;

public abstract class Inventory{

    public String name;
    protected boolean usedup;
    protected double price;
    protected double quantity;

    /**
     * Construct an instance of Inventory
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     */

    public Inventory(String name, double price, double quantity){
        this.name = name;
        this.usedup = quantity == 0;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Get the used up status of an Inventory
     * @return The used up status of the Inventory as a boolean.
     */

    public boolean getUsedup(){
        return this.usedup;
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
            if(this.quantity == 0){
                this.usedup = true;
            }
        }
        else {
            enough = false;
        }
        return enough;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", usedup=" + usedup +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
