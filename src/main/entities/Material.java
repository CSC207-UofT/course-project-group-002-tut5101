package entities;

public abstract class Material extends Inventory implements Expiryable {
    public String freshness;
    public int ImportDate;

    public Material(String name, boolean usedup, double price, double quantity, String freshness,
                   int ImportDate){
        super(name, usedup, price, quantity);
        this.freshness = freshness;
        this.ImportDate = ImportDate;
    }

    public String getFreshness(){
        return this.freshness;
        }

    public void setFreshness(String NewFreshness){
        this.freshness = NewFreshness;
    }
}
