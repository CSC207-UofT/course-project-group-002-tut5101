public abstract class Product extends Inventory implements Expiryable {
    public int ExpiryDate;

    public Product(name: String, usedup: boolean,price: double, ExpiryDate: int){
        super(name, usedup, price);
        this.ExpiryDate = ExpiryDate;

    }

    public int getExpiryDate(){
        return this.ExpiryDate;
    }
}
