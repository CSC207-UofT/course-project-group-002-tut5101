package entities;

public abstract class Material extends Inventory{

    public String freshness;
    public int ImportDate;

    /**
     * Construct an instance of Material
     * @param name The name of the Inventory
     * @param usedup The status of wether the Inventory used up or not
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param freshness The freshness of the Material
     * @param ImportDate The ImportDate of the Material
     */

    public Material(String name, boolean usedup, double price, double quantity, String freshness,
                   int ImportDate){
        super(name, usedup, price, quantity);
        this.freshness = freshness;
        this.ImportDate = ImportDate;
    }

    /**
     * Get the freshness of a Material
     * @return The freshness of the Material as a string.
     */

    public String getFreshness(){
        return this.freshness;
        }

    /**
     * Change the freshness status of a Material
     * @param NewFreshness The new freshness status of this Material
     */

    public void setFreshness(String NewFreshness){
        this.freshness = NewFreshness;
    }
}
