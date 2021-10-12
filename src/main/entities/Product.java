package entities;

public abstract class Product extends Inventory{
    public int ExpiryDate;

    /**
     * Construct an instance of Product
     * @param name The name of the Inventory
     * @param usedup The status of wether the Inventory used up or not
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param ExpiryDate The ExiryDate of the Product
     */

    public Product(String name, boolean usedup, double price, double quantity, int ExpiryDate){
        super(name, usedup, price, quantity);
        this.ExpiryDate = ExpiryDate;
    }

    /**
     * Get the ExpiryDate of a Product
     * @return The ExpiryDate of the Product as an int.
     */

    public int getExpiryDate(){
        return this.ExpiryDate;
    }
}
