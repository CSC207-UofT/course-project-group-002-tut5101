public abstract class Inventory{
    public String name;
    public boolean usedup;
    public double price;
    public double quantity

    public Inventory(name: String, usedup: boolean, price: double, quantity: double){
        this.name = name;
        this.usedup = usedup;
        this.price = price;
        this.quantity = quantity;
    }

    public double getQuantity(){
        return this.quantity;
    }

    public boolean UpdateQuantity(double: usage){
        boolean enough = true;
        if(this.quantity >= usage){
            this.quantity -= uasge;
        }
        else{enough = false}
        return enough;
    }
}