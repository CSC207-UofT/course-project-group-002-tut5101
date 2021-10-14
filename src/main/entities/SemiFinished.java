package entities;

public class SemiFinished extends Product{

    /**
     * Construct an instance of SemiFinished
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param ExpiryDate The ExiryDate of the Product
     */
    public SemiFinished(String name, double price, double quantity, int ExpiryDate){
        super(name, price, quantity, ExpiryDate);
    }
}