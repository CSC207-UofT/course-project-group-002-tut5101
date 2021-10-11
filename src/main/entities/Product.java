public abstract class Product extends Inventory{
    public int ExpiryDate;

    public Product(name: String, usedup: boolean,price: double,quantity: double,ExpiryDate: int){
        super(name, usedup, price, quantity);
        this.ExpiryDate = ExpiryDate;

    }

    public int getExpiryDate(){
        return this.ExpiryDate;
    }
}
