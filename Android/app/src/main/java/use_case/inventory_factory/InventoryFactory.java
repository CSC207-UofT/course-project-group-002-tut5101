package use_case.inventory_factory;
import entity.inventory.*;
/**
 * Use Case class for creating inventory of different type.
 */
public class InventoryFactory {
    /**
     * Use getInventory method to get the inventory by a string array.
     *  @param paras the array of parameters for creating an inventory item
     */
    public Inventory getInventory(String[] paras){
        if(paras.length == 5){
                String name = paras[0];
                double price = Double.parseDouble(paras[1]);
                int quantity = Integer.parseInt(paras[2]);
                String freshness = paras[3];
                int importdate = Integer.parseInt(paras[4]);
                return new HasFreshness(name, price, quantity, freshness, importdate);
            }

        else if(paras.length == 4){
                String name = paras[0];
                double price = Double.parseDouble(paras[1]);
                int quantity = Integer.parseInt(paras[2]);
                int expiry = Integer.parseInt(paras[3]);
                return new HasExpiryDate(name, price, quantity, expiry);
            }
        return null;
    }
    }
