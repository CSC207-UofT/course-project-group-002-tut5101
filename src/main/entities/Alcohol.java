package entities;

public class Alcohol extends Product{

    /**
     * Construct an instance of Alcohol
     * @param name The name of the Inventory
     * @param usedup The status of wether the Inventory used up or not
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param ExpiryDate The ExiryDate of the Product
     */
    public Alcohol(String name, boolean usedup, double price, double quantity, int ExpiryDate){
        super(name, usedup, price, quantity, ExpiryDate);

    }
}

