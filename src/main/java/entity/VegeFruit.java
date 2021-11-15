package entity;
/**
 * Entity class for vegetable and fruits.
 */

import java.io.Serializable;

public class VegeFruit implements Inventory, HasFreshness, Serializable {
    public String name;
    private boolean usedup;
    private double price;
    private double quantity;
    private String freshness;
    private final int ImportDate;


    /**
     * Construct an instance of Material
     *
     * @param name       The name of the Inventory
     * @param price      The buy in price of the Inventory
     * @param quantity   The quantity of the Inventory
     * @param freshness  The freshness of the Material
     * @param ImportDate The ImportDate of the Material
     */

    public VegeFruit(String name, double price, double quantity, String freshness,
                     int ImportDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.freshness = freshness;
        this.ImportDate = ImportDate;
        this.usedup = quantity == 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean getUsedup() {
        return this.usedup;
    }


    /**
     * Get the quantity of an Inventory
     *
     * @return The quantity of the Inventory as a double.
     */
    @Override
    public double getQuantity() {
        return this.quantity;
    }

    /**
     * Check wether have enough Inventory for use and change the amount of it
     *
     * @param usage The required amount of usage of this inventory
     * @return Wether the inventory is enough to use.
     */
    @Override
    public void updateQuantity(double usage) {
        if (this.quantity >= usage) {
            this.quantity -= usage;
            if (this.quantity == 0) {
                this.usedup = true;
            }
        } else {
            System.out.println("Not enough");
        }
    }


    /**
     * Get the freshness of a Material
     *
     * @return The freshness of the Material as a string.
     */

    @Override
    public String getFreshness() {
        return this.freshness;
    }


    /**
     * Change the freshness status of a Material
     *
     * @param NewFreshness The new freshness status of this Material
     */
    @Override
    public void setFreshness(String NewFreshness) {
        this.freshness = NewFreshness;
    }

    @Override
    public String toString() {
        String s = "vegefruit," + this.name + "," + this.price +
                "," + this.quantity + "," + this.freshness + "," + this.ImportDate;
        return s;

    }


}