public abstract class Material extends Inventory implements Expiryable{
    public String freshness;
    public int ImportDate

    public Product(name: String, usedup: boolean,price: double,quantity: double, freshness: String
                    ImportDate: int){
        super(name, usedup, price, quantity);
        this.freshness = freshness;
        this.ImportDate = ImportDate;
        }

    public String getfreshness(){
        return this.freshness;
        }

    public void setFreshness(String NewFreshness){
        this.freshness = NewFreshness;
    }
}
