package entity.inventory;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Entity class for dairy soy.
 */


public class HasFreshness extends Inventory implements Serializable {
    private String freshness;
    private final int ImportDate;


    /**
     * Construct an instance of Material
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param freshness The freshness of the Material
     * @param ImportDate The ImportDate of the Material
     */

    public HasFreshness(String name, double price, int quantity, String freshness,
                        int ImportDate){
        super(name, price, quantity);
        this.freshness = freshness;
        this.ImportDate = ImportDate;

    }


    /**
     * Change the freshness status of a Material
     * @param NewFreshness The new freshness status of this Material
     */

    public void setFreshness(String NewFreshness){
        this.freshness = NewFreshness;
    }

    /**
     *
     * @return the string representation of the inventory item
     */
    @NonNull
    @Override
    public String toString(){
        return super.name+ ","+ this.price +
                ","+ this.quantity +","+ this.freshness+","+ this.ImportDate;

    }

    /**
     * @param o object to compare to
     * @return true if contents of inventory item (name, quantity, price, etc.) are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HasFreshness)) return false;
        HasFreshness that = (HasFreshness) o;
        return usedUp == that.usedUp && Double.compare(that.price, price) == 0 && quantity == that.quantity && ImportDate == that.ImportDate && Objects.equals(name, that.name) && Objects.equals(freshness, that.freshness);
    }

}

