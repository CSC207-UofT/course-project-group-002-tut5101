package entities;

public class VegeFruit extends Material{

    /**
     * Construct an instance of vegeFruit
     * @param name The name of the Inventory
     * @param usedup The status of wether the Inventory used up or not
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param freshness The freshness of the Material
     * @param ImportDate The ImportDate of the Material
     */
    public VegeFruit(String name, boolean usedup, double price, double quantity, String freshness,
                     int ImportDate){
        super(name, usedup, price, quantity, freshness, ImportDate);

    }

}
