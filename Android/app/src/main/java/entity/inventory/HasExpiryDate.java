package entity.inventory;



import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Entity class for alcohol.
 */

public class HasExpiryDate extends Inventory implements Serializable {

    private final int ExpiryDate;

    /**
     * Construct an instance of Product
     * @param name The name of the Inventory
     * @param price The buy in price of the Inventory
     * @param quantity The quantity of the Inventory
     * @param ExpiryDate The ExpiryDate of the Product
     */

    public HasExpiryDate(String name, double price, int quantity, int ExpiryDate){
        super(name, price, quantity);
        this.ExpiryDate = ExpiryDate;
        this.usedUp = quantity == 0;
    }



    /**
     *
     * @return the string representation of the inventory item
     */
    @Override
    @NonNull
    public String toString(){
        return this.name+ ","+ this.price +
                ","+ this.quantity +","+ this.ExpiryDate;

    }

    /**
     *
     * @param o object to compare to
     * @return true if contents of inventory item (name, quantity, price, etc.) are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HasExpiryDate)) return false;
        HasExpiryDate that = (HasExpiryDate) o;
        return usedUp == that.usedUp && Double.compare(that.price, price) == 0 && quantity == that.quantity && ExpiryDate == that.ExpiryDate && Objects.equals(name, that.name);
    }

}


