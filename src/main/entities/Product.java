package entities;

public abstract class Product extends Inventory{
    public int ExpiryDate;

    public Product(String name, boolean usedup, double price, double quantity, int ExpiryDate){
        super(name, usedup, price, quantity);
        this.ExpiryDate = ExpiryDate;
    }

    public int getExpiryDate(){
        return this.ExpiryDate;
    }
}
