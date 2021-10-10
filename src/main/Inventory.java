public abstract class Inventory {
    public String name;
    public boolean usedup;
    public double price;

    public Inventory(name: String, usedup: boolean, price: double){
        this.name = name;
        this.usedup = usedup;
        this.price = price
    }
}
